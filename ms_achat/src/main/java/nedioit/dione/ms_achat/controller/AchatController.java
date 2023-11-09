package nedioit.dione.ms_achat.controller;


import nedioit.dione.ms_achat.dto.AchatRequest;
import nedioit.dione.ms_achat.dto.AchatResponse;
import nedioit.dione.ms_achat.service.AchatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/achat")
public class AchatController {

    private AchatService achatService;

    public AchatController(AchatService achatService) {
        this.achatService = achatService;
    }


    @PostMapping("/add")
    public AchatResponse addAchat(@RequestBody(required = true)AchatRequest achatRequest){
        return achatService.addAchat(achatRequest);

    }
}
