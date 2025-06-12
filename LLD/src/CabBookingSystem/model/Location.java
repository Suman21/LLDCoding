package CabBookingSystem.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {

    private double lat;
    private double lon;
    public Location(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
}
