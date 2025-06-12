package ParkingLot;

import ParkingLot.Model.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class BillingService {
    public static double calculateBill(Ticket ticket){
        long minutes = Duration.between(ticket.getEntryTime(), ticket.getEntryTime()).toMinutes();

        double baseFair = switch (ticket.getVehicle().getVehicleType())
        {
            case BIKE -> 1.0;
            case CAR -> 2.0;
            case BUS ->  3.0;
        };
        return baseFair * minutes;
    }
}
