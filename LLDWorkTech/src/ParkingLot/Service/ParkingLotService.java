package ParkingLot.Service;

import ParkingLot.Enums.VehicleType;
import ParkingLot.Model.ParkingLot;
import ParkingLot.Model.Vehicle;
import ParkingLot.Model.VehicleFactory;

public class ParkingLotService implements IParkingLotService {
    ParkingLot parkingLot;
    public void CreateParkingLot(String name, int noOfFloors, int noOfParkingSpot) {
        parkingLot = new ParkingLot(name, noOfFloors, noOfParkingSpot);
    }

    public void DisplayFreeCount(String vehicleType) {
        parkingLot.dispalyFreeCount(VehicleType.valueOf(vehicleType));
    }

    public void DisplayFreeSlot(String vehicleType) {
        parkingLot.dispalyFreeSlots(VehicleType.valueOf(vehicleType));
    }

    public void DisplayOccupiedSlot(String vehicleType) {
        parkingLot.displayOccupiedSlots(VehicleType.valueOf(vehicleType));
    }

    public void ParkVehicle(String vehicleType, String registrationNumber, String color)  {
        try {
            Vehicle vehicle = VehicleFactory.GetVehicle(registrationNumber, vehicleType, color);
            parkingLot.parkVehicle(vehicle);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void UnParkVehicle(String ticketNumber) {
        try {
            parkingLot.unParkVehicle(ticketNumber);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
