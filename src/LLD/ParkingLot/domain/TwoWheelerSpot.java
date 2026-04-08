package LLD.ParkingLot.domain;

public class TwoWheelerSpot extends ParkingSpot {

    public TwoWheelerSpot(int id) {
        super(id, true, 200, null);
    }

    @Override
    public VehicleType supportedVehicleType() {
        return VehicleType.TWO_WHEELER;
    }
}
