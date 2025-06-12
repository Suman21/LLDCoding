package BookMyShow.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Movie {
    private String Title;
    private int MovieId;
    private List<String> Genre;
    private long duration;

    public Movie(String Title, int MovieId, List<String> Genre, long duration) {
        this.Title = Title;
        this.MovieId = MovieId;
        this.Genre = Genre;
        this.duration = duration;
    }
}
