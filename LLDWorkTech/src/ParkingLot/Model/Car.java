package ParkingLot.Model;

import ParkingLot.Enums.VehicleType;

public class Car extends Vehicle {
    public Car(String registrationNumber, String color) {
        super(registrationNumber, VehicleType.CAR, color);
    }
}
