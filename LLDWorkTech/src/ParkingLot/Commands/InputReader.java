package ParkingLot.Commands;

import ParkingLot.Service.IParkingLotService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputReader {
    private final BufferedReader reader;
    private final CommandExcecuterFactory commandExcecuterFactory;

    public InputReader(String filePath, CommandExcecuterFactory commandExcecuterFactory) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(filePath));
        this.commandExcecuterFactory = commandExcecuterFactory;
    }

    public void run() throws IOException {
        String line;
        while((line = reader.readLine()) != null && !line.equalsIgnoreCase("exit"))
        {
            ICommands command;
            String[] commands = line.trim().split(" ");
            if(commands[0].equalsIgnoreCase("display"))
                command = commandExcecuterFactory.getCommand(commands[0] + " " + commands[1]);
            else
                command = commandExcecuterFactory.getCommand(commands[0]);
            command.execute(commands);
        }
    }
}
