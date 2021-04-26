package thegalkin.courseWork_v3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thegalkin.courseWork_v3.domain.Employee;
import thegalkin.courseWork_v3.repo.EmployeeRepo;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Mono<Employee> addNew(Employee employee){
        return employeeRepo.save(employee);
    }

    public Flux<Employee> listAll(){
        return employeeRepo.findAll();
    }

    public Mono<Employee> getById(Long id){
        return employeeRepo.findById(id);
    }

    public Flux<Employee> findByRole(String role){
        return employeeRepo.findAll().filter(v -> {
           return v.getRole().equals(role);
        });
    }

    public Flux<Employee> findByLicense(String license){
        return employeeRepo
                .findAll()
                .filter(v->{
            return !v.getLicenses().isEmpty();
        })
                .filter(v->{
                return v.getLicenses().contains(license);
        });
    }

    public Flux<Employee> findByVisa(String visa){
        return employeeRepo
                .findAll()
                .filter(v->{
                    return !v.getVisas().isEmpty();
                })
                .filter(v->{
                    return v.getVisas().contains(visa);
                });
    }
    public Flux<Employee> findByCountryOfOrigin(String country){
        return employeeRepo.findAll().filter(v->{
            return v.getCountryOfOrigin().equals(country);
        });
    }
}
