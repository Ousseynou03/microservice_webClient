package nedioit.dione.ms_product.controller;


import nedioit.dione.ms_product.dto.ProductRequest;
import nedioit.dione.ms_product.dto.ProductResponse;
import nedioit.dione.ms_product.service.IProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {


    private final IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping("/add")
    public ProductResponse addProduct(@RequestBody ProductRequest productRequest){
        return iProductService.add(productRequest);
    }


}
