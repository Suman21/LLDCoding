package ParkingLot;

import ParkingLot.Commands.CommandExcecuterFactory;
import ParkingLot.Commands.InputReader;
import ParkingLot.Service.IParkingLotService;
import ParkingLot.Service.ParkingLotService;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ParkingLotMain {
    public static void main(String[] args) throws IOException {
        String filepath = "C:\\Users\\sumanbiswas\\IdeaProjects\\LLDWorkTech\\src\\ParkingLot\\Input.txt";
        IParkingLotService parkingLotService = new ParkingLotService();
        CommandExcecuterFactory commandExcecuterFactory = new CommandExcecuterFactory(parkingLotService);
        InputReader reader = new InputReader(filepath, commandExcecuterFactory);
        reader.run();
    }
}
