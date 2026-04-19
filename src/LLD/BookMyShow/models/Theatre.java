package LLD.BookMyShow.models;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private static int idCounter = 1;

    private final int id;
    private final List<Show> shows;
    private final List<Screen> screens;
    private final City city;

    public Theatre(List<Screen> screens, City city) {
        this.id = idCounter++;
        this.screens = screens;
        this.city = city;
        this.shows = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Show> getShows() {
        return shows;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public City getCity() {
        return city;
    }

    public void setShows(List<Show> shows) {
        this.shows.clear();
        this.shows.addAll(shows);
    }
}
