package com.example;

public class Product {
    private Long id;
    private String name;
    private String category;
    private Double price;

    public Product(Long id, String name, String category, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return this.category;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(int discount) {
        this.price = this.price - this.price * (discount / 100.0);
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name='" + name + "', " +
                "category='" + category + "', price=" + price + '}';
    }

}
