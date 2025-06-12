package BookMyShow.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String Name;
    private String Email;
    private String UserId;

    public User(String Name, String Email, String UserId) {
        this.Name = Name;
        this.Email = Email;
        this.UserId = UserId;
    }
}
