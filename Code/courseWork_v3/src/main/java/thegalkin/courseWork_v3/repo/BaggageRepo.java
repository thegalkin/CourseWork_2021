package thegalkin.courseWork_v3.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thegalkin.courseWork_v3.domain.Baggage;

import java.util.Optional;

public interface BaggageRepo extends ReactiveCrudRepository<Baggage, Long> {

    @Query("SELECT * FROM baggage WHERE ownerfullname = :ownerFullName")
    Flux<Baggage> findBaggageByOwnerFullName(String ownerFullName);

    @Query("SELECT * FROM baggage WHERE flightId = :flightId")
    Flux<Baggage> findBaggageByFlightId(Long flightId);

    @Query("SELECT * FROM baggage WHERE targetflightname = :targetFlightName")
    Flux<Baggage> findBaggageByTargetFlightName(String targetFlightName);

    @Query("SELECT * FROM baggage WHERE startcountry = :startCountry")
    Flux<Baggage> findBaggageByStartCountry(String startCountry);

    @Query("SELECT * FROM baggage WHERE endcountry = :endCountry")
    Flux<Baggage> findBaggageByEndCountry(String endCountry);

    @Query("SELECT * FROM baggage WHERE :middleCountry = ANY(middlecountries)")
    Flux<Baggage> findBaggageByMiddleCountry(String middleCountry);
}
