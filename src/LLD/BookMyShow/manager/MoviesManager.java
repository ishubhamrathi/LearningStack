package LLD.BookMyShow.manager;

import LLD.BookMyShow.models.City;
import LLD.BookMyShow.models.Movie;
import LLD.BookMyShow.models.MovieName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoviesManager {
    private final Map<City, List<Movie>> cityVsMovies;
    private final List<Movie> movies;

    public MoviesManager() {
        this.movies = new ArrayList<>();
        this.cityVsMovies = new HashMap<>();
        System.out.println("Movies list initialized");
    }

    public void addMovie(Movie movie, City city) {
        if (!movies.contains(movie)) {
            movies.add(movie);
        }

        List<Movie> moviesList = cityVsMovies.getOrDefault(city, new ArrayList<>());
        if (!moviesList.contains(movie)) {
            moviesList.add(movie);
        }
        cityVsMovies.put(city, moviesList);

        System.out.println("Movie " + movie.getName() + " is added for city " + city.name());
    }

    public Movie getMovieByName(MovieName movieName) {
        for (Movie movie : movies) {
            if (movie.getName() == movieName) {
                return movie;
            }
        }
        return null;
    }

    public List<Movie> getMoviesByCity(City city) {
        return cityVsMovies.getOrDefault(city, new ArrayList<>());
    }
}
