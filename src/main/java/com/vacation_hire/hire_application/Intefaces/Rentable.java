package com.vacation_hire.hire_application.Intefaces;

import com.vacation_hire.hire_application.enums.OrderStatus;

public interface Rentable {

    /**
     * Method is used to update the status of the object that was hired, more exactly if the object was damaged or not.
     *
     * @param input - input received from the application user
     * @return - returning value represents the method response.
     * If the value typed by the user is ok and, it corresponds to one of the options
     * the returned value will be true, else will be false.
     */
    Boolean updateDamagingStatus(final String input) throws ClassCastException;

    /**
     * Method used for setting the order status of the object that is/was hired.
     *
     * @param orderStatus - input value is the type of the enum OrderStatus.
     */
    void setOrderStatus(final OrderStatus orderStatus);

    /**
     * Method used for setting the type of car is rented. It will receive a String as an input which represents the value typed by the user on the command line.
     * The value should represent the type name of the car that will be rented.
     * Method will check if the input from the user is valid and if it is, will return true, else will return false.
     *
     * @param vehicleType - String value received through command line representing the type of car
     * @return - will return a boolean value, depending on the user input (true of the value can be evaluated and false if not)
     */
    Boolean setType(final String vehicleType);

    /**
     * Method used for getting the type of object that was rented.
     *
     * @return - the type of car that was rented.
     */
    String getType();

    /**
     * This method should return a concatenated string on which you can find all the information about an order (order status, object status, etc.)
     *
     * @return - return a concatenated string
     */
    String toString();

    /**
     * This method will return a string that concatenates all the information about a vehicle. Fuel level (if it is the case), order status, vehicle status, and the vehicle type.
     *
     * @param toString - this method will receive the returned value of the method toString
     * @return - will return all the properties values that are stored in a vehicle
     */
    String toString(final String toString);
}
