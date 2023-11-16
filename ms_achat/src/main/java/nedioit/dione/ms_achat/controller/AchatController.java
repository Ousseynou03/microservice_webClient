package nedioit.dione.ms_achat.controller;


import nedioit.dione.ms_achat.dto.AchatRequest;
import nedioit.dione.ms_achat.dto.AchatResponse;
import nedioit.dione.ms_achat.entities.Achat;
import nedioit.dione.ms_achat.service.AchatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/")
    public List<Achat> getAllAchat(){
        return achatService.getAllAchat();
    }


}
