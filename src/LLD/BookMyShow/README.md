# BookMyShow

Minimal movie ticket booking low-level design. It models movies, theatres, shows, screens, seats, bookings, and payment for a basic console flow.

## How To Run

Compile from the project root:

```bash
javac -d out src/LLD/BookMyShow/Main.java src/LLD/BookMyShow/Booking.java src/LLD/BookMyShow/manager/*.java src/LLD/BookMyShow/models/*.java
```

Run:

```bash
java -cp out LLD.BookMyShow.Main
```

Java main class: `LLD.BookMyShow.Main`

## Sample Test Case

1. Run the `Main` class from the project root.
2. Let the system initialize movies for `DELHI` and `BENGALURU`.
3. Observe booking creation for `BENGALURU, AVENGERS`.
4. Observe booking creation for `BENGALURU, CAPTAIN_AMERICA`.
5. Observe booking creation for `DELHI, CAPTAIN_AMERICA`.

Expected result:

- A theatre and show are selected for the requested city and movie.
- Two available seats are booked for each request.
- Payment is created with `SUCCESS` status.
- Booking summary is printed to the console.

## Design Principles Used

- Composition
- Abstraction
- Single Responsibility Principle

## LLD Design

- Core entities:
- `Movie` stores movie details like name and duration.
- `Theatre` contains screens and shows for a city.
- `Screen` contains seats.
- `Seat` stores seat type and derives price from an internal seat-type pricing map.
- `Show` maps a movie to a screen and tracks booked seats.
- `Booking` stores selected show, booked seats, total amount, and payment.
- `Payment` stores payment amount and status.

- Service or manager layer:
- `MoviesManager` stores movies available by city.
- `TheatreManager` stores theatres by city and returns matching shows for a movie.
- `BookMyShow` initializes sample data and orchestrates the booking flow.

1. User selects city and movie.
2. `BookMyShow` fetches the movie from `MoviesManager`.
3. `TheatreManager` returns matching theatres and shows for that city and movie.
4. The first matching show is selected.
5. Available seats are collected from the selected screen.
6. Seats are marked as booked in the show.
7. Payment and booking objects are created and printed.

## Files

- `Main.java` - entry point to initialize the system and create sample bookings.
- `Booking.java` - stores booking details for a selected show.
- `manager/BookMyShow.java` - main coordinator for setup and booking flow.
- `manager/MoviesManager.java` - stores and retrieves movies by city.
- `manager/TheatreManager.java` - stores theatres and filters shows by city and movie.
- `models/Movie.java` - represents a movie with name and duration.
- `models/MovieName.java` - enum for supported movies.
- `models/City.java` - enum for supported cities.
- `models/Theatre.java` - theatre entity containing screens and shows.
- `models/Screen.java` - screen entity containing seats.
- `models/Seat.java` - seat entity with seat type and price lookup.
- `models/SeatType.java` - enum for seat categories.
- `models/Show.java` - show entity with booked seat tracking.
- `models/Payment.java` - payment entity for a booking.
- `models/PaymentStatus.java` - enum for payment status.
