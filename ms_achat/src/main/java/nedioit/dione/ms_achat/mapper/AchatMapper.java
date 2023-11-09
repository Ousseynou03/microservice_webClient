package nedioit.dione.ms_achat.mapper;

import nedioit.dione.ms_achat.dto.AchatRequest;
import nedioit.dione.ms_achat.dto.AchatResponse;
import nedioit.dione.ms_achat.entities.Achat;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AchatMapper {

    public AchatResponse fromAchat(Achat achat){
        AchatResponse achatResponse = new AchatResponse();
        BeanUtils.copyProperties(achat, achatResponse);
        return achatResponse;
    }

    public  Achat fromAchatRequest(AchatRequest achatRequest){
        Achat achat = new Achat();
        BeanUtils.copyProperties(achatRequest, achat);
        return achat;
    }
}
