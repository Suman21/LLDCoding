package ParkingLot;

import ParkingLot.Enums.SpotType;
import ParkingLot.Model.Vehicle;
import lombok.Getter;

@Getter
public class ParkingSpot {
    private String id;
    private SpotType spotType;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(String id, SpotType spotType, Vehicle vehicle) {
        this.id = id;
        this.spotType = spotType;
        this.vehicle = vehicle;
    }

    public void park(Vehicle vehicle) {
        if(isOccupied)
            throw new IllegalStateException("Vehicle already occupied");
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void unpark(Vehicle vehicle) {
        if (!isOccupied)
            throw new IllegalStateException("Vehicle not occupied");
        this.vehicle = null;
        this.isOccupied = false;
    }
}
