package LLD.BookMyShow.models;

public class Seat {
    private static int idCounter = 1;
    int id;
    SeatType seatType;

    public Seat(SeatType seatType) {
        this.seatType = seatType;
        this.id = idCounter++;
    }

}
