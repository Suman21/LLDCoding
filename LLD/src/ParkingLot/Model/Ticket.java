package ParkingLot.Model;
import ParkingLot.ParkingSpot;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Ticket {
    private final String ticketNumber;
    private final ParkingSpot spot;
    private final Vehicle vehicle;
    private final LocalDateTime entryTime;

    public Ticket(String ticketNumber, ParkingSpot spot, Vehicle vehicle){
        this.ticketNumber = ticketNumber;
        this.spot = spot;
        this.vehicle = vehicle;
        this.entryTime = LocalDateTime.now();
    }
}
