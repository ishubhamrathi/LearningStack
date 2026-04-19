package LLD.BookMyShow;

import LLD.BookMyShow.manager.BookMyShow;
import LLD.BookMyShow.models.City;
import LLD.BookMyShow.models.MovieName;

public class Main {
    void main() {
        IO.println("BookMyShow LLD Code");
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        // user1
        bookMyShow.createBooking(City.BENGALURU, MovieName.AVENGERS);
        // user2
        bookMyShow.createBooking(City.BENGALURU, MovieName.CAPTAIN_AMERICA);
        // user3
        bookMyShow.createBooking(City.DELHI, MovieName.CAPTAIN_AMERICA);

    }
}
