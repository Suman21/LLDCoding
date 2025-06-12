package ParkingLot;

import ParkingLot.Exceptions.NoAvailableSpotException;
import ParkingLot.Model.Ticket;
import ParkingLot.Model.Vehicle;

import java.util.*;

public class ParkingLot {
    private List<ParkingFloor> parkingFloors;
    private Map<String, Ticket> activeTickets;
    private Set<Vehicle> activeVehicle;

    public void addParkingFloor(ParkingFloor pf) {
        this.parkingFloors.add(pf);
    }

    public Ticket parkVehicle(Vehicle v) {
        if(this.activeVehicle.contains(v)) {
            throw  new IllegalStateException("vehicle already exists");
        }
        for(ParkingFloor pf : this.parkingFloors) {
            Optional<ParkingSpot> spot = pf.getAvaialableSpot(v.getVehicleType());
            if(spot.isPresent()) {
                ParkingSpot parkingSpot = spot.get();
                parkingSpot.park(v);
                Ticket ticket = new Ticket(UUID.randomUUID().toString(), parkingSpot, v);
                this.activeTickets.put(ticket.getTicketNumber(), ticket);
                this.activeVehicle.add(v);
            }
        }
        throw new NoAvailableSpotException("no spot available");
    }

    public double exitVehicle(Ticket ticket) {
        if(!this.activeVehicle.contains(ticket.getVehicle())) {
            throw  new IllegalStateException("vehicle does not exist");
        }
        ticket.getSpot().unpark(ticket.getVehicle());
        activeTickets.remove(ticket.getTicketNumber());
        activeVehicle.remove(ticket.getVehicle());
        return BillingService.calculateBill(ticket);
    }
}
