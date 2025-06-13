package ParkingLot.Commands;

import ParkingLot.Service.IParkingLotService;

public class DisplayFreeSlotsCommand implements ICommands{

    private final IParkingLotService parkingLotService;

    public DisplayFreeSlotsCommand(IParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public void execute(String [] commands) {
        String vehicleType = commands[2];
        this.parkingLotService.DisplayFreeSlot(vehicleType);
    }
}
