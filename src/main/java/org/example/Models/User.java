package org.example.Models;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String name;
    private String email;
    private String location;
    private String DOB;
    private List<Product> cartItems;
}
