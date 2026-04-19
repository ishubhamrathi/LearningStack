package LLD.BookMyShow.models;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    public static int idCounter = 1;

    int id;
    List<Show> shows;
    List<Screen> screens;
    City city;

    public Theatre(List<Screen> screens, City city) {
        this.id = idCounter++;
        this.screens = screens;
        this.city = city;
    }

    public void setShows(List<Show> shows) {
        this.shows.addAll(shows);
    }

    public List<Screen> getScreens() {
        return this.screens;
    }
}
