package com.vacantion_hire.hire_application.entity;

import com.vacation_hire.hire_application.entity.*;
import com.vacation_hire.hire_application.entity.vehicles.Car;
import com.vacation_hire.hire_application.enums.CarTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OrderRegisterEntityTest {
    OrderRegister orderRegister;
    Order<Vehicle> order = new VehicleOrder(new Date(), new Customer("Ion","0712345678"), new Car(false,CarTypes.MINIVANS));

    @BeforeEach
    void setUp() {
        orderRegister = new OrderRegister(new ArrayList<>());
        orderRegister.getOrders().add(order);
    }

    @Test
    @DisplayName("Testing method SetRentingDate")
    void testUserInputForMethodShowListOfActiveOrders() {
        assertEquals(true, orderRegister.showListOfActiveOrders(), "input '25/10/2021' should return true");
        assertEquals(false, new OrderRegister().showListOfActiveOrders(), "input '25/10/2021' should return true");
        assertEquals(false, new OrderRegister(new ArrayList<>()).showListOfActiveOrders(), "input '25/10/2021' should return true");
        assertEquals(false, new OrderRegister(null).showListOfActiveOrders(), "input '25/10/2021' should return true");
    }

    @Test
    @DisplayName("Testing method SetRentingDate")
    void testUserInputForMethodReceiveOrderByOrderNumber() {
        assertEquals(order, orderRegister.receiveOrderByOrderNumber("0"), "1");
        assertNull(new OrderRegister().receiveOrderByOrderNumber("0"), "2");
        assertNull(new OrderRegister(new ArrayList<>()).receiveOrderByOrderNumber("0"), "3");
        assertNull(new OrderRegister(null).receiveOrderByOrderNumber("0"), "4");
        assertNull(orderRegister.receiveOrderByOrderNumber("1"), "5");
    }
}
