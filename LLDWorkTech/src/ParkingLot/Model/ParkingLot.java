package ParkingLot.Model;

import ParkingLot.Enums.SlotType;
import ParkingLot.Enums.VehicleType;
import ParkingLot.Exceptions.ParkingLotException;
import ParkingLot.Exceptions.ParkingSlotException;

import java.util.*;

public class ParkingLot {
    private String name;
    private List<ParkingFloor> floors;
    private Set<Vehicle> parkedVehicles;
    private Map<String, Ticket> activeTickets;

    public void addParkingFloor(ParkingFloor parkingFloor) {
        floors.add(parkingFloor);
    }

    public ParkingLot(String name, int noOfFloors, int noOfParkingSpot) {
        this.name = name;
        this.activeTickets = new HashMap<>();
        this.parkedVehicles = new HashSet<>();
        floors = new ArrayList<>(noOfFloors);


        for (int floorId = 1; floorId <= noOfFloors; floorId++) {
            int slotId = 1;
            List<ParkingSlot> parkingSlots = new ArrayList<>();
            if(noOfParkingSpot > 0) {
                parkingSlots.add(new ParkingSlot(slotId++, SlotType.LARGE));
            }
            if (noOfParkingSpot > 1) {
                parkingSlots.add(new ParkingSlot(slotId++, SlotType.SMALL));
            }
            if (noOfParkingSpot > 2) {
                parkingSlots.add(new ParkingSlot(slotId++, SlotType.SMALL));
            }
            for(int i=3;i<noOfParkingSpot;i++) {
                parkingSlots.add(new ParkingSlot(slotId++, SlotType.MEDIUM));
            }
            ParkingFloor parkingFloor = new ParkingFloor(floorId, new ArrayList<>(parkingSlots));
            floors.add(parkingFloor);
        }
        System.out.println("Created parking lot with "+ noOfFloors +" floors and "+ noOfParkingSpot +" slots per floor");
    }

    public void parkVehicle(Vehicle vehicle) throws ParkingLotException, ParkingSlotException {
        if(parkedVehicles.contains(vehicle))
            throw new ParkingLotException("Vehicle Already Parked!!");
        for(ParkingFloor floor : floors) {
            ParkingSlot parkingSlot = floor.getFreeParkingSlot(vehicle.getVehicleType());
            if(parkingSlot != null)
            {
                parkingSlot.park(vehicle);
                String ticketNumber = this.name + "_" + floor.getFloorId() + "_" +parkingSlot.getId();
                Ticket ticket = new Ticket(ticketNumber , parkingSlot, vehicle, floor);
                activeTickets.put(ticketNumber, ticket);
                this.parkedVehicles.add(vehicle);
                System.out.println("Parked vehicle. Ticket ID: " + ticket.getTicketNumber());
                return;
            }
        }
        System.out.println("Parking Lot Full");
    }

    public void unParkVehicle(String ticketNumber) throws ParkingLotException, ParkingSlotException {
        if(!activeTickets.containsKey(ticketNumber)) {
            System.out.println("Invalid Ticket");
            return;
        }
        Ticket ticket = activeTickets.get(ticketNumber);
        ParkingSlot parkingSlot = ticket.getParkingSlot();
        parkingSlot.unpark();
        activeTickets.remove(ticketNumber);
        parkedVehicles.remove(ticket.getVehicle());
        System.out.println("Unparked vehicle with Registration Number: " + ticket.getVehicle().getRegistrationNumber() + " and Color: " + ticket.getVehicle().getColor());
    }

    public void dispalyFreeCount(VehicleType vehicleType)
    {
        for(ParkingFloor parkingFloor : floors)
        {
            System.out.println("No. of free slots for " + vehicleType.toString() +
                            " on Floor " + parkingFloor.getFloorId() +
                    ": " + parkingFloor.countFreeParkingSlot(vehicleType)
                    );
        }
    }

    public void dispalyFreeSlots(VehicleType vehicleType)
    {
        for (ParkingFloor parkingFloor : floors)
        {
            System.out.println("Free slots for " + vehicleType.toString() +
                    " on Floor " + parkingFloor.getFloorId() +
                    ": " + parkingFloor.freeParkingSlotNos(vehicleType));
        }
    }

    public void displayOccupiedSlots(VehicleType vehicleType)
    {
        for (ParkingFloor parkingFloor : floors)
        {
            System.out.println("Occupied slots for " + vehicleType.toString() +
                    " on Floor " + parkingFloor.getFloorId() +
                    ": " + parkingFloor.occupiedParkingSlotNos(vehicleType));
        }
    }
}
