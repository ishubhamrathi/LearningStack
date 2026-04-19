package LLD.BookMyShow.manager;

import LLD.BookMyShow.models.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BookMyShow {
    MoviesManager moviesManager;
    TheatreManager theatreManager;

    public BookMyShow() {
        moviesManager = new MoviesManager();
        theatreManager = new TheatreManager();
    }

    public void initialize() {
        createMovies();
        createTheatres();
    }

    public void createBooking(City city, MovieName movieName) {}

    private void createMovies() {
        Movie movie1 = new Movie(MovieName.AVENGERS, Duration.ofMinutes(128));
        Movie movie2 = new Movie(MovieName.CAPTAIN_AMERICA, Duration.ofMinutes(128));

        moviesManager.addMovie(movie1, City.BENGALURU);
        moviesManager.addMovie(movie1, City.DELHI);
        moviesManager.addMovie(movie2, City.BENGALURU);
        moviesManager.addMovie(movie2, City.DELHI);
    }
    private void createTheatres() {
        Movie avengers = moviesManager.getMovieByName(MovieName.AVENGERS);
        Movie captainAmerica = moviesManager.getMovieByName(MovieName.CAPTAIN_AMERICA);

        Theatre inoxTheatre = new Theatre(createScreen(), City.DELHI);
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShow(inoxTheatre.getScreens().getFirst(), avengers, LocalTime.of(8,0));
        Show inoxEveningShow = createShow(inoxTheatre.getScreens().getFirst(), avengers, LocalTime.of(18, 0));;
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShows(inoxShows);

        Theatre pvrTheatre = new Theatre(createScreen(), City.DELHI);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShows = createShow(pvrTheatre.getScreens().getFirst(), avengers, LocalTime.of(8,0));
        Show pvrEveningShow = createShow(pvrTheatre.getScreens().getFirst(), avengers, LocalTime.of(18, 0));;
        inoxShows.add(pvrMorningShows);
        inoxShows.add(pvrEveningShow);
        inoxTheatre.setShows(pvrShows);
    }

    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        return screens;
    }

    private Show createShow(Screen screen, Movie movie, LocalTime showStartTime) {
        return new Show();
    }

    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();

    }
}
