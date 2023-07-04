package org.example.Models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private String productName;
    private BigDecimal productPrice;
    private Long quantity;
}
