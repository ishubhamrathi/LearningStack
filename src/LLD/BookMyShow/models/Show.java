package LLD.BookMyShow.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Show {
    private static int idCounter = 1;

    private final int id;
    private final Movie movie;
    private final Screen screen;
    private final LocalDateTime startTime;
    private final List<Integer> bookedSeats;

    public Show(Movie movie, Screen screen, LocalDateTime startTime) {
        this.id = idCounter++;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.bookedSeats = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public boolean isSeatAvailable(Seat seat) {
        return !bookedSeats.contains(seat.getId());
    }

    public void bookSeat(Seat seat) {
        bookedSeats.add(seat.getId());
    }
}
