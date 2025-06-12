package BookMyShow.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class SeatLock {
    private String showId;
    private Seat seat;
    private User user;
    private LocalDateTime lockDateTime;

    public SeatLock(String showId, Seat seat, User user) {
        this.showId = showId;
        this.seat = seat;
        this.user = user;
        this.lockDateTime = LocalDateTime.now();
    }
}
