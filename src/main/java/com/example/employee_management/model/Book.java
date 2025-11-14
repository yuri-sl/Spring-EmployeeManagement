package com.example.employee_management.model;


public class Book {
    private int id;
    public String title;
    public String author;
    public double price;

    public Book(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
