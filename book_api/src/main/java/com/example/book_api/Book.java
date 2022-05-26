package com.example.book_api;

public class Book {
    String title;
    String author;
    int length;
    int year;
    public Book(String title, String author, int length, int year) {
        this.title = title;
        this.author = author;
        this.length = length;
        this.year = year;
    }

    public Book(){}
}
