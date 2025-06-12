package BookMyShow.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Show {
    private String ShowId;
    private Movie movie;
    private Screen screen;
    private LocalDateTime StartTime;
    private LocalDateTime EndTime;

    public Show(String ShowId, Movie movie, Screen screen, LocalDateTime StartTime, LocalDateTime EndTime) {
        this.ShowId = ShowId;
        this.movie = movie;
        this.screen = screen;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
    }
}
