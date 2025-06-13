package ParkingLot.Service;

import ParkingLot.Model.ParkingLot;

public interface IParkingLotService {

    public void CreateParkingLot(String name, int noOfFloors, int noOfParkingSpot);

    public void DisplayFreeCount(String vehicleType);

    public void DisplayFreeSlot(String vehicleType);

    public void DisplayOccupiedSlot(String vehicleType);

    public void ParkVehicle(String vehicleType, String registrationNumber, String color);

    public void UnParkVehicle(String ticketNumber);
}
