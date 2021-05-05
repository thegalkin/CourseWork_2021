package thegalkin.courseWork_v3.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thegalkin.courseWork_v3.domain.Employees;
import thegalkin.courseWork_v3.repo.EmployeeRepo;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Mono<Employees> addNew(Employees employee){
        return employeeRepo.save(employee);
    }

    public Flux<Employees> listAll(){
        return employeeRepo.findAll();
    }

    public Mono<Employees> getById(Long id){
        return employeeRepo.findById(id);
    }

    public Flux<Employees> findByRole(String role){
        return employeeRepo.findAll().filter(v -> {
           return v.getRole().equals(role);
        });
    }

    public Flux<Employees> findByLicense(String license){
        return employeeRepo
                .findAll()
                .filter(v->{
            return !v.getLicenses().isEmpty();
        })
                .filter(v->{
                return v.getLicenses().contains(license);
        });
    }

    public Flux<Employees> findByVisa(String visa){
        return employeeRepo
                .findAll()
                .filter(v->{
                    return !v.getVisas().isEmpty();
                })
                .filter(v->{
                    return v.getVisas().contains(visa);
                });
    }
    public Flux<Employees> findByCountryOfOrigin(String country){
        return employeeRepo.findAll().filter(v->{
            return v.getCountryoforigin().equals(country);
        });
    }

    public Flux<Employees> deleteEmployeeById(Long id){
        try{
            employeeRepo.deleteById(id).block();
            return employeeRepo.findAll();
        }catch (Exception e){
            return Flux.empty();
        }
    }
}
