package ParkingLot.Model;

import ParkingLot.Enums.VehicleType;

public class Bike extends Vehicle {
    public Bike(String registrationNumber) {
        super(registrationNumber, VehicleType.BIKE);
    }
}
