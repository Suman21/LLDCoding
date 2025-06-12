package CabBookingSystem;

import CabBookingSystem.enums.RideStatus;
import CabBookingSystem.model.Driver;
import CabBookingSystem.model.Location;
import CabBookingSystem.model.Rider;
import lombok.Getter;

@Getter
public class Ride {

    private Rider rider;
    private Driver driver;
    private Location src;
    private Location dest;
    private RideStatus status;

    public Ride(Rider rider, Location src, Location dest) {
        this.rider = rider;
        this.src = src;
        this.dest = dest;
        status = RideStatus.REQUESTED;
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
        this.driver.setAvailable(false);
        this.status = RideStatus.IN_PROGRESS;
    }

    public void completeRide()
    {
        this.status = RideStatus.COMPLETED;
        this.driver.setAvailable(true);
    }

}
