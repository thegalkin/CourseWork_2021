package thegalkin.courseWork_v3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thegalkin.courseWork_v3.domain.Baggage;
import thegalkin.courseWork_v3.domain.Employees;
import thegalkin.courseWork_v3.domain.Flights;
import thegalkin.courseWork_v3.repo.BaggageRepo;
import thegalkin.courseWork_v3.service.EmployeeService;
import thegalkin.courseWork_v3.service.FlightService;

import java.util.Date;

@RestController
@RequestMapping("/")
public class MainController {
    private final FlightService flightService;
    private final EmployeeService employeeService;

    private final BaggageRepo baggageRepo;

    @Autowired
    public MainController(FlightService flightService, EmployeeService employeeService, BaggageRepo baggageRepo) {
        this.flightService = flightService;
        this.employeeService = employeeService;
        this.baggageRepo = baggageRepo;
    }

    @GetMapping("/findByCities")
    public Flux<Flights> findByCities(
            @RequestParam String startCity,
            @RequestParam String endCity
    ) {
        return flightService.findByCities(startCity, endCity);
    }

    @GetMapping("/findByDate")
    public Flux<Flights> findByDate(
            @RequestParam Date date //Dragons be here: возможна несовместимость даты из свифта и Джавы
    ) {
        return flightService.findByDate(date);
    }

    @GetMapping("/findByCountryRoute")
    public Flux<Flights> findByCountryRoute(
            @RequestParam String startCountry,
            @RequestParam String endCountry
    ) {
        return flightService.findByCountries(startCountry, endCountry);
    }

    @RequestMapping("/listAllFlights")
    public Flux<Flights> listAllFlights() {
        return flightService.listAll();
    }

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

    @GetMapping("findFlightById")
    public Mono<Flights> findFlightById(
            @RequestParam Long id
    ){
        return flightService.findById(id);
    }

    @GetMapping("/findEmployeeByRole")
    public Flux<Employees> findEmployeeByRole(
            @RequestParam String role
    ) {
        return employeeService.findByRole(role);
    }

    @GetMapping("/findByLicense")
    public Flux<Employees> findByLicense(
            @RequestParam String license
    ) {
        return employeeService.findByLicense(license);
    }

    @GetMapping("/findByVisa")
    public Flux<Employees> findByVisa(
            @RequestParam String visa
    ) {
        return employeeService.findByVisa(visa);
    }

    @GetMapping("/findByCountryOfOrigin")
    public Flux<Employees> findByCountryOfOrigin(
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

    @PostMapping("/addFlight")
    public Mono<Flights> addFlight(
            @RequestBody Flights flights
    ){
            return flightService.addNew(flights);
    }




//    Новый подход к общению с базой минуя сервисный слой
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



}