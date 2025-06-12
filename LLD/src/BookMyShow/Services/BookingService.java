package BookMyShow.Services;

import BookMyShow.enums.BookingStatus;
import BookMyShow.enums.SeatStatus;
import BookMyShow.model.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class BookingService {
    private final SeatLockerService seatLockerService;

    public BookingService()
    {
        seatLockerService = new SeatLockerService();
    }

    public Booking createBooking(User user, List<Seat> seatList, Show show)
    {
        boolean checkStatus = seatLockerService.SeatLock(show.getShowId(), user, seatList);
        if(!checkStatus)
            throw new RuntimeException("Seat locked by user");

        return new Booking(UUID.randomUUID().toString(), LocalDateTime.now()
        , seatList, show, BookingStatus.PENDING);
    }

    public void confirmBooking(Booking booking, Payment payment)
    {
        booking.setBookingStatus(BookingStatus.CONFIRMED);
        booking.setPayment(payment);
        for(Seat seat : booking.getSeatList())
        {
            seat.setSeatStatus(SeatStatus.BOOKED);
        }
    }

    public void cancelBooking(Booking booking, Payment payment)
    {
        booking.setBookingStatus(BookingStatus.CANCELLED);
        seatLockerService.SeatUnLock(booking.getSeatList());

    }
}
