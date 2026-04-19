package LLD.BookMyShow;

import LLD.BookMyShow.models.Payment;
import LLD.BookMyShow.models.Seat;
import LLD.BookMyShow.models.Show;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private static int idCounter = 1;

    private final int id;
    private Show show;
    private final List<Seat> bookedSeats = new ArrayList<>();
    private Payment payment;
    private double totalAmount;

    public Booking() {
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void addBookedSeat(Seat seat) {
        bookedSeats.add(seat);
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
