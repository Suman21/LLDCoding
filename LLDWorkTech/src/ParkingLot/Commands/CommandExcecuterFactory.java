package ParkingLot.Commands;

import ParkingLot.Service.IParkingLotService;

import java.util.HashMap;
import java.util.Map;

public class CommandExcecuterFactory {
    Map<String, ICommands> commands;

    public CommandExcecuterFactory(IParkingLotService parkingLotService){
        commands = new HashMap<>();
        commands.put("create_parking_lot", new CreateParkingLotCommand(parkingLotService));
        commands.put("display free_count", new DisplayFreeCountCommand(parkingLotService));
        commands.put("display free_slots", new DisplayFreeSlotsCommand(parkingLotService));
        commands.put("display occupied_slots", new DisplayOccupiedSlotsCommand(parkingLotService));
        commands.put("park_vehicle", new ParkVehicleCommand(parkingLotService));
        commands.put("unpark_vehicle", new UnParkVehicleCommand(parkingLotService));
    }

    public  ICommands getCommand(String command){
        return commands.get(command);
    }
}
