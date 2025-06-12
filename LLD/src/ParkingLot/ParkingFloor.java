package ParkingLot;

import ParkingLot.Enums.SpotType;
import ParkingLot.Enums.VehicleType;
import ParkingLot.Model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    private int floorNumber;
    private List<ParkingSpot> spots;
    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        spots = new ArrayList<>();
    }

    public void addSpot(ParkingSpot spot){
        spots.add(spot);
    }

    public Optional<ParkingSpot> getAvaialableSpot(VehicleType vehicleType){
        SpotType requiredType = switch (vehicleType)
        {
            case BIKE -> SpotType.SMALL;
            case CAR -> SpotType.MEDIUM;
            case BUS ->  SpotType.LARGE;
        };
        return spots.stream().filter(spot->spot.getSpotType().equals(requiredType) && !spot.isOccupied()).findFirst();
    }
}
