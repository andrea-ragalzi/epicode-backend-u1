package com.example;

public class Customer {
    Long id;
    String name;
    int tier;

    public Customer(Long id, String name, Integer tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    public int getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name='" +
                name + "', tier=" + tier + '}';
    }
}
