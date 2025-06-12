package BookMyShow.model;

import BookMyShow.enums.SeatStatus;
import BookMyShow.enums.SeatType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat {
    private String SeatId;
    private String SeatNumber;
    private SeatType SeatType;
    private SeatStatus SeatStatus;

    public Seat(String seatId, String seatNumber, SeatType seatType, SeatStatus seatStatus) {
        this.SeatId = seatId;
        this.SeatNumber = seatNumber;
        this.SeatType = seatType;
        this.SeatStatus = seatStatus;
    }
}
