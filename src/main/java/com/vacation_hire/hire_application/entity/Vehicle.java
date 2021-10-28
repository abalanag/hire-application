package com.vacation_hire.hire_application.entity;

import com.vacation_hire.hire_application.Intefaces.Rentable;
import com.vacation_hire.hire_application.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle implements Rentable {

    private Boolean vehicleDamaged;
    private OrderStatus orderStatus;

    public Vehicle() {
        this.vehicleDamaged = false;
        this.orderStatus = OrderStatus.NOT_RENTED;
    }

    /**
     * Method used to update the car gasoline level.
     * This method will receive an input of the type String representing the user input received through the command line.
     * The user input needs to be 'Y', 'y', 'n' or "N".
     * The method will run in a loop until the user will type one of the correct options.
     * Whenever the input value is invalid will return false, will be shown an error message and, the method will be called again from the Application Class.
     * Depending on the value, the car will be evaluated as damaged or not.
     * If the input will be 'Y', then the car will be evaluated as damaged and the status of the property damagedCar will be set as true.
     * If the input will be 'N' then, the car will not be evaluated as damaged and the status of the property damagedCar will be set as false.
     *
     * @param answer - String value received through command line
     * @return - will return a boolean value, depending on the user input (true of the value can be evaluated and false if not)
     */
    @Override
    public Boolean updateDamagingStatus(final String answer) throws ClassCastException {

        if (answer != null) {
            switch (answer.toUpperCase()) {
                case "Y":
                    vehicleDamaged = true;
                    return true;
                case "N":
                    vehicleDamaged = false;
                    return true;
                default:
                    System.out.println("Please type a valid answer.");
                    return false;
            }
        }
        return false;
    }

    /**
     * Method used for updating the fuel tank level. It will receive a String as an input which represents the value
     * typed by the user on the command line.
     * Method will check if the input from the user is valid and if it is, will return true, else will return false.
     *
     * @param answer - String value received through command line representing the vehicle gasoline level status, Full or Empty.
     * @return - will return a boolean value, depending on the user input (true of the value can be evaluated and false if not)
     */
    public abstract Boolean updateVehicleGasolineLevel(final String answer) throws ClassCastException;

    /**
     * This method will return the status of the fuel tank. If the value is false, then the tank is not full, if it's true then the tank is full.
     *
     * @return - a boolean value that represents the status of the fuel tank
     */
    public abstract Boolean getFuelFilledUp();

    /**
     * This method will return a string that concatenates all the information about a vehicle: Fuel level,
     * order status, vehicle status, and the vehicle type.
     *
     * @param toString - this method will receive the returned value of the method toString
     * @return - will return all the properties values that are stored in a vehicle
     */
    @Override
    public String toString(String toString) {
        return toString;
    }
}
