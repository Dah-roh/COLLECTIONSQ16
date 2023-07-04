package org.example;

import org.example.Models.User;
import org.example.Models.UserDTO;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class PQueue {
    PriorityQueue<UserDTO> mapPriorityQueue =  new PriorityQueue(10, new UserDTO());
    HashMap<String, PriorityQueue<UserDTO>> productAndPriorityQueue;
    Queue<User> userQueue =  new PriorityQueue<>();

    public void addCustomerToQueue(User user){
        user.getCartItems().forEach(product -> {

            productAndPriorityQueue = productAndPriorityQueue==null
                    ?new HashMap<>():productAndPriorityQueue;

                    UserDTO userDTO = new UserDTO(user, product);

                    if (productAndPriorityQueue.get(product.getProductName())==null){
                        mapPriorityQueue.add(userDTO);
                        userQueue.add(user);
                        productAndPriorityQueue.put(product.getProductName(), mapPriorityQueue);
                    }else {
                        productAndPriorityQueue.get(product.getProductName()).add(userDTO);
                    }
        });
    }
    public void checkOut(Queue<User> userQueue){
        User user = userQueue.peek();
        user.getCartItems().forEach(product -> {
            while(mapPriorityQueue.peek()!=null){
                productAndPriorityQueue.get(product.getProductName()).peek();
            }
        });
    }


}
