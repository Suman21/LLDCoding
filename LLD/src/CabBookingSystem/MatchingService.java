package CabBookingSystem;


import CabBookingSystem.model.Driver;
import CabBookingSystem.model.Location;

import java.util.List;

public class MatchingService {
    DriverService driverService;
    public MatchingService(DriverService driverService)
    {
        this.driverService = driverService;
    }

    public Driver findDriver(Location riderLocation)
    {
        List<Driver> drivers = driverService.getDrivers(riderLocation, 10);
        if(drivers.isEmpty())
        {
            System.out.println("No drivers found");
            return null;
        }
        return drivers.getFirst();
    }
}
