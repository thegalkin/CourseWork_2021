package thegalkin.courseWork_v3.repo;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thegalkin.courseWork_v3.domain.Planes;

public interface PlanesRepo extends ReactiveCrudRepository<Planes, Long> {
    @Query("SELECT * WHERE internationalnumber = :number")
    public Mono<Planes> findPlanesByInternationalNumber(String number);

    @Query("SELECT * WHERE russiannumber = :russianNumber")
    public Mono<Planes> findPlanesByRussianNumber(String russianNumber);

    @Query("SELECT * WHERE boardname = :boardName")
    public Mono<Planes> findPlanesByBoardName(String boardName);

    @Query("SELECT * WHERE model = :model")
    public Flux<Planes> findPlanesByModel(String model);

    @Query("SELECT * WHERE :repairIncident = ANY(repairhistory)")
    public Flux<Planes> findPlanesByRepairHistory(String repairIncident);

    @Query("SELECT * WHERE company = :company")
    public Flux<Planes> findPlanesByOwnerCompany(String company);

    @Query("SELECT * WHERE humancapacity = :humanCapacity")
    public Flux<Planes> findPlanesByHumanCapacity(Integer humanCapacity);

    @Query("SELECT * WHERE personnelcapacity = :personnelCapacity")
    public Flux<Planes> findPlanesByPersonnelCapacity(Integer personnelCapacity);

    @Query("SELECT * WHERE baggagecapacity = :baggageCapacity")
    public Flux<Planes> findPlanesByBaggageCapacity(Integer baggageCapacity);

    @Query("SELECT * WHERE :flightID = ANY(flighthistory)")
    public Mono<Planes> findPlanesByFlightHistoryId(Long flightID);
}
