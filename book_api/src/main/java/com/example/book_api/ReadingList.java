package com.example.book_api;
import java.util.ArrayList;
import java.util.List;

public class ReadingList {

    private class BookItem {
        Book book;
        String dateRead;
        int rating;
        public BookItem(Book book, String dateRead, int rating) {
            this.book = book;
            this.dateRead = dateRead;
            this.rating = rating;
        }
    }
    private static ArrayList<BookItem> bookItems = new ArrayList<>();
    public ReadingList() {}

    public List<Book> getBooks() {
        List<Book> result = new ArrayList<>();
        for(BookItem item : bookItems) {
            result.add(item.book);
        }
        return result;
    }

    public void addBook(Book book, String dateRead, int rating) {
        this.bookItems.add(new BookItem(book, dateRead, rating));
    }

    public int numberRead() {
        return this.bookItems.size();
    }

    public void removeBook(final String title) {
        for(BookItem item : bookItems) {
            if (item.book.title.equals(title)) {
                bookItems.remove(item);
                break;
            }
        }
    }

    public List<Book> getBooksByRating(int rating) {
        List<Book> result = new ArrayList<>();
        for(BookItem item : bookItems) {
            if(item.rating == rating) {
                result.add(item.book);
            }
        }
        return result;
    }
}