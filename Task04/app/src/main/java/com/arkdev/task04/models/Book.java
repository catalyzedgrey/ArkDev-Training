package com.arkdev.task04.models;

public class Book {
    String name, price;

    public Book(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
