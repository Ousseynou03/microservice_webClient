package nedioit.dione.ms_product.service;

import nedioit.dione.ms_product.dto.ProductRequest;
import nedioit.dione.ms_product.dto.ProductResponse;
import nedioit.dione.ms_product.entities.Product;
import nedioit.dione.ms_product.mapper.ProductMapper;
import nedioit.dione.ms_product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponse add(ProductRequest productRequest) {
        try {
            Product product = productMapper.fromProductRequest(productRequest);
            productRepository.save(product);
            return productMapper.fromProduct(product);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
