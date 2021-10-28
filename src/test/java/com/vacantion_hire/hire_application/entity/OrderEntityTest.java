package com.vacantion_hire.hire_application.entity;

import com.vacation_hire.hire_application.entity.Order;
import com.vacation_hire.hire_application.entity.Vehicle;
import com.vacation_hire.hire_application.entity.VehicleOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderEntityTest {
    Order<Vehicle> order;

    @BeforeEach
    void setUp() {
        order = new VehicleOrder();
    }

    @Test
    @DisplayName("Testing method SetRentingDate")
    void testUserInputForMethodSetRentingDate() {
        assertEquals(true, order.setRentingDate("25/10/2021"), "input '25/10/2021' should return true");
        assertEquals(false, order.setRentingDate("25-10-2021"), "input '25-10-2021' should return false");
        assertEquals(true, order.setRentingDate("10/25/2021"), "input '10/25/2021' should return true");
        assertEquals(true, order.setRentingDate("2021/10/25"), "input '2021/10/25' should return true");
        assertEquals(false, order.setRentingDate("10/2021"), "input '10/2021' should return false");
        assertEquals(false, order.setRentingDate("2021"), "input '2021' should return false");
        assertEquals(false, order.setRentingDate(""), "input '' should return false");
        assertEquals(false, order.setRentingDate(null), "input null should return false");
    }
}
