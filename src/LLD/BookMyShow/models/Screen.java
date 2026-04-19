package LLD.BookMyShow.models;

import java.util.List;

public class Screen {
    private static int idCounter = 1;

    int id;
    List<Seat> seats;

    public Screen(List<Seat> seats) {
        this.id = idCounter++;
        this.seats = seats
    }

}
