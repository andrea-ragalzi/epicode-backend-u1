package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    void testToString() {
        // Creazione di un oggetto Customer
        Customer customer = new Customer(1L, "Mario Rossi", 1);

        // Test del metodo toString()
        String customerStr = customer.toString();
        String expectedStr = "Customer{id=1, name='Mario Rossi', tier=1}";
        Assertions.assertEquals(expectedStr, customerStr);
    }
}
