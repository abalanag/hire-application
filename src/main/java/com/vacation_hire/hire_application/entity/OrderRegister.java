package com.vacation_hire.hire_application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRegister {
    private ArrayList<Order> orders;

    /**
     * This method will show all the orders that are sored into the orderList reference.
     * Will be displayed the order number, which represents the index of the object sored in the list,
     * customer name, customer phone number, car type, and order status (rented, not rented, or returned)
     *
     * @return - the method will return true if the list it's not empty and false if the list is empty
     */
    public Boolean showListOfActiveOrders() {
        System.out.println("-------------------------------------------------------|Orders List|-------------------------------------------------------");
        System.out.println("Order number | Customer name | Customer phone number | Rented Date | Vehicle type | Order Status | Car damaged | Gasoline filled up");
        if (orders != null && !orders.isEmpty()) {
            for (int o = 0; o <= orders.size() - 1; o++) {
                System.out.println(o + " | " + orders.get(o).getCustomer().toString() + " | "
                        + orders.get(o).getDate() + " | "
                        + orders.get(o).receiveHiredObject().toString());
            }
            return true;
        }
        return false;
    }

    /**
     * Method used to retrieve an order by sending the order id through the command line.
     * The value that it is received from the user needs to be a number, that is smaller than the list size-1.
     * This method will return the order to which the number corresponds to the id.
     *
     * @param orderNumber - String value received through command line
     * @return - method returns the order represented by the id that was passed by the user.
     */
    public Order receiveOrderByOrderNumber(final String orderNumber) {
        try {
            if (!(orderNumber.matches("^[0-9]*$"))) {
                System.out.println("Please insert a valid number");
                return null;
            } else if (Integer.parseInt(orderNumber) >= orders.size()) {
                System.out.println("There is no opened order with that number, please type a valid order number.");
                return null;
            } else {
                int intOrderNumber = Integer.parseInt(orderNumber);
                return orders.get(intOrderNumber);
            }
        } catch (NullPointerException e) {
            // log error
            return null;
        }
    }

    /**
     * This method will show all the orders that are created and stored into the orderList property. The information that is shown is the following:
     * Customer name, customer phone number, car rented to date, the car type, order status (Not rented, rented, or returned), if the gasoline was filled up
     * or not and if the car was damaged or not.
     */
    public void showAllOrders() {
        System.out.println("-------------------------------------------------------|Orders List|-------------------------------------------------------");
        System.out.println("Customer name | Customer phone number | Rented Date | Vehicle type | Order Status | Car damaged | Gasoline filled up");
        for (Order o : orders) {
            System.out.println(o.getCustomer().toString() + " | " + o.getDate() + " | " + o.receiveHiredObject().toString());
        }
    }
}
