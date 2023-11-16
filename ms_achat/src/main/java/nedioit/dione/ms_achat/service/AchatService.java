package nedioit.dione.ms_achat.service;

import nedioit.dione.ms_achat.dto.AchatRequest;
import nedioit.dione.ms_achat.dto.AchatResponse;
import nedioit.dione.ms_achat.entities.Achat;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AchatService {

    AchatResponse addAchat(AchatRequest achatRequest);

    List<Achat> getAllAchat();

}
