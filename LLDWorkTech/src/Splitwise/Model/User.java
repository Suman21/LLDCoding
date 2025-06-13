package Splitwise.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private final String userId;
    private String userName;
    private String MobileNumber;
    private String Email;

    public User(String userId, String userName, String mobileNumber, String email) {
        this.userId = userId;
        this.userName = userName;
        this.MobileNumber = mobileNumber;
        this.Email = email;
    }
}
