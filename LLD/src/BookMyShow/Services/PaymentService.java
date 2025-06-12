package BookMyShow.Services;

import BookMyShow.enums.PaymentStatus;
import BookMyShow.model.Payment;

import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentService {

    public Payment processPayment(double amount) {
        return new Payment(UUID.randomUUID().toString(), LocalDateTime.now(), PaymentStatus.SUCCESS,amount);
    }
}
