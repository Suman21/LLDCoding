package BookMyShow.Services;

import BookMyShow.enums.SeatStatus;
import BookMyShow.model.Seat;
import BookMyShow.model.SeatLock;
import BookMyShow.model.User;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SeatLockerService {
    private ConcurrentHashMap<String, SeatLock> seatLockMap;

    public SeatLockerService()
    {
        this.seatLockMap = new ConcurrentHashMap<>();
    }

    public synchronized boolean SeatLock(String showId , User user, List<Seat> seats) {
        for (Seat seat : seats) {
            if(seatLockMap.containsKey(seat.getSeatId()))
                return false;
        }

        for(Seat seat : seats){

            seatLockMap.put(seat.getSeatId(), new SeatLock(showId,seat, user));
            seat.setSeatStatus(SeatStatus.LOCKED);
        }
        return true;
    }

    public synchronized void SeatUnLock(List<Seat> seats) {
        for(Seat seat : seats){
            seatLockMap.remove(seat.getSeatId());
            seat.setSeatStatus(SeatStatus.AVAILABLE);
        }
    }
}
