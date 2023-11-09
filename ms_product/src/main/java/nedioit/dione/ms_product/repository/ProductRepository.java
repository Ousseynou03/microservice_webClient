package nedioit.dione.ms_product.repository;

import nedioit.dione.ms_product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
