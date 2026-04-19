package LLD.BookMyShow.models;

import java.time.LocalDateTime;
import java.util.List;

public class Show {
    int id;
    Movie movie;
    Show show;
    LocalDateTime startTime;
    List<Integer> bookedSeats;
}
