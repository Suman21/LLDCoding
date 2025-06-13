package ParkingLot.Commands;

import ParkingLot.Service.IParkingLotService;

public class DisplayOccupiedSlotsCommand implements ICommands {

    private final IParkingLotService parkingLotService;

    public DisplayOccupiedSlotsCommand(IParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public void execute(String [] commands) {
        String vehicleType = commands[2];
        this.parkingLotService.DisplayOccupiedSlot(vehicleType);
    }
}
