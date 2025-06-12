package Elevator.model;

import Elevator.enums.Direction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request {
    private Direction direction;
    private int Source;
    private int Destination;

    public Request(Direction direction, int source, int destination) {
        if(source == destination)
            throw new IllegalArgumentException("Destination can't be the same as source");
        this.direction = source > destination ? Direction.DOWN : Direction.UP;
        this.Source = source;
        this.Destination = destination;
    }
}
