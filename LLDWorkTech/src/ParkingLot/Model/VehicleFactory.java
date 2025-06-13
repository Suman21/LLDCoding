package ParkingLot.Model;

import ParkingLot.Enums.VehicleType;
import ParkingLot.Exceptions.VehicleFactoryException;

public class VehicleFactory {

    public static Vehicle GetVehicle(String registrationNumber, String vehicleType, String color) throws VehicleFactoryException {
        return switch (vehicleType) {
            case "TRUCK" -> new Truck(registrationNumber, color);
            case "CAR" -> new Car(registrationNumber, color);
            case "BIKE" -> new Bike(registrationNumber, color);
            default -> throw new VehicleFactoryException(vehicleType + " is not present in VehicleFactory!!");
        };
    }
}
