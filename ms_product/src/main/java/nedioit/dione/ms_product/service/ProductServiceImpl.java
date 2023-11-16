package nedioit.dione.ms_product.service;

import jakarta.persistence.EntityNotFoundException;
import nedioit.dione.ms_product.dto.ProductRequest;
import nedioit.dione.ms_product.dto.ProductResponse;
import nedioit.dione.ms_product.entities.Product;
import nedioit.dione.ms_product.mapper.ProductMapper;
import nedioit.dione.ms_product.repository.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public ProductResponse getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return productMapper.fromProduct(optionalProduct.get());
        }else {
            throw new EntityNotFoundException("Prodcut with id " +id+ " not found");
        }
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        Sort sortById = Sort.by(Sort.Direction.DESC, "id");
        List<Product> products = productRepository.findAll(sortById);
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product p : products){
            productResponses.add(productMapper.fromProduct(p));
        }

        return productResponses;
    }

/*    @Override
    public List<Product> getAllProducts() {

        List<Product> productList = productRepository.findAll();
        return productList;
    }*/
}
