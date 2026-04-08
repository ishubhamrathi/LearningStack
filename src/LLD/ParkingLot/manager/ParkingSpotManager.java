package LLD.ParkingLot.manager;

import LLD.ParkingLot.domain.ParkingSpot;
import LLD.ParkingLot.domain.Ticket;
import LLD.ParkingLot.domain.Vehicle;

public interface ParkingSpotManager {

    Ticket parkVehicle(Vehicle vehicle);

    Ticket removeVehicle(Vehicle vehicle);

    ParkingSpot findParkingSpace(Vehicle vehicle);

    void addParkingSpace(ParkingSpot parkingSpot);

    void removeParkingSpace(ParkingSpot parkingSpot);
}
