package thegalkin.courseWork_v3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import thegalkin.courseWork_v3.domain.Baggage;
import thegalkin.courseWork_v3.repo.BaggageRepo;
import thegalkin.courseWork_v3.repo.EmployeeRepo;

@Service
public class BaggageService {
    private final BaggageRepo baggageRepo;

    @Autowired
    public BaggageService(BaggageRepo baggageRepo){this.baggageRepo = baggageRepo;}

    public Mono<Baggage> getBaggageById(Long id){
        return baggageRepo.findById(id);
    }

}
