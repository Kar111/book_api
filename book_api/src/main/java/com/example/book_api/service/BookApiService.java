package com.example.book_api.service;

import com.example.book_api.Book;
import com.example.book_api.ReadingList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookApiService {
    public Book save(String name, String author, int year, int length, String dataRead, int rating) {
            Book book = new Book(name, author, length, year);
            ReadingList readingList = new ReadingList();
            readingList.addBook(book, dataRead, rating);
            return book;
    }

    public List<Book> getBooks() {
        ReadingList readingList = new ReadingList();
        return readingList.getBooks();
    }

    public void removeTheBook(String bookName) {
        ReadingList readingList = new ReadingList();
        readingList.removeBook(bookName);
    }

    public Book update(String name, String author, int year, int length, String dateRead, int rating) {
        removeTheBook(name);
        return  save(name, author, year, length, dateRead, rating);
    }
}
