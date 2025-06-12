package CabBookingSystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver extends User {
    private boolean isAvailable;
    private Location location;
    public Driver(int userId, String userName) {

        super(userId, userName);
        this.isAvailable = false;
    }
}
