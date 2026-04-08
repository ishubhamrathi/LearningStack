package LLD.ParkingLot.domain;

import java.util.Objects;

public class Vehicle {
    private final String vehicleNo;
    private final VehicleType vehicleType;

    public Vehicle(String vehicleNo, VehicleType vehicleType) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vehicleNo, vehicle.vehicleNo) && vehicleType == vehicle.vehicleType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleNo, vehicleType);
    }
}
