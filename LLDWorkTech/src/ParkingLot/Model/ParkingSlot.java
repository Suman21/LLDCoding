package ParkingLot.Model;

import ParkingLot.Enums.SlotType;
import ParkingLot.Exceptions.ParkingSlotException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSlot {
    private int id;
    private SlotType slotType;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSlot(int id, SlotType slotType) {
        this.id = id;
        this.slotType = slotType;
        this.isOccupied = false;
        this.vehicle = null;
    }

    public void park(Vehicle vehicle) throws ParkingSlotException {
        if(this.isOccupied) {
            throw new ParkingSlotException("Parking slot already occupied!!");
        }
        this.isOccupied = true;
        this.vehicle = vehicle;
    }

    public void unpark() throws ParkingSlotException {
        if(!this.isOccupied) {
            throw new ParkingSlotException("Parking slot already free!!");
        }
        this.isOccupied = false;
        this.vehicle = null;
    }
}
