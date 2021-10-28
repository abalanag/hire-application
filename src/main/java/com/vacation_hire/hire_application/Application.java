package com.vacation_hire.hire_application;

import com.vacation_hire.hire_application.entity.*;
import com.vacation_hire.hire_application.entity.vehicles.Car;
import com.vacation_hire.hire_application.enums.CarTypes;
import com.vacation_hire.hire_application.enums.OrderStatus;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        final OrderRegister orderList = new OrderRegister(new ArrayList<>());
        boolean wantsToContinue = true;
        while (wantsToContinue) {
            boolean carTypeResponseValid = false;
            boolean rentingDateValid = false;
            boolean addCustomerNameValid = false;
            boolean addCustomerPhoneNumberValid = false;
            boolean updateOrderStatusValid = false;
            boolean updateGasolineLevelValid = false;

            System.out.println("Please choose one of the following options:");
            System.out.println("1. For managing vehicle renting type '1'");
            System.out.println("2. For showing all orders type '2'");
            System.out.println("3. For closing the application type '3'");
            System.out.print("Please type what you will want to do: ");

            final Scanner input = new Scanner(System.in);
            String action = input.nextLine();
            switch (action) {
                case "1":

                    System.out.println("What you would like to do?");
                    System.out.println("If you would like to rent a vehicle type '1' if you would like to return a vehicle type '2'.");
                    String menuOption = input.nextLine();
                    if (menuOption.toUpperCase(Locale.ROOT).equals("1")) {

                        final Order<Vehicle> newOrder = new VehicleOrder(new Date(), new Customer(), new Car());

                        while (!carTypeResponseValid) {
                            System.out.println("In this moment we only have available: " + Arrays.toString(Arrays.toString(CarTypes.values()) //gets all the values from CarType, added them in to an Array and calls to string to print the String values
                                    .replaceAll("^.|.$", "").split(", ")).replaceAll("[\\[\\]]", "")); // replace all tha symbols,
                            System.out.print("Please chose a type of vehicle: ");
                            String carTypeInput = input.nextLine();
                            carTypeResponseValid = newOrder.receiveHiredObject().setType(carTypeInput);
                        }

                        while (!rentingDateValid) {
                            System.out.print("Please type the date when the vehicle will be hired, please use the format dd/MM/yyyy: ");
                            String rentingDateInput = input.nextLine();
                            rentingDateValid = newOrder.setRentingDate(rentingDateInput); // set rent time dialog
                        }

                        while (!addCustomerNameValid) {
                            System.out.print("Please type the name of the customer: ");
                            String customerNameInput = input.nextLine();
                            addCustomerNameValid = newOrder.getCustomer().addCustomerName(customerNameInput); // add customer name dialog
                        }

                        while (!addCustomerPhoneNumberValid) {
                            System.out.print("Please type the phone number of the person that is renting the car: ");
                            String phoneNumberInput = input.nextLine();
                            addCustomerPhoneNumberValid = newOrder.getCustomer().addCustomerPhoneNumber(phoneNumberInput); // add customer phone number dialog
                        }

                        newOrder.receiveHiredObject().setOrderStatus(OrderStatus.RENTED); // Setting the order status as rented
                        newOrder.showOrder(); // Show final receipt dialog
                        orderList.getOrders().add(newOrder); // Adding order to the list
                        break;

                    } else if (menuOption.toUpperCase(Locale.ROOT).equals("2")) {
                        if (orderList.showListOfActiveOrders()) { // checking if there are active orders
                            Order<Vehicle> order = null;
                            while (order == null) {
                                System.out.print("Please type the order number that you would like to manage: ");
                                String orderNumber = input.nextLine();
                                order = orderList.receiveOrderByOrderNumber(orderNumber);
                            }

                            try {
                                while (!updateOrderStatusValid) {
                                    System.out.print("Was the rented object damaged during the renting? (Y/N): ");
                                    String carStatusAnswer = input.nextLine();
                                    updateOrderStatusValid = order.receiveHiredObject().updateDamagingStatus(carStatusAnswer); // checking for if the car is damaged dialog
                                }

                                while (!updateGasolineLevelValid) {
                                    System.out.print("Was the gasoline filled up? (Y/N): ");
                                    String gasolineLevelAnswer = input.nextLine();
                                    updateGasolineLevelValid = order.receiveHiredObject().updateVehicleGasolineLevel(gasolineLevelAnswer); // checking gasoline level dialog
                                    order.receiveHiredObject().setOrderStatus(OrderStatus.RETURNED); // Setting the order status as returned
                                }
                            } catch (ClassCastException c) { // catch ClassCastException, if the user will select the wrong order, this exception will be trowed!!!!
                                System.out.println("Invalid object, you will need you manage the selected object using his special menu");
                                break;
                            }
                        }
                    } else {
                        break;
                    }

                case "2":
                    orderList.showAllOrders(); // showing all orders
                    break;

                case "3":
                    System.out.print("Are you sure you want to exit?(Y/N): ");
                    String decision = input.nextLine();
                    wantsToContinue = !decision.toUpperCase(Locale.ROOT).equals("Y"); // If answer is Y the loop will be closed
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}
