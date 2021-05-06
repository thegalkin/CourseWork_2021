package thegalkin.courseWork_v3.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import thegalkin.courseWork_v3.domain.Flights;

import java.util.List;

public interface FlightRepo extends ReactiveCrudRepository<Flights, Long> {
    @Query("UPDATE flights SET seatsFullNames[:placeToReplace] = :newValue")
    Flux<Flights> updateSeatsFullName(int placeToReplace, String newValue);

    @Query("SELECT seatsFullNames FROM flights")
    List<String> getAllSeatFullNamesFromFlights();
}
