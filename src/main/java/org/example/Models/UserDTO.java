package org.example.Models;

import lombok.Data;

import java.util.Comparator;

@Data
public class UserDTO implements Comparator<UserDTO> {
    private String userName;
    private Long productQuantity;

    public UserDTO(User user, Product product) {
        this.userName = user.getName();
        this.productQuantity = product.getQuantity();
    }

    public UserDTO() {
    }


    @Override
    public int compare(UserDTO userDTO, UserDTO t1) {
        if (t1.productQuantity> userDTO.productQuantity){
            return 1;
        } else if (t1.productQuantity< userDTO.productQuantity) {
            return -1;
        }
        return 0;
    }
}
