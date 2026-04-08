package LLD.ParkingLot.domain;

import java.time.LocalDateTime;

public class Ticket {
    private final int id;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final LocalDateTime entryDateTime;
    private LocalDateTime exitDateTime;

    public Ticket(int id, Vehicle vehicle, ParkingSpot parkingSpot, LocalDateTime entryDateTime, LocalDateTime exitDateTime) {
        this.id = id;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryDateTime = entryDateTime;
        this.exitDateTime = exitDateTime;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getEntryDateTime() {
        return entryDateTime;
    }

    public LocalDateTime getExitDateTime() {
        return exitDateTime;
    }

    public void setExitDateTime(LocalDateTime exitDateTime) {
        this.exitDateTime = exitDateTime;
    }
}
