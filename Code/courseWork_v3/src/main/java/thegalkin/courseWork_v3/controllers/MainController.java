package thegalkin.courseWork_v3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thegalkin.courseWork_v3.domain.Baggage;
import thegalkin.courseWork_v3.domain.Employees;
import thegalkin.courseWork_v3.domain.Flights;
import thegalkin.courseWork_v3.domain.Planes;
import thegalkin.courseWork_v3.repo.BaggageRepo;
import thegalkin.courseWork_v3.repo.PlanesRepo;
import thegalkin.courseWork_v3.service.EmployeeService;
import thegalkin.courseWork_v3.service.FlightService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {
    private final FlightService flightService;
    private final EmployeeService employeeService;

    private final BaggageRepo baggageRepo;
    private final PlanesRepo planesRepo;

    @Autowired
    public MainController(FlightService flightService, EmployeeService employeeService, BaggageRepo baggageRepo, PlanesRepo planesRepo) {
        this.flightService = flightService;
        this.employeeService = employeeService;
        this.baggageRepo = baggageRepo;
        this.planesRepo = planesRepo;
    }

//  Работа с рейсами

    /**

     Тут и у сотрудников еще используется сервисный подход, от которого я отказался,
     поскольку проект, очевино, краткосрочный, и проще написать через интерфейсы
     Да и в целом, особо сложной логики у меня не используется на функциях, соответственно,
     сликом massive controller я вряд ли получил бы.
     */

    @PostMapping("/addFlight")
    public Mono<Flights> addFlight(
            @RequestBody Flights flights
    ){
        return flightService.addNew(flights);
    }

    @RequestMapping("/listAllFlights")
    public Flux<Flights> listAllFlights() {
        return flightService.listAll();
    }

    @GetMapping("findFlightById")
    public Mono<Flights> findFlightById(
            @RequestParam Long id
    ){
        return flightService.findById(id);
    }

    @GetMapping("/findFlightByCities")
    public Flux<Flights> findFlightByCities(
            @RequestParam String startCity,
            @RequestParam String endCity
    ) {
        return flightService.findByCities(startCity, endCity);
    }

    @GetMapping("/findFlightByDate")
    public Flux<Flights> findFlightByDate(
            @RequestParam Date date //Dragons be here: возможна несовместимость даты из свифта и Джавы
    ) {
        return flightService.findByDate(date);
    }

    @GetMapping("/findFlightByCountryRoute")
    public Flux<Flights> findFlightByCountryRoute(
            @RequestParam String startCountry,
            @RequestParam String endCountry
    ) {
        return flightService.findByCountries(startCountry, endCountry);
    }

    @DeleteMapping("/deleteFlightById")
    public Flux<Flights> deleteFlightById(@RequestParam Long id){
        return deleteFlightById(id);
    }

    @GetMapping("/listAllSeatsStatus")
    public Flux<Boolean> listAllSeatsStatus(@RequestParam Long flightId){
        return flightService.listAllSeats(flightId);
    }

    @PostMapping("/reserveSeatsBeforePayment")
    public Mono<Boolean> reserveSeatsBeforePayment(
            @RequestParam Long flightId,
            @RequestParam List<Integer> seats
    ){
        return flightService.initialTicketReservation(flightId, seats);
    }






//  Работа с сотрудниками

    @RequestMapping("/listAllEmployees")
    public Flux<Employees> listAllEmployees() {
        return employeeService.listAll();
    }

    @GetMapping("/findEmployeeById")
    public Mono<Employees> findEmployeeById(
            @RequestParam Long id
    ) {
        return employeeService.getById(id);
    }

    @GetMapping("/findEmployeeByRole")
    public Flux<Employees> findEmployeeByRole(
            @RequestParam String role
    ) {
        return employeeService.findByRole(role);
    }

    @GetMapping("/findEmployeeByLicense")
    public Flux<Employees> findEmployeeByLicense(
            @RequestParam String license
    ) {
        return employeeService.findByLicense(license);
    }

    @GetMapping("/findEmployeeByVisa")
    public Flux<Employees> findEmployeeByVisa(
            @RequestParam String visa
    ) {
        return employeeService.findByVisa(visa);
    }

    @GetMapping("/findEmployeeByCountryOfOrigin")
    public Flux<Employees> findEmployeeByCountryOfOrigin(
            @RequestParam String country
    ) {
        return employeeService.findByCountryOfOrigin(country);
    }

    @PostMapping("/addEmployee")
    public Mono<Employees> addEmployee(
            @RequestBody Employees newEmployee
    ){
            return employeeService.addNew(newEmployee);
    }

    @DeleteMapping("/deleteEmployeeById")
    public Flux<Employees> deleteEmployeeById(Long id){
        return employeeService.deleteEmployeeById(id);
    }






//    Новый подход к общению с базой минуя сервисный слой
//    Оформление багажа

/**    Если требуется изменить параметры багажа, то необходимо его пересоздать
        Наблюдал такой поиход в аэропротах.
 */

    @RequestMapping("/listAllBaggage")
    public Flux<Baggage> listAllBaggage(){
        return baggageRepo.findAll();
    }

    @GetMapping("/findBaggageByOwnerFullname")
    public Flux<Baggage> findBaggageByOwnerFullname(@RequestParam String ownerFullName){
        return baggageRepo.findBaggageByOwnerFullName(ownerFullName);
    }
    @GetMapping("/findBaggageByFlightId")
    public Flux<Baggage> findBaggageByFlightId(@RequestParam Long flightId){
        return baggageRepo.findBaggageByFlightId(flightId);
    }

    @GetMapping("/findBaggageByTargetFlightName")
    public Flux<Baggage> findBaggageByTargetFlightName(@RequestParam String targetFlightName){
        return baggageRepo.findBaggageByTargetFlightName(targetFlightName);
    }

    @GetMapping("/findBaggageByStartCountry")
    public Flux<Baggage> findBaggageByStartCountry(@RequestParam String startCountry){
        return baggageRepo.findBaggageByStartCountry(startCountry);
    }

    @GetMapping("/findBaggageByMiddleCountry")
    public Flux<Baggage> findBaggageByMiddleCountry(@RequestParam String middleCountry){
        return baggageRepo.findBaggageByMiddleCountry(middleCountry);
    }

    @GetMapping("/findBaggageByEndCountry")
    public Flux<Baggage> findBaggageByEndCountry(@RequestParam String endCountry){
        return baggageRepo.findBaggageByEndCountry(endCountry);
    }

    @PostMapping("/addBaggage")
    public Mono<Baggage> addBaggage(@RequestBody Baggage baggage){
        return baggageRepo.save(baggage);
    }

    @DeleteMapping("/deleteBaggageById")
    public Boolean deleteBaggageById(@RequestParam Long id){
        try{
            baggageRepo.deleteById(id).block();
            return true;
        } catch (Exception e){
            return false;
        }
    }





    //Управление самолетами
    @PostMapping("/addPlane")
    public Mono<Planes> addPlane(@RequestBody Planes plane){
        return planesRepo.save(plane);
    }

    @GetMapping("/listAllPlanes")
    public Flux<Planes> listAllPlanes(){
        return planesRepo.findAll();
    }

    @GetMapping("/findPlanesByInternationalNumber")
    public Mono<Planes> findPlanesByInternationalNumber(@RequestParam String number){
        return planesRepo.findPlanesByInternationalNumber(number);
    }

    @GetMapping("/findPlanesByRussianNumber")
    public Mono<Planes> findPlanesByRussianNumber(@RequestParam String russianNumber){
        return planesRepo.findPlanesByRussianNumber(russianNumber);
    }

    @GetMapping("/findPlanesByBoardName")
    public Mono<Planes> findPlanesByBoardName(@RequestParam String boardName){
        return planesRepo.findPlanesByBoardName(boardName);
    }

    @GetMapping("/findPlanesByModel")
    public Flux<Planes> findPlanesByModel(@RequestParam String model){
        return planesRepo.findPlanesByModel(model);
    }

    @GetMapping("/findPlanesByRepairHistory")
    public Flux<Planes> findPlanesByRepairHistory(@RequestParam String repairIncident){
        return planesRepo.findPlanesByRepairHistory(repairIncident);
    }

    @GetMapping("/findPlanesByOwnerCompany")
    public Flux<Planes> findPlanesByOwnerCompany(@RequestParam String company){
        return planesRepo.findPlanesByOwnerCompany(company);
    }

    @GetMapping("/findPlanesByHumanCapacity")
    public Flux<Planes> findPlanesByHumanCapacity(@RequestParam Integer humanCapacity){
        return planesRepo.findPlanesByHumanCapacity(humanCapacity);
    }

    @GetMapping("/findPlanesByPersonnelCapacity")
    public Flux<Planes> findPlanesByPersonnelCapacity(@RequestParam Integer personnelCapacity){
        return planesRepo.findPlanesByPersonnelCapacity(personnelCapacity);
    }

    @GetMapping("/findPlanesByBaggageCapacity")
    public Flux<Planes> findPlanesByBaggageCapacity(@RequestParam Integer baggageCapacity){
        return  planesRepo.findPlanesByBaggageCapacity(baggageCapacity);
    }

    @GetMapping("/findPlanesByFlightHistoryId")
    public Mono<Planes> findPlanesByFlightHistoryId(@RequestParam Long flightID){
        return planesRepo.findPlanesByFlightHistoryId(flightID);
    }

    @DeleteMapping("/deletePlaneById")
    public Flux<Planes> deletePlaneById(@RequestParam Long id){
        try {
            planesRepo.deleteById(id).block();
            return planesRepo.findAll();
        } catch (Exception e){
            return Flux.empty();
        }
    }


}