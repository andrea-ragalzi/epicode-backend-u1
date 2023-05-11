package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    void testToString() {
        Product prod = new Product(1L, "Prodotto 1", "Categoria 1", 9.99);
        String prodStr = prod.toString();
        String expectedStr = "Product{id=1, name='Prodotto 1', category='Categoria 1', price=9.99}";
        Assertions.assertEquals(expectedStr, prodStr);
    }
}
