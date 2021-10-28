package com.vacation_hire.hire_application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleOrder extends Order<Vehicle> {

    private Vehicle vehicle;

    public VehicleOrder(final Date date, final Customer customer, final Vehicle vehicle) {
        super(date, customer);
        this.vehicle = vehicle;
    }

    /**
     * Method used to show all the information about the order that was sent it will display the car type, customer name, and the rent date.
     */
    public void showOrder() {
        System.out.println("-------------------------------------------------------|Order Placed|-------------------------------------------------------");
        System.out.println("The order for the car type " + vehicle.getType() + " it was place on the name " + super.getCustomer().getName() + " in date of " + super.getDate());
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }

    /**
     * This method will return the class parameter that is stored in this class. In this case, will return a vehicle
     *
     * @return - class parameter vehicle
     */
    @Override
    public Vehicle receiveHiredObject() {
        return vehicle;
    }
}
