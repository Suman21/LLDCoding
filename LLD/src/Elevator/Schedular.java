package Elevator;

import Elevator.enums.ElevatorStatus;
import Elevator.model.Elevator;
import Elevator.model.Request;

import java.util.List;

public class Schedular {

    public Elevator assignElevator(List<Elevator> elevators, Request request) {
        int minDistance = Integer.MAX_VALUE;
        Elevator bestElevator = null;
        for (Elevator elevator : elevators) {
            int dist = Math.abs(elevator.getCurrentFloor() - request.getSource());
            if(elevator.getStatus().equals(ElevatorStatus.IDLE))
            {
                if(dist < minDistance)
                {
                    minDistance = Math.abs(elevator.getCurrentFloor() - request.getSource());
                    bestElevator = elevator;
                }
            }
            else if(elevator.getDirection() == request.getDirection())
            {
                if(dist < minDistance)
                {
                    minDistance = Math.abs(elevator.getCurrentFloor() - request.getDestination());
                    bestElevator = elevator;
                }
            }
        }
        if(bestElevator == null)
            bestElevator = elevators.getFirst();
        return bestElevator;
    }
}
