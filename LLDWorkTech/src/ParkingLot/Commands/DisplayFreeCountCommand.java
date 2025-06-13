package ParkingLot.Commands;

import ParkingLot.Service.IParkingLotService;

public class DisplayFreeCountCommand implements ICommands{

    private final IParkingLotService parkingLotService;

    public DisplayFreeCountCommand(IParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public void execute(String [] commands) {
        String vehicleType = commands[2];
        parkingLotService.DisplayFreeCount(vehicleType);
    }
}
