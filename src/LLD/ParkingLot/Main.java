package LLD.ParkingLot;

import LLD.ParkingLot.domain.FourWheelerSpot;
import LLD.ParkingLot.domain.ParkingSpot;
import LLD.ParkingLot.domain.TwoWheelerSpot;
import LLD.ParkingLot.manager.ParkingSpotManager;
import LLD.ParkingLot.manager.impl.ParkingSpotManagerImpl;

import java.util.List;

public class Main {
    private final ParkingSpotManager parkingSpotManager = new ParkingSpotManagerImpl();

    public void start() {
        System.out.println("Hi, Welcome to Parking Lot!");
        System.out.println("=========================================================");
        System.out.println("Initializing ParkingSpot with 2 TwoWheeler and 2 FourWheeler Spots");

        int id = 1;
        List<ParkingSpot> parkingSpots = List.of(
                new TwoWheelerSpot(id++),
                new TwoWheelerSpot(id++),
                new FourWheelerSpot(id++),
                new FourWheelerSpot(id)
        );

        for (ParkingSpot spot : parkingSpots) {
            System.out.println("Adding parking spot: " + spot.getId());
            parkingSpotManager.addParkingSpace(spot);
        }

        System.out.println("Total Parking Spaces: " + parkingSpots.size());
        System.out.println("=========================================================");
    }

    public static void main(String[] args) {
        new Main().start();
    }
}
