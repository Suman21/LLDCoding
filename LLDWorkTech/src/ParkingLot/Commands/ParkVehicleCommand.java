package ParkingLot.Commands;

import ParkingLot.Service.IParkingLotService;

public class ParkVehicleCommand implements ICommands{

    private final IParkingLotService parkingLotService;

    public ParkVehicleCommand(IParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public void execute(String [] commands) {
        String vehicleType = commands[1];
        String registrationNumber = commands[2];
        String color = commands[3];
        parkingLotService.ParkVehicle(vehicleType, registrationNumber, color);
    }
}
