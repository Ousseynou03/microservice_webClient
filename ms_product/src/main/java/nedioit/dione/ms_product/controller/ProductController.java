package nedioit.dione.ms_product.controller;


import nedioit.dione.ms_product.dto.ProductRequest;
import nedioit.dione.ms_product.dto.ProductResponse;
import nedioit.dione.ms_product.entities.Product;
import nedioit.dione.ms_product.service.IProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable("id") Long id){
        return iProductService.getProductById(id);
    }


/*    @GetMapping("/")
    public List<Product> getAllProduct(){
        return iProductService.getAllProducts();
    }*/

    @GetMapping("/")
    public List<ProductResponse> getAllProducts() {
        return iProductService.getAllProducts();
    }


}
