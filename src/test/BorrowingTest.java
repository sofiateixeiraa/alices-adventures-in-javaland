package test;

import jframe.Book;
import jframe.Borrowing;
import jframe.User;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class BorrowingTest {

    @Test
    void getId() {
        Borrowing borrowing = new Borrowing();
        Book book = new Book();
        borrowing.setBook(book);
        assertEquals(book, borrowing.getBook());
    }

    @Test
    void getStartPeriod() {
        Borrowing borrowing = new Borrowing();
        borrowing.setStartPeriod("2020-12-03");
        assertEquals("2020-12-03", borrowing.getStartPeriod());
    }

    @Test
    void getEndPeriod() {
        Borrowing borrowing = new Borrowing();
        Timestamp timestamp = new Timestamp(0);
        assertEquals("2020-12-03", borrowing.getEndPeriod());
    }

    @Test
    void getStatus() {
        Borrowing borrowing = new Borrowing();
        borrowing.setStatus("status");
        assertEquals("status", borrowing.getStatus());
    }

    @Test
    void getUser() {
        Borrowing borrowing = new Borrowing();
        User user = new User();
        borrowing.setUser(user);
        assertEquals(user, borrowing.getUser());
    }

    @Test
    void getBook() {
        Borrowing borrowing = new Borrowing();
        Book book = new Book();
        borrowing.setBook(book);
        assertEquals(book, borrowing.getBook());
    }

    @Test
    void getDeliveryDate() {
        Borrowing borrowing = new Borrowing();
        borrowing.setDeliveryDate("2020-12-03");
        assertEquals("2020-12-03", borrowing.getDeliveryDate());
    }
}