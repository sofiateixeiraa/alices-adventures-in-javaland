package test;

import jframe.Admin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {

    @Test
    void testGetNameOK() {
        Admin admin  = new Admin();
        admin.setName("TINA");
        assertEquals("TINA",admin.getName());
    }

    @Test
    void getEmail() {
        Admin admin  = new Admin();
        admin.setEmail("TINA");
        assertEquals("TINA",admin.getEmail());
    }

    @Test
    void getPhoneNumber() {
        Admin admin  = new Admin();
        admin.setPhoneNumber(123);
        assertEquals(123,admin.getPhoneNumber());
    }

    @Test
    void getPassword() {
        Admin admin  = new Admin();
        admin.setPassword("TINA");
        assertEquals("TINA",admin.getPassword());
    }
}