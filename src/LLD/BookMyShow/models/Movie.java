package LLD.BookMyShow.models;

import java.time.Duration;

public class Movie {
    private static int idCounter = 1;

    int id;
    MovieName name;
    Duration duration;

    public Movie(MovieName movieName, Duration duration) {
        this.id = idCounter++;
        this.name = movieName;
    }

    public MovieName getName() {
        return name;
    }
}
