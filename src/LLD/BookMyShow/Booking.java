package LLD.BookMyShow;

import LLD.BookMyShow.models.Payment;
import LLD.BookMyShow.models.Seat;
import LLD.BookMyShow.models.Show;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    Show show;
    List<Seat> bookedSeats = new ArrayList<>();
    Payment payment;

    public Show getShow() { return show; }

    public void setShow(Show show) { this.show = show; }

    public List<Seat> getBookedSeats() { return bookedSeats; }

    public Payment getPayment() { return payment; }

    public void setPayment(Payment payment) { this.payment = payment; }

}
