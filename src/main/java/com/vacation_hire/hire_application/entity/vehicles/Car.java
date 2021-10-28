package com.vacation_hire.hire_application.entity.vehicles;

import com.vacation_hire.hire_application.entity.Vehicle;
import com.vacation_hire.hire_application.enums.CarTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Car extends Vehicle {

    private Boolean fuelFilledUp;
    private CarTypes carType;

    public Car() {
        this.fuelFilledUp = Boolean.TRUE;
    }

    /**
     * Method used to update the vehicle gasoline level. This method will receive an input of the type String representing the user input received through the command line.
     * The input needs to be 'Y', 'y', 'n' or "N".
     * The method will run in a loop until the user will type one of the correct options.
     * Every time when the input value is invalid will return false, will be shown an error message and, the method will be called again from the Application Class.
     * Depending on the value, the car gasoline level will be evaluated as full or not.
     * If the input will be 'Y', then the fuel level will be evaluated as full so, in this case, the stored boolean value in the fuelFilledUp property will be true.
     * If the input will be 'N', then the fuel level will not be evaluated as full so, in this case, the stored boolean value in the fuelFilledUp property will be false.
     *
     * @param answer - String value received through command line
     * @return - will return a boolean value, depending on the user input (true of the value can be evaluated and false if not)
     */
    @Override
    public Boolean updateVehicleGasolineLevel(final String answer) {
        try {
            if (answer != null) {
                switch (answer.toUpperCase()) {
                    case "Y":
                        fuelFilledUp = true;
                        return true;
                    case "N":
                        fuelFilledUp = false;
                        return true;
                    default:
                        System.out.println("Please type a valid answer.");
                        return false;
                }
            }
            return false;
        } catch (ClassCastException c) {
            System.out.println("Invalid object, you will need you manage the selected object using his special menu");
            return true;
        }
    }

    /**
     * Method used for choosing the type of vehicle that the customer would like.
     * The input value of type String received through the command line is checked with the help of the switch case,
     * to find out the type of vehicle that is desired by the customer.
     * The method will run in a loop until the user will type one of the correct options.
     * Whenever the input value is invalid will return false, will be shown an error message and, the method will be called again from the Application Class.
     * The final value will be stored in the carType property.
     *
     * @param carType - String value received through command line
     * @return - will return a boolean value, depending on the user input (true of the value can be evaluated and false if not)
     */
    @Override
    public Boolean setType(final String carType) {
        if (carType != null) {
            switch (carType) {
                case "truck":
                    this.carType = CarTypes.TRUCKS;
                    return true;
                case "minivan":
                    this.carType = CarTypes.MINIVANS;
                    return true;
                case "sedan":
                    this.carType = CarTypes.SEDANS;
                    return true;
                default:
                    System.out.println("Option selected is invalid.");
                    return false;
            }
        }
        return false;
    }

    /**
     * Method used to get the car type sored into the carType property.
     *
     * @return - this method will return the value stored into CarType enum.
     */
    @Override
    public String getType() {
        return carType.getValue();
    }

    /**
     * Method used for getting the status of the fuel tank.
     *
     * @return - return a boolean value. If the return value is true, then the tank is full else the tank is empty.
     */
    @Override
    public Boolean getFuelFilledUp() {
        return fuelFilledUp;
    }

    /**
     * Method used to print information about the car and the order.
     *
     * @return - will return a concatenated string that contains the car type, order status, status of the fuel tank, and if the vehicle is damaged or not
     */
    @Override
    public String toString() {
        return carType + " | " + super.getOrderStatus() + " | " + super.getVehicleDamaged() + " | " + fuelFilledUp;
    }
}
