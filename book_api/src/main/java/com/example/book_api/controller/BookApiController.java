package com.example.book_api.controller;

import com.example.book_api.Book;
import com.example.book_api.service.BookApiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/books")
public class BookApiController {

    private final BookApiService bookApiService;

    public BookApiController(BookApiService bookApiService) {
        this.bookApiService = bookApiService;
    }

    @PostMapping(path = "/{name}/{author}/{year}/{length}/{dateRead}/{rating}/")
    public Book saveNewBooks(@PathVariable String name,
                             @PathVariable String author,
                             @PathVariable int year,
                             @PathVariable int length,
                             @PathVariable String dateRead,
                             @PathVariable int rating) {
        return bookApiService.save(name, author, year, length, dateRead, rating);
    }

    @GetMapping()
    public List<Book> getBooks() {
        return bookApiService.getBooks();
    }

    @DeleteMapping(path = "{title}")
    public void deleteStudent(@PathVariable String title) {
        bookApiService.removeTheBook(title);
    }

    @PutMapping(path = "/{name}/{author}/{year}/{length}/{dateRead}/{rating}/")
    public Book updateTheOldBook(@PathVariable String name,
                             @PathVariable String author,
                             @PathVariable int year,
                             @PathVariable int length,
                             @PathVariable String dateRead,
                             @PathVariable int rating) {
        return bookApiService.update(name, author, year, length, dateRead, rating);
    }
}
