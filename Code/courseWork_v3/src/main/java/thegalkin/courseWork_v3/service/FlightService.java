package thegalkin.courseWork_v3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thegalkin.courseWork_v3.domain.Flights;
import thegalkin.courseWork_v3.repo.FlightRepo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    private final FlightRepo flightRepo;

    @Autowired
    public FlightService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }


    public Flux<Flights> listAll(){
        return flightRepo.findAll();
    }

    public Flux<Flights> findByCities(String startCity, String endCity) {
        return flightRepo.findAll().filter(v -> {
               return v.getStartCity().equals(startCity) && v.getEndCity().equals(endCity);
                }
        );
    }
    public Flux<Flights> findByDate(Date date){
        return flightRepo.findAll().filter( v ->{
            return v.getStartTime().equals(date.getTime());
                }

        );
    }

    public Mono<Flights> findById(Long id){
        return flightRepo.findById(id);
    }
    public Flux<Flights> findByCountries(String startCountry, String endCountry){
        return flightRepo.findAll().filter(v->{
            return v.getStartCountry().equals(startCountry) && v.getEndCountry().equals(endCountry);
        });
    }

    public Mono<Flights> addNew(Flights flight){
        return flightRepo.save(flight);
    }

    public Flux<Flights> deleteFlightById(Long id){
        try{
            flightRepo.deleteById(id).block();
            return flightRepo.findAll();
        } catch (Exception e){
            return Flux.empty();
        }
    }

    public Flux<Boolean> listAllSeats(Long flightId){
//        если место занято - вернет false, если свободно - true
        return  Flux
                .fromIterable(
                        flightRepo
                                .findAll()
                                .toStream()
                                .map(
                                v-> v.getSeatsFullNames().isEmpty()
                                )
                                .collect(Collectors.toList())
        );
    }

    public Mono<Boolean> initialTickerReservation(Long flightId, List<Integer> ticketPlacesList){
        //если рейс существует, то
        if (!flightRepo.findById(flightId).equals(Mono.empty())){
            for (int i = 0; i < ticketPlacesList.stream().count(); i++) {
                final int j = i;
                if (flightRepo.findAll().map(v->
                        v.getSeatsFullNames()
                                .get(ticketPlacesList.get(j)).equals("")).toStream().allMatch(s->s.equals(true))){
                    return Mono.just(false);
                }
            }
            Calendar date = Calendar.getInstance();
            date.add(Calendar.MINUTE, 20);
            for (int i = 0; i < ticketPlacesList.stream().count(); i++) {
                flightRepo.updateSeatsFullName(ticketPlacesList.get(i), date.toString());
            }

            return Mono.just(true);
        }else{
            return Mono.just(false);
        }
    }
}
