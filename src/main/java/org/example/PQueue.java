package org.example;

import org.example.Models.Product;
import org.example.Models.User;
import org.example.Models.UserDTO;

import java.math.BigDecimal;
import java.util.*;

public class PQueue {
    static PriorityQueue<UserDTO> mapPriorityQueue = new PriorityQueue<>(10, new UserDTO());
    static HashMap<String, PriorityQueue<UserDTO>> productPriorityQueueMap;
    static PriorityQueue<User> userQueue = new PriorityQueue<>();
    static User user;

    public void addCustomerToQueue(User user1) {
        user = user1;
        user.getCartItems().forEach( product-> {
        productPriorityQueueMap = productPriorityQueueMap == null
                ? new HashMap<>() : productPriorityQueueMap;

        UserDTO userDTO = new UserDTO(user1, product);

        if (productPriorityQueueMap.get(product.getProductName()) == null) {
            mapPriorityQueue.add(userDTO);
            userQueue.add(user);
            productPriorityQueueMap.put(product.getProductName(), mapPriorityQueue);
        } else {
            productPriorityQueueMap.get(product.getProductName()).add(userDTO);
            userQueue.add(user);
        }
    });
    }

    public void checkOut(PriorityQueue<User> userQueue) {

        while (userQueue.peek() != null) {
            User user = userQueue.poll();
            user.getCartItems().forEach(product -> {
                if (productPriorityQueueMap.get(product.getProductName()).peek() != null) {
                    UserDTO customer = productPriorityQueueMap.get(product.getProductName()).poll();
                    assert customer != null;
                    System.out.println(customer.getProductQuantity() + " of " + product.getProductName() +
                            " was just sold to " + customer.getUserName() + ". Thank you for your patronage! ");
                }
            });
        }
    }

    public static void main(String[] args) {
        PQueue pQueue = new PQueue();

        List<Product> cartItems = Arrays.asList(new Product("Asus",15.0, 12L),
                new Product("Blade of Miquella", 9.99, 18L));
        User user = User.builder().DOB("102 AD")
                .email("d@gmail.com").location("Lagos, Nigeria.").name("Gadibia").cartItems(cartItems).build();

        List<Product> cartItems1 = Arrays.asList(new Product("Asus",15.0, 12L),
                new Product("Blade of Miquella",9.99, 1L));
        User user1 = User.builder().DOB("102 AD")
                .email("d1@gmail.com").location("Lagos, Nigeria.").name("Gbia").cartItems(cartItems1).build();

        pQueue.addCustomerToQueue(user);
        pQueue.addCustomerToQueue(user1);
        pQueue.checkOut(userQueue);
    }
}
