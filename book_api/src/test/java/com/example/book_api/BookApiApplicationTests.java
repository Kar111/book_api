package com.example.book_api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookApiApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void onFirstCallBookListShouldBeEmpty()
    {
        //SETUP
        ReadingList cut = new ReadingList();

        //EXECUTE
        List<Book> bookList = cut.getBooks();
        //ASSERT
        assertEquals(bookList.size(), 0);
    }

    //2. Given that I have an empty list, when I add the first book to my list then I expect `numberRead` to return 1.
    @Test
    public void onFirstBookAddedNumberReadShouldReturnOne() {
        //SETUP
        ReadingList cut  = new ReadingList();
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 320, 1937);

        //EXECUTE
        cut.addBook(book, "January 26, 2022", 5);
        int actual  = cut.numberRead();

        //ASSERT
        assertEquals(1, actual);
    }

    //3. Given that I have an empty list, when I add additional books to the list I expect the `numberRead` to return the total number of books in my list.
    @Test
    public void numberReadShouldReturnTheNumberOfReadBooks() {
        //SETUP
        ReadingList cut  = new ReadingList();
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 320, 1937);
        Book book2 = new Book("The Power of Thinking Without Thinking", "Malcolm Gladwell", 310, 2005);
        Book book3 = new Book("Jane Eyre", "Charlotte Bronte", 532, 1847);

        //EXECUTE
        cut.addBook(book1, "January 26, 2022", 5);
        cut.addBook(book2, "March 25, 2022", 3);
        cut.addBook(book3, "January 11, 2015", 4);
        int actual  = cut.numberRead();

        //ASSERT
        assertEquals(3, actual);
    }

    //4. Given that I have a book in my list, when I call `removeBook("<title>")` with "title" representing the title of my book that I want to delete,
    // then when I call `getBooks()` the book I deleted should no longer be there.
    @Test
    public void removeBookShouldRemoveTheBookFromReadList() {
        //SETUP
        ReadingList cut  = new ReadingList();
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 320, 1937);
        cut.addBook(book1, "January 26, 2022", 5);

        //EXECUTE
        cut.removeBook("The Hobbit");

        //ASSERT
        assertEquals(0, cut.getBooks().size());
    }

    //5. Given that I have an empty list, when I add a new book I expect `getBooks()` to return a list of books that includes the book I added.
    @Test
    public void getBooksReturnsListWhichIncludesTheNewlyAddedBook() {
        //SETUP
        ReadingList cut  = new ReadingList();
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 320, 1937);
        cut.addBook(book1, "January 26, 2022", 5);

        //EXECUTE
        List<Book> books = cut.getBooks();

        //ASSERT
        assertEquals("The Hobbit", books.get(0).title);
    }

    //6. Given when I call `getBooksByRating()`, I should return a list of books that all have that rating.
    @Test
    public void getBooksByRatingShouldReturnAllBooksWithTheSameRating() {
        //SETUP
        ReadingList cut  = new ReadingList();
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 320, 1937);
        Book book2 = new Book("The Power of Thinking Without Thinking", "Malcolm Gladwell", 310, 2005);
        Book book3 = new Book("Jane Eyre", "Charlotte Bronte", 532, 1847);
        cut.addBook(book1, "January 26, 2022", 5);
        cut.addBook(book2, "March 25, 2022", 3);
        cut.addBook(book3, "January 11, 2015", 5);

        //EXECUTE
        List<Book> books = cut.getBooksByRating(5);

        //ASSERT
        assertEquals(2, books.size());
    }
}
