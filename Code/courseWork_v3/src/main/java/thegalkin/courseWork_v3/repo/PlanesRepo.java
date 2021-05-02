package thegalkin.courseWork_v3.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import thegalkin.courseWork_v3.domain.Planes;

public interface PlanesRepo extends ReactiveCrudRepository<Planes, Long> {
}
