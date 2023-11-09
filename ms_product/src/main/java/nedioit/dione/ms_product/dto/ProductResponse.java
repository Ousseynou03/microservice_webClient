package nedioit.dione.ms_product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nedioit.dione.ms_product.entities.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    private Long id;
    private String productName;
    private String category;
    private double price;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.category = product.getCategory();
        this.price = product.getPrice();
    }
}
