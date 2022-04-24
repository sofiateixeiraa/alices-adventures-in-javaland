package test;

import jframe.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getId() {
        User user = new User();
        user.setId(12);
        assertEquals(12, user.getId());
    }

    @Test
    void getName() {
        User user = new User();
        user.setName("TINA");
        assertEquals("TINA", user.getName());
    }

    @Test
    void getEmail() {
        User user = new User();
        user.setEmail("TINA");
        assertEquals("TINA", user.getEmail());
    }

    @Test
    void getPhoneNumber() {
        User user = new User();
        user.setPhoneNumber(123);
        assertEquals(123, user.getPhoneNumber());
    }

    @Test
    void getNoBorrowedBooks() {
        User user = new User();
        user.setNoBorrowedBooks(12);
        assertEquals(12, user.getNoBorrowedBooks());
    }

    @Test
    void getPassword() {
        User user = new User();
        user.setPassword("TINA");
        assertEquals("TINA", user.getPassword());
    }
}