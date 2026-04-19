package LLD.BookMyShow.models;

import java.util.EnumMap;
import java.util.Map;

public class Seat {
    private static int idCounter = 1;
    private static final Map<SeatType, Double> SEAT_TYPE_VS_PRICE = new EnumMap<>(SeatType.class);

    static {
        SEAT_TYPE_VS_PRICE.put(SeatType.NORMAL, 150.0);
        SEAT_TYPE_VS_PRICE.put(SeatType.PREMIUM, 250.0);
    }

    private final int id;
    private final SeatType seatType;

    public Seat(SeatType seatType) {
        this.id = idCounter++;
        this.seatType = seatType;
    }

    public int getId() {
        return id;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public double getPrice() {
        return SEAT_TYPE_VS_PRICE.get(seatType);
    }
}
