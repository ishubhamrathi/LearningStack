# ParkingLot

Basic parking lot design with parking spots, vehicles, tickets, and a manager that handles allocation and removal.

## How To Run

Compile and run from the project root:

```bash
javac -cp src -d out src/LLD/ParkingLot/Main.java src/LLD/ParkingLot/domain/*.java src/LLD/ParkingLot/manager/*.java src/LLD/ParkingLot/manager/impl/*.java
java -cp out LLD.ParkingLot.Main
```

Expected behavior:

- The application starts.
- It creates 2 two-wheeler spots and 2 four-wheeler spots.
- It prints each added parking spot ID.

## Sample Test Case

Manual scenario:

1. Start the application.
2. Create a `Vehicle("KA01AB1234", VehicleType.TWO_WHEELER)`.
3. Call `parkVehicle(...)` on `ParkingSpotManagerImpl`.
4. Verify a ticket is created and the selected spot is a `TwoWheelerSpot`.
5. Call `removeVehicle(...)` for the same vehicle.
6. Verify the parking spot becomes empty again.

Example expected outcome:

- A two-wheeler is assigned only to a two-wheeler spot.
- If matching spots are full, `parkVehicle` throws `IllegalStateException`.
- Removing a parked vehicle returns a ticket and frees the spot.

## Design Principles Used

- Abstraction: `ParkingSpot` defines the common behavior for all spot types.
- Inheritance: `TwoWheelerSpot` and `FourWheelerSpot` extend `ParkingSpot`.
- Interface-based design: `ParkingSpotManager` separates contract from implementation.
- Single Responsibility Principle: domain classes model data, while the manager handles parking operations.
- Open/Closed Principle: new parking spot types can be added by extending `ParkingSpot` and updating matching logic.

## LLD Design

Core entities:

- `Vehicle` - Stores vehicle number and vehicle type.
- `VehicleType` - Defines supported categories such as `TWO_WHEELER` and `FOUR_WHEELER`.
- `ParkingSpot` - Base class for parking spots with spot ID, occupancy state, price, and parked vehicle.
- `TwoWheelerSpot` and `FourWheelerSpot` - Specialized parking spot types.
- `Ticket` - Represents a parking transaction with entry and exit timestamps.

Service layer:

- `ParkingSpotManager` - Exposes operations to park, remove, add, and delete spots.
- `ParkingSpotManagerImpl` - Maintains in-memory parking spots and allocates a matching free spot by vehicle type.

Interaction flow:

1. `Main` creates parking spots and registers them with `ParkingSpotManagerImpl`.
2. A vehicle is passed to `parkVehicle`.
3. The manager finds the first empty spot that supports the vehicle type.
4. The spot is marked occupied and a `Ticket` is returned.
5. On `removeVehicle`, the manager finds the parked vehicle, frees the spot, and returns a ticket snapshot.

## Files

- `Main.java` - Entry point that initializes sample parking spots.
- `domain/ParkingSpot.java` - Base abstraction for a parking spot.
- `domain/TwoWheelerSpot.java` - Parking spot for two-wheelers.
- `domain/FourWheelerSpot.java` - Parking spot for four-wheelers.
- `domain/Vehicle.java` - Vehicle model with number and type.
- `domain/VehicleType.java` - Supported vehicle categories.
- `domain/Ticket.java` - Ticket generated for parking operations.
- `manager/ParkingSpotManager.java` - Contract for parking operations.
- `manager/impl/ParkingSpotManagerImpl.java` - In-memory parking spot manager implementation.
