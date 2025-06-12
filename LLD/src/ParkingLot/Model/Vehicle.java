package ParkingLot.Model;

import ParkingLot.Enums.VehicleType;
import lombok.*;

@Getter
public abstract class Vehicle {
    final String registrationNumber;
    final VehicleType vehicleType;

    public Vehicle(String registrationNumber, VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }
}

