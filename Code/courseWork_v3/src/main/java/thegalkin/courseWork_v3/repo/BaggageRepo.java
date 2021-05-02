package thegalkin.courseWork_v3.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import thegalkin.courseWork_v3.domain.Baggage;

public interface BaggageRepo extends ReactiveCrudRepository<Baggage, Long> {
}
