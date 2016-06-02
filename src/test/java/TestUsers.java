import model.Users;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.*;
import org.mockito.Mockito;

public class TestUsers {
    Users customer;

    @Before
    public void setUp() {
       // customer = new Users("firstName", "secondName", "email", "phoneNumber");
    }

    @Test
    public void testGetFirstName() {
        assertEquals("firstName", customer.getFirstName());
    }

    @Test
    public void testGetSecondName() {
        assertEquals("secondName", customer.getSecondName());
    }

    @Test
    public void testGetEmail() {
        assertEquals("email", customer.getEmail());
    }

    @Test
    public void testGetPhoneNumber() {
        assertEquals("phoneNumber", customer.getPhoneNumber());
    }


    /**
     * Email
     */
    @Test
    public void testSetNullEmail() {
        customer.setEmail(null);
    }

    @Test
    public void testSetBlankEmail() {
        customer.setEmail("");
    }

    @Test
    public void testSetEmail() {
        customer.setEmail("newEmail");
        assertEquals("newEmail", customer.getEmail());
    }


    /**
     * PhoneNumber
     */


    @Test
    public void testSetNullPhoneNumber() {
        customer.setPhoneNumber(null);
    }

    @Test
    public void testSetBlankPhoneNumber() {
        customer.setPhoneNumber("");
    }

    @Test
    public void testSetPhoneNumber() {
        customer.setPhoneNumber("056");
        assertEquals("056", customer.getPhoneNumber());
    }

    /**
     * FirstName
     */

    @Test
    public void testSetGetFirstName() {
        customer.setFirstName("name");
        assertEquals("name", customer.getFirstName());
    }

    /**
     * SecondName
     */
    @Test
    public void testSetGetSecondName() {
        customer.setSecondName("name");
        assertEquals("name", customer.getSecondName());
    }

    @Test
    public void testSetGetId() {
        customer.setId(5);
        assertEquals(5, customer.getId());
    }


}