package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderTest {

    @Test
    void testToString() {
        // Creazione di un oggetto Order
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Prodotto 1", "Categoria 1", 9.99));
        products.add(new Product(2L, "Prodotto 2", "Categoria 1", 14.99));
        Customer customer = new Customer(1L, "Mario Rossi", 1);
        Order order = new Order(1L, "In attesa di spedizione", LocalDate.now(),
                LocalDate.now().plusDays(3), products, customer);

        // Test del metodo toString()
        String orderStr = order.toString();
        String expectedStr = "Order{id=1, status='In attesa di spedizione', " +
                "orderDate=" + LocalDate.now() + ", deliveryDate=" + LocalDate.now().plusDays(3) +
                ", products=[" + products.get(0) + ", " + products.get(1) + "], " +
                "customer=" + customer + "}";
        Assertions.assertEquals(expectedStr, orderStr);
    }
}
