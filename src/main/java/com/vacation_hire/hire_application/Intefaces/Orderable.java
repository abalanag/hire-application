package com.vacation_hire.hire_application.Intefaces;

public interface Orderable {
    /**
     * Method used for setting the renting date.
     *
     * @param input - value of the type String send by the user true command line
     * @return will return a boolean value. If the data format from the user is correct, it will return true else will return false.
     */
    Boolean setRentingDate(final String input);

    /**
     * Method used to generate the order when a car is hired. Will return a message with information about the type of vehicle,
     * client contact information and, the date of when the order was placed.
     */
    void showOrder();
}
