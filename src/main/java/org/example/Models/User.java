package org.example.Models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User implements Comparable<User>{
    private String name;
    private String email;
    private String location;
    private String DOB;
    private List<Product> cartItems;

    @Override
    public int compareTo(User user) {
        return Integer.compare(cartItems.size(), user.getCartItems().size());
    }
}
