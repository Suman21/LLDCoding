package CabBookingSystem;

import CabBookingSystem.model.Driver;
import CabBookingSystem.model.Location;
import CabBookingSystem.model.Rider;

public class RiderService {
    private MatchingService matchingService;

    public RiderService(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    public Ride assignDriver(Location riderSrc, Location riderDst, Rider rider) {
        Ride ride = new Ride(rider, riderSrc, riderDst);
        Driver driver = matchingService.findDriver(riderSrc);
        if (driver != null) {
            ride.assignDriver(driver);
            System.out.println("Ride started with driver: " + driver.getUserId());
        }
        else  {
            System.out.println("Driver not found");
        }
        return ride;
    }
}
