package org.example;

import org.example.Models.Product;
import org.example.Models.User;
import org.example.Models.UserDTO;
import java.util.*;
import java.util.function.Predicate;

public class PQueueFunctional {


    static PriorityQueue<UserDTO> mapPriorityQueue = new PriorityQueue<>(10, new UserDTO());

    //Below is a map holding String(name of a product) and PriorityQueue(a queue for users willing to buy aforementioned product)
    //e.g a line for people buying a specific product.
    static HashMap<String, PriorityQueue<UserDTO>> productPriorityQueueMap;
    static Queue<User> userQueue = new PriorityQueue<>();
    private static User user;
    private static final Predicate<String> isProductQueueAvailable = productName -> productPriorityQueueMap.get(productName)==null;

    public void addCustomerToQueue(User user1) {
        user = user1;
        user.getCartItems().forEach(PQueueFunctional::generateProductQueue);
        user = null;
    }

    private static void generateProductQueue(Product product) {
        productPriorityQueueMap = productPriorityQueueMap == null
                ? new HashMap<>() : productPriorityQueueMap;
        addToQueue(product);
    }

    private static void addToQueue(Product product) {
        UserDTO userDTO = product.generateUserDTO();
        userDTO.setUserName(user.getName());
        userDTO.setProductQuantity(product.getQuantity());
        if (isProductQueueAvailable.test(product.getProductName())) {
            mapPriorityQueue.add(userDTO);
            userQueue.add(user);
            productPriorityQueueMap.put(product.getProductName(), mapPriorityQueue);
        } else {
            productPriorityQueueMap.get(product.getProductName()).add(userDTO);
            userQueue.add(user);
        }
    }

    public void checkOut() {
        while (userQueue.peek() != null) {
            User user = userQueue.poll();
            user.getCartItems().forEach(PQueueFunctional::singleProductCheckOut);
        }
    }

    private static void singleProductCheckOut(Product product) {
        if (productPriorityQueueMap.get(product.getProductName()).peek() != null) {
            UserDTO customer = productPriorityQueueMap.get(product.getProductName()).poll();
            if (customer != null) {
                System.out.println(customer.getProductQuantity() + " of " + product.getProductName() +
                        " was just sold to " + customer.getUserName() + ". Thank you for your patronage! ");
            }
        }
    }

    public static void main(String[] args) {

        PQueueFunctional pQueueFunctional = new PQueueFunctional();

        List<Product> cartItems = Arrays.asList(new Product("Asus", 15.0, 12L),
                new Product("Blade of Miquella", 9.99, 18L));
        User user = User.builder().DOB("102 AD")
                .email("d@gmail.com").location("Lagos, Nigeria.").name("Gadibia").cartItems(cartItems).build();


        List<Product> cartItems1 = Arrays.asList(new Product("Asus", 15.0, 19L),
                new Product("Blade of Miquella", 9.99, 1L));
        User user1 = User.builder().DOB("102 AD")
                .email("d1@gmail.com").location("Lagos, Nigeria.").name("Gbia").cartItems(cartItems1).build();


        List<Product> cartItems2 = Arrays.asList(new Product("Asus", 15.0, 15L),
                new Product("Blade of Miquella", 9.99, 22L));
        User user2 = User.builder().DOB("102 AD")
                .email("d1@gmail.com").location("Lagos, Nigeria.").name("Amos").cartItems(cartItems2).build();

        pQueueFunctional.addCustomerToQueue(user);
        pQueueFunctional.addCustomerToQueue(user1);
        pQueueFunctional.addCustomerToQueue(user2);

        System.out.println(userQueue);
        pQueueFunctional.checkOut();
    }
}
