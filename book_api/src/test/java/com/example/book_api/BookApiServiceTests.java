package com.example.book_api;

import com.example.book_api.service.BookApiService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookApiServiceTests {

    //1. When I enter the title, author, year of publication,
    // and length of the book into the UI and hit submit, my book will be saved to the list.
    @Test
    public void BookWillBeSavedGivenTitleAuthorYearLength() {
        //SETUP
        ReadingList readingList = new ReadingList();
        BookApiService bookService = new BookApiService();
        String title = "The Hobbit";
        String author = "J.R.R. Tolkien";
        String dateRead = "March 25, 2022";
        int rating = 5;
        int length = 365;
        int year = 1937;


        //EXECUTE
        bookService.save(title, author, year, length, dateRead, rating);

        //ASSERT

        Assertions.assertEquals(1, readingList.getBooks().size());
    }

    //AC2. When I click “View All Books” the application will display a list of all the books in my list.

    @Test
    public void GetAllTheBooksShouldReturnAllSavedBooks() {
        //SETUP
        ReadingList readingList = new ReadingList();
        BookApiService bookService = new BookApiService();
        String title = "The Hobbit";
        String author = "J.R.R. Tolkien";
        String dateRead = "March 25, 2022";
        int rating = 5;
        int length = 365;
        int year = 1937;

        String title1 = "1984";
        String author1 = "George Orvel";
        String dateRead1 = "March 11, 2022";
        int rating1 = 5;
        int length1 = 310;
        int year1 = 2013;

        bookService.save(title, author, year, length, dateRead, rating);
        bookService.save(title1, author1, year1, length1, dateRead1, rating1);


        //EXECUTE

        List<Book> books = bookService.getBooks();

        //ASSERT

        Assertions.assertEquals(2, books.size());
    }

    //AC3:When I click the checkbox next to a book, and then the press the “Delete Book” button, the application will remove the book from my list.
    @Test
    public void DeleteBookByNameShouldRemoveTheBookFromTheList() {
        //SETUP
        ReadingList readingList = new ReadingList();
        BookApiService bookService = new BookApiService();
        String title = "The Hobbit";
        String author = "J.R.R. Tolkien";
        String dateRead = "March 25, 2022";
        int rating = 5;
        int length = 365;
        int year = 1937;

        bookService.save(title, author, year, length, dateRead, rating);

        //EXECUTE

        bookService.removeTheBook(title);

        //ASSERT

        Assertions.assertEquals(0, readingList.getBooks().size());
    }

    //AC4: When I click the checkbox next to a book, and then press the “Update Book” button, the application will allow me to update any of the information about the book.
    //Let's assume that the title is the book id, so we can update everything except for the title.

    @Test
    public void BookWillBeUpdatedGivenTitleAsBookId() {
        //SETUP
        ReadingList readingList = new ReadingList();
        BookApiService bookService = new BookApiService();
        String title = "The Hobbit";
        String author = "J.R.R. Baider";
        String dateRead = "March 25, 2022";
        int rating = 5;
        int length = 365;
        int year = 1927;

        String newAuthor = "J.R.R. Tolkien";
        String newDateRead = "March 11, 2022";
        int newRating = 4;
        int newLength = 310;
        int newYear = 1937;

        bookService.save(title, author, year, length, dateRead, rating);

        //EXECUTE

        bookService.update(title, newAuthor, newYear, newLength, newDateRead, newRating);
        Book book = bookService.getBooks().get(0);

        //ASSERT

        Assertions.assertEquals(newAuthor, book.getAuthor());
        Assertions.assertEquals(newYear, book.getYear());
        Assertions.assertEquals(newLength, book.getLength());

    }
}
