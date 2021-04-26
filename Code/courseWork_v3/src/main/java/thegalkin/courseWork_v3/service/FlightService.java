package thegalkin.courseWork_v3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thegalkin.courseWork_v3.domain.Flight;
import thegalkin.courseWork_v3.repo.FlightRepo;

import java.util.Date;
import java.util.function.Predicate;

@Service
public class FlightService {
    private final FlightRepo flightRepo;

    @Autowired
    public FlightService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }


    public Flux<Flight> listAll(){
        return flightRepo.findAll();
    }

    public Flux<Flight> findByCities(String startCity, String endCity) {
        return flightRepo.findAll().filter(v -> {
               return v.getStartCity().equals(startCity) && v.getEndCity().equals(endCity);
                }
        );
    }
    public Flux<Flight> findByDate(Date date){
        return flightRepo.findAll().filter( v ->{
            return v.getStartTime().equals(date.getTime());
                }

        );
    }

    public Flux<Flight> findByCountries(String startCountry, String endCountry){
        return flightRepo.findAll().filter(v->{
            return v.getStartCountry().equals(startCountry) && v.getEndCountry().equals(endCountry);
        });
    }

    public Mono<Flight> addNew(Flight flight){
        return flightRepo.save(flight);
    }

}
