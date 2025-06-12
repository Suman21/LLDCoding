package ParkingLot.Model;

import ParkingLot.Enums.VehicleType;

public class Car extends Vehicle{
    public Car(String number)
    {
        super(number, VehicleType.CAR);
    }
}
