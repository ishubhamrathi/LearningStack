package LLD.BookMyShow.manager;

import LLD.BookMyShow.models.City;
import LLD.BookMyShow.models.Movie;
import LLD.BookMyShow.models.MovieName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoviesManager {
    Map<City, List<Movie>> cityVsMovies;
    List<Movie> movies;

    public MoviesManager () {
        movies = new ArrayList<>();
        cityVsMovies = new HashMap<>();
        IO.println("Movies List initialized with empty!");
    }

    public void addMovie(Movie movie, City city) {
        movies.add(movie);
        List<Movie> moviesList = cityVsMovies.getOrDefault(city, new ArrayList<>());
        moviesList.add(movie);
        cityVsMovies.put(city, moviesList);
        IO.println("Movie: " + movie.getName() + " is added to the list with city " + city.name());
    }

    public Movie getMovieByName(MovieName movieName) {
        for (Movie movie: movies) {
            IO.println("Movie found with name" + movieName);
            if (movie.getName() == movieName) return movie;
        }

        IO.println("No Movie found with name "  + movieName);
        return null;
    }
}
