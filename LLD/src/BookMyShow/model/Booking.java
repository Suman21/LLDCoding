package BookMyShow.model;

import BookMyShow.enums.BookingStatus;
import BookMyShow.enums.PaymentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Booking {
    private String BookingID;
    private LocalDateTime BookingDateTime;
    private List<Seat> seatList;
    private Show show;
    private BookingStatus bookingStatus;
    private Payment payment;

    public Booking(String BookingID, LocalDateTime BookingDateTime, List<Seat> seatList,Show show, BookingStatus bookingStatus) {
        this.BookingID = BookingID;
        this.BookingDateTime = BookingDateTime;
        this.show = show;
        this.bookingStatus = bookingStatus;
        this.seatList = seatList;
        //this.paymentStatus = PaymentStatus.INITIATED;
    }
}
