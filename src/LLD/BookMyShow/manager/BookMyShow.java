package LLD.BookMyShow.manager;

import LLD.BookMyShow.Booking;
import LLD.BookMyShow.models.City;
import LLD.BookMyShow.models.Movie;
import LLD.BookMyShow.models.MovieName;
import LLD.BookMyShow.models.Payment;
import LLD.BookMyShow.models.PaymentStatus;
import LLD.BookMyShow.models.Screen;
import LLD.BookMyShow.models.Seat;
import LLD.BookMyShow.models.SeatType;
import LLD.BookMyShow.models.Show;
import LLD.BookMyShow.models.Theatre;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    private final MoviesManager moviesManager;
    private final TheatreManager theatreManager;

    public BookMyShow() {
        this.moviesManager = new MoviesManager();
        this.theatreManager = new TheatreManager();
    }

    public void initialize() {
        createMovies();
        createTheatres();
    }

    public void createBooking(City city, MovieName movieName) {
        Movie movie = moviesManager.getMovieByName(movieName);
        if (movie == null) {
            System.out.println("Booking failed. Movie not found: " + movieName);
            return;
        }

        Map<Theatre, List<Show>> theatreVsShows = theatreManager.getAllShows(movie, city);
        if (theatreVsShows.isEmpty()) {
            System.out.println("Booking failed. No shows available for " + movieName + " in " + city);
            return;
        }

        Theatre selectedTheatre = theatreVsShows.keySet().iterator().next();
        Show selectedShow = theatreVsShows.get(selectedTheatre).get(0);
        List<Seat> availableSeats = getAvailableSeats(selectedShow);

        if (availableSeats.size() < 2) {
            System.out.println("Booking failed. Not enough seats available for show " + selectedShow.getId());
            return;
        }

        Booking booking = new Booking();
        booking.setShow(selectedShow);

        double totalAmount = 0;
        for (int i = 0; i < 2; i++) {
            Seat seat = availableSeats.get(i);
            selectedShow.bookSeat(seat);
            booking.addBookedSeat(seat);
            totalAmount += seat.getPrice();
        }

        booking.setTotalAmount(totalAmount);
        booking.setPayment(new Payment(totalAmount, PaymentStatus.SUCCESS));

        System.out.println("Booking successful");
        System.out.println("Booking Id: " + booking.getId());
        System.out.println("Theatre Id: " + selectedTheatre.getId());
        System.out.println("Show Id: " + selectedShow.getId());
        System.out.println("Booked Seat Ids: " + getSeatIds(booking.getBookedSeats()));
        System.out.println("Amount Paid: " + booking.getTotalAmount());
        System.out.println("Payment Status: " + booking.getPayment().getPaymentStatus());
        System.out.println();
    }

    private void createMovies() {
        Movie movie1 = new Movie(MovieName.AVENGERS, Duration.ofMinutes(128));
        Movie movie2 = new Movie(MovieName.CAPTAIN_AMERICA, Duration.ofMinutes(124));

        moviesManager.addMovie(movie1, City.BENGALURU);
        moviesManager.addMovie(movie1, City.DELHI);
        moviesManager.addMovie(movie2, City.BENGALURU);
        moviesManager.addMovie(movie2, City.DELHI);
    }

    private void createTheatres() {
        Movie avengers = moviesManager.getMovieByName(MovieName.AVENGERS);
        Movie captainAmerica = moviesManager.getMovieByName(MovieName.CAPTAIN_AMERICA);

        Theatre inoxTheatre = new Theatre(createScreens(), City.DELHI);
        List<Show> inoxShows = new ArrayList<>();
        inoxShows.add(createShow(inoxTheatre.getScreens().get(0), avengers, LocalTime.of(8, 0)));
        inoxShows.add(createShow(inoxTheatre.getScreens().get(0), captainAmerica, LocalTime.of(18, 0)));
        inoxTheatre.setShows(inoxShows);
        theatreManager.addTheatre(inoxTheatre);

        Theatre pvrTheatre = new Theatre(createScreens(), City.BENGALURU);
        List<Show> pvrShows = new ArrayList<>();
        pvrShows.add(createShow(pvrTheatre.getScreens().get(0), avengers, LocalTime.of(9, 0)));
        pvrShows.add(createShow(pvrTheatre.getScreens().get(0), captainAmerica, LocalTime.of(19, 0)));
        pvrTheatre.setShows(pvrShows);
        theatreManager.addTheatre(pvrTheatre);
    }

    private List<Screen> createScreens() {
        List<Screen> screens = new ArrayList<>();
        screens.add(new Screen(createSeats()));
        screens.add(new Screen(createSeats()));
        return screens;
    }

    private Show createShow(Screen screen, Movie movie, LocalTime showStartTime) {
        LocalDateTime startDateTime = LocalDateTime.of(LocalDateTime.now().toLocalDate(), showStartTime);
        return new Show(movie, screen, startDateTime);
    }

    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();

        for (int i = 0; i < 40; i++) {
            seats.add(new Seat(SeatType.NORMAL));
        }

        for (int i = 0; i < 10; i++) {
            seats.add(new Seat(SeatType.PREMIUM));
        }

        return seats;
    }

    private List<Seat> getAvailableSeats(Show show) {
        List<Seat> availableSeats = new ArrayList<>();

        for (Seat seat : show.getScreen().getSeats()) {
            if (show.isSeatAvailable(seat)) {
                availableSeats.add(seat);
            }
        }

        return availableSeats;
    }

    private List<Integer> getSeatIds(List<Seat> seats) {
        List<Integer> seatIds = new ArrayList<>();

        for (Seat seat : seats) {
            seatIds.add(seat.getId());
        }

        return seatIds;
    }
}
