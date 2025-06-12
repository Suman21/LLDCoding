package Elevator.model;

import Elevator.enums.Direction;
import Elevator.enums.ElevatorStatus;
import lombok.Getter;
import lombok.Setter;
import java.util.TreeSet;

@Getter
@Setter
public class Elevator {
    private int id;
    private ElevatorStatus status;
    private Direction  direction;
    private int currentFloor;
    private TreeSet<Integer> destinationFloors;

    public Elevator(int id) {
        this.id = id;
        this.status = ElevatorStatus.IDLE;
        this.direction = Direction.IDLE;
        this.destinationFloors = new TreeSet<>();
        this.currentFloor = 0;
    }

    public void AddFloor(int floor) {
        this.destinationFloors.add(floor);
    }

    public void step()
    {
        if(destinationFloors.isEmpty())
        {
            direction = Direction.IDLE;
            status = ElevatorStatus.IDLE;
            return;
        }

        Integer target = direction == Direction.UP ? destinationFloors.ceiling(currentFloor) : destinationFloors.floor(currentFloor);

        if(target == null || currentFloor == target)
        {
            destinationFloors.remove(target);
            status = ElevatorStatus.STOPPED;
            return;
        }

        if(target > currentFloor)
        {
            currentFloor ++;
            direction = Direction.UP;
        }
        else
        {
            currentFloor ++;
            direction = Direction.DOWN;
        }

        if (currentFloor == target) {
            destinationFloors.remove(currentFloor);
            status = ElevatorStatus.STOPPED;
        }
    }
}
