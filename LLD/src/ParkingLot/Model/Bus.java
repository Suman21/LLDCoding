package ParkingLot.Model;

import ParkingLot.Enums.VehicleType;

public class Bus extends Vehicle {
    public Bus(String registrationNumber) {
        super(registrationNumber, VehicleType.BIKE);
    }
}
