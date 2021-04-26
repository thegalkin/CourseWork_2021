package thegalkin.courseWork_v3.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import thegalkin.courseWork_v3.domain.Flight;

public interface FlightRepo extends ReactiveCrudRepository<Flight, Long> {
}
