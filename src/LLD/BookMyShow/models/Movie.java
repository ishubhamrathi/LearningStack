package LLD.BookMyShow.models;

import java.time.Duration;

public class Movie {
    private static int idCounter = 1;

    private final int id;
    private final MovieName name;
    private final Duration duration;

    public Movie(MovieName movieName, Duration duration) {
        this.id = idCounter++;
        this.name = movieName;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public MovieName getName() {
        return name;
    }

    public Duration getDuration() {
        return duration;
    }
}
