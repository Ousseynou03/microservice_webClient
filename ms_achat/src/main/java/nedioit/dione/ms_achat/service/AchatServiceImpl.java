package nedioit.dione.ms_achat.service;

import nedioit.dione.ms_achat.dto.AchatRequest;
import nedioit.dione.ms_achat.dto.AchatResponse;
import nedioit.dione.ms_achat.dto.ProductResponse;
import nedioit.dione.ms_achat.entities.Achat;
import nedioit.dione.ms_achat.mapper.AchatMapper;
import nedioit.dione.ms_achat.repository.AchatRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

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
    public AchatResponse addAchat(AchatRequest achatRequest) {
        try {
            Achat achat = achatMapper.fromAchatRequest(achatRequest);
            double tot = 0;
            for (Long p : achat.getProducts()){
                ProductResponse productResponse = webClient.get()
                        .uri("localhost:8085/api/product/"+p)
                        .retrieve()
                        .bodyToMono(ProductResponse.class)
                        .block();
                tot+= productResponse.getPrice();
            }
            achat.setTotal(tot);
            achatRepository.save(achat);
            return achatMapper.fromAchat(achat);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
