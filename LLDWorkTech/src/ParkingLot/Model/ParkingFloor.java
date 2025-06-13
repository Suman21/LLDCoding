package ParkingLot.Model;

import ParkingLot.Enums.SlotType;
import ParkingLot.Enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Getter
@Setter
public class ParkingFloor {
    private int floorId;
    private List<ParkingSlot> parkingSlots;

    public ParkingFloor(int floorId) {
        this.floorId = floorId;
        this.parkingSlots = new ArrayList<>();
    }

    public ParkingFloor(int floorId, List<ParkingSlot> parkingSlots) {
        this.floorId = floorId;
        this.parkingSlots = parkingSlots;
    }

    public void addParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlots.add(parkingSlot);
    }

    public SlotType GetSlotType(VehicleType vehicleType) {
        return switch (vehicleType) {
            case BIKE -> SlotType.SMALL;
            case CAR -> SlotType.MEDIUM;
            case TRUCK -> SlotType.LARGE;
        };
    }

    public ParkingSlot getFreeParkingSlot(VehicleType vehicleType) {
        SlotType slotType = GetSlotType(vehicleType);
        for(ParkingSlot parkingSlot : this.parkingSlots) {
            if(!parkingSlot.isOccupied() && parkingSlot.getSlotType() == slotType) {
                return parkingSlot;
            }
        }
        return null;
    }

    public long countFreeParkingSlot(VehicleType vehicleType) {
        SlotType slotType = GetSlotType(vehicleType);
        return parkingSlots.stream().filter(e -> e.getSlotType() == slotType && !e.isOccupied()).count();
    }

    public String freeParkingSlotNos(VehicleType vehicleType) {
        SlotType slotType = GetSlotType(vehicleType);
        String ids = "";
        for(ParkingSlot parkingSlot : this.parkingSlots) {
            if(!parkingSlot.isOccupied() && parkingSlot.getSlotType() == slotType) {
                ids = ids + parkingSlot.getId() + ",";
            }
        }
        if(!ids.isEmpty()) {
            ids = ids.substring(0, ids.length() - 1);
        }
        return ids;
    }

    public String occupiedParkingSlotNos(VehicleType vehicleType) {
        SlotType slotType = GetSlotType(vehicleType);
        String ids = "";
        for(ParkingSlot parkingSlot : this.parkingSlots) {
            if(parkingSlot.isOccupied() && parkingSlot.getSlotType() == slotType) {
                ids = ids + parkingSlot.getId() + ",";
            }
        }
        if(!ids.isEmpty()) {
            ids = ids.substring(0, ids.length() - 1);
        }
        return ids;
    }
}
