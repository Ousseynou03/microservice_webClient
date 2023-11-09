package nedioit.dione.ms_product.mapper;


import nedioit.dione.ms_product.dto.ProductRequest;
import nedioit.dione.ms_product.dto.ProductResponse;
import nedioit.dione.ms_product.entities.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public ProductResponse fromProduct(Product product){
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }

    public  Product fromProductRequest(ProductRequest productRequest){
        Product product = new Product();
        BeanUtils.copyProperties(productRequest, product);
        return product;
    }
}
