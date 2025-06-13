package ParkingLot.Model;

import ParkingLot.Enums.VehicleType;

public class Truck extends Vehicle {
    public Truck(String registrationNumber, String color) {
        super(registrationNumber, VehicleType.TRUCK, color);
    }
}
