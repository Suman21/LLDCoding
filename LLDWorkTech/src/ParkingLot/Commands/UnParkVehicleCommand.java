package ParkingLot.Commands;

import ParkingLot.Service.IParkingLotService;

public class UnParkVehicleCommand implements ICommands{

    private final IParkingLotService parkingLotService;

    public UnParkVehicleCommand(IParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public void execute(String [] commands) {
        String ticketNumber = commands[1];
        parkingLotService.UnParkVehicle(ticketNumber);
    }
}
