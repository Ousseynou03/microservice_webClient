package nedioit.dione.ms_product.service;


import nedioit.dione.ms_product.dto.ProductRequest;
import nedioit.dione.ms_product.dto.ProductResponse;

public interface IProductService {

    ProductResponse add(ProductRequest productRequest);


}
