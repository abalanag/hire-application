package com.vacantion_hire.hire_application.entity;

import com.vacation_hire.hire_application.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerEntityTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
    }

    @Test
    @DisplayName("Testing method SetCarType")
    void testUserInputForMethodAddCustomerName() {
        assertEquals(true, customer.addCustomerName("Alin"), "input 'Alin' should return true");
        assertEquals(false, customer.addCustomerName("Io"), "input 'Io' should return false");
        assertEquals(false, customer.addCustomerName(""), "input '' should return false");
        assertEquals(false, customer.addCustomerName(null), "input null should return false");
    }

    @Test
    @DisplayName("Testing method UpdateCarStatus")
    void testUserInputForMethodAddCustomerPhoneNumbers() {
        assertEquals(true, customer.addCustomerPhoneNumber("0712345678"), "input '0712345678' should return true");
        assertEquals(true, customer.addCustomerPhoneNumber("0735"), "input '0735' should return true");
        assertEquals(false, customer.addCustomerPhoneNumber("073"), "input '073' should return false");
        assertEquals(false, customer.addCustomerPhoneNumber("0712345678a"), "input '0712345678a' should return false");
        assertEquals(false, customer.addCustomerPhoneNumber(""), "input '' should return false");
        assertEquals(false, customer.addCustomerPhoneNumber(null), "input null should return false");
    }
}
