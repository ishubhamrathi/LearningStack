package LLD.BookMyShow.models;

import java.util.List;

public class Screen {
    private static int idCounter = 1;

    private final int id;
    private final List<Seat> seats;

    public Screen(List<Seat> seats) {
        this.id = idCounter++;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
