package com.vacation_hire.hire_application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String name;
    private String phoneNumber;

    /**
     * Method used for adding customer's name. This method will check if the customer name has at least 3 characters.
     * The method will run in a loop until the user will type a name that will satisfy the condition.
     * Whenever the input value is invalid will return false, will be shown an error message and, the method will be called again from the Application Class.
     * The input will be stored in the name property.
     *
     * @param name - String value received through command line
     * @return - will return a boolean value, depending on the user input (true of the value can be evaluated and false if not)
     */
    public Boolean addCustomerName(final String name) {

        if (name != null && name.length() >= 3) {
            this.name = name;
            return true;
        } else {
            System.err.println("The name should contain minimum 3 characters.");
            return false;
        }
    }

    /**
     * Method used for adding customer's phone number. This method will check if the customer's phone number has at least 4 characters and contains only numbers.
     * The method will run in a loop until the user will type a name that will satisfy the condition.
     * Whenever the input value is invalid will return false, will be shown an error message and, the method will be called again from the Application Class.
     * The input will be stored into the phoneNumber property.
     *
     * @param phoneNumber - String value received through command line
     * @return - will return a boolean value, depending on the user input (true of the value can be evaluated and false if not)
     */
    public Boolean addCustomerPhoneNumber(final String phoneNumber) {
        if (phoneNumber != null && phoneNumber.length() >= 4 && phoneNumber.matches("^[0-9]*$")) {
            this.phoneNumber = phoneNumber;
            return true;
        } else {
            System.err.println("The phone number should contain minimum 4 characters and only numbers");
            return false;
        }
    }

    /**
     * Method used to print information about the customer.
     *
     * @return - will return a concatenated string that will contain the name and the phone number of the customer.
     */
    @Override
    public String toString() {
        return name + " | " + phoneNumber;
    }
}
