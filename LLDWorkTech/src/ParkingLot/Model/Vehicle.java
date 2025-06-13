package ParkingLot.Model;

import ParkingLot.Enums.VehicleType;

import java.util.Objects;


public abstract class Vehicle {
    String registrationNumber;
    VehicleType vehicleType;
    String color;

    public Vehicle(String registrationNumber, VehicleType vehicleType, String color)
    {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vehicle vehicle)) return false;
        return Objects.equals(registrationNumber, vehicle.getRegistrationNumber()) &&
                Objects.equals(color, vehicle.getColor()) &&
                vehicleType == vehicle.getVehicleType();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(registrationNumber, color);
    }
}
