package org.example.Models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Product {
    private String productName;
    private Double productPrice;
    private Long quantity;

    public Product(String productName, double productPrice, Long quantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }
    public UserDTO generateUserDTO(){
        return new UserDTO();
    }
}
