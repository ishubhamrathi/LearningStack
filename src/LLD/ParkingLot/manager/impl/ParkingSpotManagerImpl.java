package LLD.ParkingLot.manager.impl;

import LLD.ParkingLot.domain.ParkingSpot;
import LLD.ParkingLot.domain.Ticket;
import LLD.ParkingLot.domain.Vehicle;
import LLD.ParkingLot.manager.ParkingSpotManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingSpotManagerImpl implements ParkingSpotManager {

    private final List<ParkingSpot> allParkingSpot = new ArrayList<>();
    private final AtomicInteger ticketCounter = new AtomicInteger(1);

    @Override
    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = findParkingSpace(vehicle);
        if (parkingSpot == null) {
            throw new IllegalStateException("No parking space available for " + vehicle.getVehicleType());
        }

        parkingSpot.parkVehicle(vehicle);
        return new Ticket(ticketCounter.getAndIncrement(), vehicle, parkingSpot, LocalDateTime.now(), null);
    }

    @Override
    public Ticket removeVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : allParkingSpot) {
            if (!parkingSpot.isEmpty() && vehicle.equals(parkingSpot.getVehicle())) {
                parkingSpot.removeVehicle();
                return new Ticket(ticketCounter.getAndIncrement(), vehicle, parkingSpot, LocalDateTime.now(), LocalDateTime.now());
            }
        }

        throw new IllegalArgumentException("Vehicle not found in parking lot: " + vehicle.getVehicleNo());
    }

    @Override
    public ParkingSpot findParkingSpace(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : allParkingSpot) {
            if (parkingSpot.isEmpty() && parkingSpot.supportedVehicleType() == vehicle.getVehicleType()) {
                return parkingSpot;
            }
        }
        return null;
    }

    @Override
    public void addParkingSpace(ParkingSpot parkingSpot) {
        allParkingSpot.add(parkingSpot);
    }

    @Override
    public void removeParkingSpace(ParkingSpot parkingSpot) {
        allParkingSpot.remove(parkingSpot);
    }
}
