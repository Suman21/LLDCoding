package ParkingLot.Model;

import ParkingLot.Enums.VehicleType;

public class Bike extends Vehicle {

    public Bike(String registrationNumber, String color)
    {
        super(registrationNumber, VehicleType.BIKE, color);
    }
}
