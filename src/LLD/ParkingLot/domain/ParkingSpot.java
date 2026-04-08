package LLD.ParkingLot.domain;

public abstract class ParkingSpot {
    private final int id;
    private boolean empty;
    private final int price;
    private Vehicle vehicle;

    protected ParkingSpot(int id, boolean empty, int price, Vehicle vehicle) {
        this.id = id;
        this.empty = empty;
        this.price = price;
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public boolean isEmpty() {
        return empty;
    }

    public int getPrice() {
        return price;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.empty = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.empty = true;
    }

    public abstract VehicleType supportedVehicleType();
}
