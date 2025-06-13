package ParkingLot.Model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Ticket {
    private final String ticketNumber;
    private ParkingSlot parkingSlot;
    private Vehicle vehicle;
    private ParkingFloor parkingFloor;
    private LocalDateTime entryTime;

    public Ticket(String ticketNumber, ParkingSlot parkingSlot, Vehicle vehicle, ParkingFloor parkingFloor) {
        this.ticketNumber = ticketNumber;
        this.parkingSlot = parkingSlot;
        this.vehicle = vehicle;
        this.parkingFloor = parkingFloor;
        this.entryTime = LocalDateTime.now();
    }
}
