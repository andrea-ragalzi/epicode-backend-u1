package com.example;

import java.time.LocalDate;
import java.util.List;

/**
 * Hello world!
 */
public final class App {
        private App() {
        }

        public static void main(String[] args) {
                List<Product> products1 = List.of(
                                new Product(1L, "Pannolini", "Baby", 10.0),
                                new Product(2L, "Biberon", "Baby", 15.0),
                                new Product(3L, "Libro", "Books", 20.0),
                                new Product(4L, "Calze", "Boys", 40.0),
                                new Product(5L, "Barbie", "Boys", 48.0));

                List<Product> products2 = List.of(
                                new Product(6L, "Libro bello", "Books", 50.0),
                                new Product(7L, "Film a caso", "Movies", 30.0),
                                new Product(8L, "Libro brutto brutto", "Books", 150.0));

                Customer customer1 = new Customer(1L, "Mario Rossi", 1);
                Customer customer2 = new Customer(2L, "Luigi Bianchi", 2);

                Order order1 = new Order(
                                1L, "In attesa di spedizione", LocalDate.now(),
                                LocalDate.of(2021, 3, 1).plusDays(3), products1, customer1);

                Order order2 = new Order(
                                2L, "In attesa di consegna", LocalDate.now(),
                                LocalDate.now().plusDays(5), products2, customer2);

                List<Order> orders = List.of(order1, order2);

                List<Product> booksPrice100 = getProductsByPrice(
                                getProductsByCategory(products2, "Books"), 100.0);

                List<Order> babyOrders = getOrdersByCategory(orders, "Baby");

                List<Product> boysDiscount10 = applyDiscount(
                                getProductsByCategory(products1, "Boys"), 10);

                List<Customer> customers = List.of(customer1, customer2);

                LocalDate startDate = LocalDate.of(2021, 2, 1);
                LocalDate endDate = LocalDate.of(2021, 4, 1);

                List<Product> tier2Products = getProductsByTierAndDate(orders, startDate, endDate, 2);

                System.out.println("***** Es1 *****");
                System.out.println(booksPrice100);
                System.out.println();
                System.out.println("***** Es2 *****");
                System.out.println(babyOrders);
                System.out.println();
                System.out.println("***** Es3 *****");
                System.out.println(boysDiscount10);

                System.out.println("***** Es4 *****");
                System.out.println(tier2Products);
        }

        public static List<Product> getProductsByCategory(
                        List<Product> products, String category) {
                return products.stream()
                                .filter(product -> product.getCategory().equals(category))
                                .toList();
        }

        public static List<Product> getProductsByPrice(
                        List<Product> products, Double price) {
                return products.stream()
                                .filter(product -> product.getPrice() > price)
                                .toList();
        }

        public static List<Order> getOrdersByCategory(List<Order> orders, String category) {
                return orders.stream()
                                .filter(order -> order.getProducts()
                                                .stream()
                                                .anyMatch(product -> product.getCategory().equals(category)))
                                .toList();
        }

        public static List<Product> applyDiscount(List<Product> products, int discount) {
                return products.stream()
                                .map(product -> {
                                        product.setPrice(discount);
                                        return product;
                                })
                                .toList();
        }
}
