package LLD.BookMyShow.manager;

import LLD.BookMyShow.models.City;
import LLD.BookMyShow.models.Movie;
import LLD.BookMyShow.models.Show;
import LLD.BookMyShow.models.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreManager {
    private final Map<City, List<Theatre>> cityVsTheatres;

    public TheatreManager() {
        this.cityVsTheatres = new HashMap<>();
    }

    public void addTheatre(Theatre theatre) {
        List<Theatre> theatres = cityVsTheatres.getOrDefault(theatre.getCity(), new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatres.put(theatre.getCity(), theatres);
    }

    public List<Theatre> getTheatresByCity(City city) {
        return cityVsTheatres.getOrDefault(city, new ArrayList<>());
    }

    public Map<Theatre, List<Show>> getAllShows(Movie movie, City city) {
        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();

        for (Theatre theatre : getTheatresByCity(city)) {
            List<Show> matchingShows = new ArrayList<>();

            for (Show show : theatre.getShows()) {
                if (show.getMovie().getName() == movie.getName()) {
                    matchingShows.add(show);
                }
            }

            if (!matchingShows.isEmpty()) {
                theatreVsShows.put(theatre, matchingShows);
            }
        }

        return theatreVsShows;
    }
}
