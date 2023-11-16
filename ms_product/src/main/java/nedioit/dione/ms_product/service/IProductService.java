package nedioit.dione.ms_product.service;


import nedioit.dione.ms_product.dto.ProductRequest;
import nedioit.dione.ms_product.dto.ProductResponse;
import nedioit.dione.ms_product.entities.Product;

import java.util.List;

public interface IProductService {

    ProductResponse add(ProductRequest productRequest);

    public ProductResponse getProductById(Long id);

    List<ProductResponse> getAllProducts();






}
