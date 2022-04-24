package test;

import jframe.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;

class BookTest {

	
    @Test
    void getReference() {

        Book book = new Book();
        book.setReference(1);
        assertEquals(1, book.getReference());
    }

    @Test
    void getName() {
        Book book = new Book();
        book.setName("213");
        assertEquals("213", book.getName());
    }

    @Test
    void getAuthor() {
        Book book = new Book();
        book.setAuthor("213");
        assertEquals("213", book.getAuthor());
    }

    @Test
    void getPublication() {
        Book book = new Book();
        book.setPublication(213);
        assertEquals(213, book.getPublication());
    }

    @Test
    void getAdded() {
        Book book = new Book();
        book.setAdded(Timestamp.valueOf("2020-08-12 12:12:12.111"));
        assertEquals(Timestamp.valueOf("2020-08-12 12:12:12.111"), book.getAdded());
    }

    @Test
    void getStatus() {
        Book book = new Book();
        book.setStatus(213);
        assertEquals(213, book.getStatus());
    }

    @Test
    void getType() {
        Book book = new Book();
        book.setType(2);
        assertEquals(2, book.getType());
    }

    @Test
    void getTag() {
        Book book = new Book();
        book.setTag("213");
        assertEquals("213", book.getTag());
    }
}