package com.vacation_hire.hire_application.entity;

import com.vacation_hire.hire_application.Intefaces.Orderable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Order<T> extends OrderRegister implements Orderable {

    private Date date;
    private Customer customer;

    public Order(final Customer customer) {
        this.customer = customer;
    }

    /**
     * Method used to set the hire date.
     * The user will pass a date through the command line. For it to be converted from type String to type Date, it must respect a specific pattern 'dd/MM/yyyy.
     * This pattern can be changed by changing the parameter that is passed to the function 'SimpleDateFormat'.
     * If the string value that was passed through the command line is not the same as the pattern of function 'SimpleDateFormat', will be displayed an error message.
     * The method will run in a loop until the user will type a date that will satisfy the condition.
     * Whenever the input value is invalid will return false, will be shown an error message and, the method will be called again from the Application Class.
     * The date value will be stored in the date parameter.
     *
     * @param date - String value received through command line
     * @return - will return a boolean value, depending on the user input (true of the value can be evaluated and false if not)
     */
    public Boolean setRentingDate(final String date) {
        if (date != null) {
            try {
                this.date = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                return true;
            } catch (ParseException e) {
                System.out.println("Invalid date.");
                return false;
            }
        }
        return false;
    }

    /**
     * This generic method should be used to return the class parameter that is sored into the class that will extend Order.
     * For example, in the class VehicleOrder, this method will return the class parameter vehicle.
     *
     * @return - class parameter
     */
    public abstract T receiveHiredObject();
}
