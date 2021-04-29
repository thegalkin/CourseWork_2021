package thegalkin.courseWork_v3.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import thegalkin.courseWork_v3.domain.Employees;

public interface EmployeeRepo extends ReactiveCrudRepository<Employees, Long> {
}
