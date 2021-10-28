package com.vacantion_hire.hire_application.entity;

import com.vacation_hire.hire_application.entity.Vehicle;
import com.vacation_hire.hire_application.entity.vehicles.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarEntityTest {

    private Vehicle vehicle;

    @BeforeEach
    void setUp() {
        vehicle = new Car();
    }

    @Test
    @DisplayName("Testing method SetCarType")
    void testUserInputForMethodSetCarType() {
        assertEquals(true, vehicle.setType("truck"), "input 'truck' should return true");
        assertEquals(true, vehicle.setType("minivan"), "input 'minivan' should return true");
        assertEquals(true, vehicle.setType("sedan"), "input 'sedan' should return true");
        assertEquals(false, vehicle.setType("a string"), "input 'a string' should return false");
        assertEquals(false, vehicle.setType(""), "input '' should return false");
        assertEquals(false, vehicle.setType(null), "input null should return false");
    }

    @Test
    @DisplayName("Testing method UpdateCarStatus")
    void testUserInputForMethodUpdateCarStatus() {
        assertEquals(true, vehicle.updateDamagingStatus("y"), "input 'y' should return true");
        assertEquals(true, vehicle.updateDamagingStatus("Y"), "input 'Y' should return true");
        assertEquals(true, vehicle.updateDamagingStatus("n"), "input 'n' should return true");
        assertEquals(true, vehicle.updateDamagingStatus("N"), "input 'N' should return true");
        assertEquals(false, vehicle.updateDamagingStatus("a string"), "input 'a string' should return false");
        assertEquals(false, vehicle.updateDamagingStatus(""), "input '' should return false");
        assertEquals(false, vehicle.updateDamagingStatus(null), "input null should return false");
    }

    @Test
    @DisplayName("Testing method UpdateGasolineLevel")
    void testUserInputForMethodUpdateGasolineLevel() {
        assertEquals(true, vehicle.updateVehicleGasolineLevel("y"), "input 'y' should return true");
        assertEquals(true, vehicle.updateVehicleGasolineLevel("Y"), "input 'Y' should return true");
        assertEquals(true, vehicle.updateVehicleGasolineLevel("n"), "input 'n' should return true");
        assertEquals(true, vehicle.updateVehicleGasolineLevel("N"), "input 'N' should return true");
        assertEquals(false, vehicle.updateVehicleGasolineLevel("a string"), "input 'a string' should return false");
        assertEquals(false, vehicle.updateVehicleGasolineLevel(""), "input '' should return false");
        assertEquals(false, vehicle.updateVehicleGasolineLevel(null), "input null should return false");
    }
}
