package Elevator;

import Elevator.model.Elevator;
import Elevator.model.Request;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private List<Elevator> elevators;
    private Schedular schedular;

    public ElevatorSystem() {
        elevators = new ArrayList<>();
        schedular = new Schedular();
    }

    public void requestElevator(Request request) {
        try {
            Elevator e = schedular.assignElevator(elevators, request);
            e.AddFloor(request.getSource());
            e.AddFloor(request.getDestination());
            System.out.println("Elevator Requested Successfully");
        }
        catch (Exception e) {
            System.out.println( e.getMessage());
        }
    }

    public void step()
    {
        for(Elevator e : elevators)
        {
            e.step();
        }
    }
}
