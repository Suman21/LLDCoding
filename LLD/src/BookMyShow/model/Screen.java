package BookMyShow.model;

import BookMyShow.enums.SeatType;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class Screen {
    private String ScreenId;
    private String ScreenName;
    private List<Seat> SeatList;

    public Screen(String screenId, String screenName, List<Seat> seatList) {
        this.ScreenId = screenId;
        this.ScreenName = screenName;
        this.SeatList = seatList;
    }
}
