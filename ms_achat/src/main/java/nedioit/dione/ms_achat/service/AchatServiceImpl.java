package nedioit.dione.ms_achat.service;

import nedioit.dione.ms_achat.dto.AchatRequest;
import nedioit.dione.ms_achat.dto.AchatResponse;
import nedioit.dione.ms_achat.dto.ProductResponse;
import nedioit.dione.ms_achat.entities.Achat;
import nedioit.dione.ms_achat.mapper.AchatMapper;
import nedioit.dione.ms_achat.repository.AchatRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Currency;
import java.util.List;

@Service
public class AchatServiceImpl implements AchatService{

    private final AchatRepository achatRepository;
    private final AchatMapper achatMapper;
    private final WebClient webClient;

    public AchatServiceImpl(AchatRepository achatRepository, AchatMapper achatMapper, WebClient webClient) {
        this.achatRepository = achatRepository;
        this.achatMapper = achatMapper;
        this.webClient = webClient;
    }

    @Override
    public AchatResponse addAchat(AchatRequest achatReq) {
        Achat achat = achatMapper.fromAchatRequest(achatReq);
        //--------------------taux de change---------------
        nedioit.dione.ms_achat.dto.Currency currency = webClient.get()
                .uri("https://v6.exchangerate-api.com/v6/f8dcc0741adee2f1e11bcbdb/latest/"+achat.getCurrency())
                .retrieve()
                .bodyToMono(nedioit.dione.ms_achat.dto.Currency.class)
                .block();


        //-------------------------------------------------
        double tot = 0;
        for(Long p:achat.getProducts()){
            ProductResponse productResponse = webClient.get()
                    .uri("http://localhost:8085/api/product/"+p)
                    .retrieve()
                    .bodyToMono(ProductResponse.class)
                    .block();
            tot += productResponse.getPrice();
        }
        achat.setTotal(tot*currency.getConversion_rate());
        achat.setTotal(tot);
        achatRepository.save(achat);
        return achatMapper.fromAchat(achat);
    }

    @Override
    public List<Achat> getAllAchat() {
        List<Achat> achatList = achatRepository.findAll();
        return achatList;
    }
}
