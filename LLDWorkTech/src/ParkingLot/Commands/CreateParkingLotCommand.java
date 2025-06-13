package ParkingLot.Commands;

import ParkingLot.Service.IParkingLotService;

public class CreateParkingLotCommand implements ICommands {

    private final IParkingLotService parkingLotService;
    public CreateParkingLotCommand(IParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }
    @Override
    public void execute(String []command) {
        String parkingLotName = command[1];
        int noOfFloors = Integer.parseInt(command[2]);
        int noOfParkingLots = Integer.parseInt(command[3]);
        parkingLotService.CreateParkingLot(parkingLotName, noOfFloors, noOfParkingLots);
    }
}
