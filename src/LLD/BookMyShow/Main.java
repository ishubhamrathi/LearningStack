package LLD.BookMyShow;

import LLD.BookMyShow.manager.BookMyShow;
import LLD.BookMyShow.models.City;
import LLD.BookMyShow.models.MovieName;

public class Main {
    public static void main(String[] args) {
        System.out.println("BookMyShow LLD Code");

        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        bookMyShow.createBooking(City.BENGALURU, MovieName.AVENGERS);
        bookMyShow.createBooking(City.BENGALURU, MovieName.CAPTAIN_AMERICA);
        bookMyShow.createBooking(City.DELHI, MovieName.CAPTAIN_AMERICA);
    }
}
