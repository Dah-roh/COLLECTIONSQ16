package org.example.Models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Builder
public class User implements Comparable<User>{
    //MVP - Minimum Viable Product
    private String name;
    private String email;
    private String location;
    private String DOB;
    private List<Product> cartItems;

    @Override
    public int compareTo(User user) {
        if(this.getCartItems().size()>user.getCartItems().size()){
            return 1;
        } else if (this.getCartItems().size()<user.getCartItems().size()) {
         return -1;
        }
        else {
            return 0;
        }
//        return Integer.compare(cartItems.size(), user.getCartItems().size());
    }
}
