package LLD.ParkingLot.domain;

public class FourWheelerSpot extends ParkingSpot {

    public FourWheelerSpot(int id) {
        super(id, true, 500, null);
    }

    @Override
    public VehicleType supportedVehicleType() {
        return VehicleType.FOUR_WHEELER;
    }
}
