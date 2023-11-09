package nedioit.dione.ms_achat.service;

import nedioit.dione.ms_achat.dto.AchatRequest;
import nedioit.dione.ms_achat.dto.AchatResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface AchatService {

    AchatResponse addAchat(@RequestBody(required = true) AchatRequest achatRequest);

}
