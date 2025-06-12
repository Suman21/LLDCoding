package CabBookingSystem;

import CabBookingSystem.model.Driver;
import CabBookingSystem.model.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverService {
    Map<Integer, Driver>  drivers;

    public DriverService()
    {
        drivers = new HashMap<Integer, Driver>();
    }

    public void addDriver(Driver driver)
    {
        drivers.put(driver.getUserId(), driver);
    }

    public void UpdateLocation(Driver driver, Location location)
    {
        driver =  drivers.get(driver.getUserId());
        if(driver != null)
        {
            driver.setLocation(location);
        }
    }

    public List<Driver> getDrivers(Location src, int radius)
    {
        List<Driver> res = new ArrayList<>();
        for(Driver driver : drivers.values())
        {
            if(driver.isAvailable() && isNearBy(src, driver.getLocation(), radius))
            {
                res.add(driver);
            }
        }
        return res;
    }

    public boolean isNearBy(Location riderLocation, Location DriverLocation, int radius)
    {
        double dx = riderLocation.getLat() -  DriverLocation.getLat();
        double dy = riderLocation.getLon() -  DriverLocation.getLon();
        return  Math.sqrt(dx * dx + dy * dy) <= radius;
    }

}
