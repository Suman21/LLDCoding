package BookMyShow.model;

import BookMyShow.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Payment {
    private String PaymentID;
    private LocalDateTime PaymentDateTime;
    private PaymentStatus PaymentStatus;
    private double TotalAmount;

    public Payment(String PaymentId, LocalDateTime PaymentDateTime, PaymentStatus PaymentStatus, double TotalAmount) {
        this.PaymentID = PaymentId;
        this.PaymentDateTime = PaymentDateTime;
        this.PaymentStatus = PaymentStatus;
        this.TotalAmount = TotalAmount;
    }
}
