package thegalkin.courseWork_v3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import thegalkin.courseWork_v3.domain.Employees;
import thegalkin.courseWork_v3.domain.Flights;
import thegalkin.courseWork_v3.service.EmployeeService;
import thegalkin.courseWork_v3.service.FlightService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {
    private final FlightService flightService;
    private final EmployeeService employeeService;

    @Autowired
    public MainController(FlightService flightService, EmployeeService employeeService) {
        this.flightService = flightService;
        this.employeeService = employeeService;
    }

    @PostMapping("/findByCities")
    public Flux<Flights> findByCities(
            @RequestParam String startCity,
            @RequestParam String endCity
    ) {
        return flightService.findByCities(startCity, endCity);
    }

    @PostMapping("/findByDate")
    public Flux<Flights> findByDate(
            @RequestParam Date date //Dragons be here: возможна несовместимость даты из свифта и Джавы
    ) {
        return flightService.findByDate(date);
    }

    @PostMapping("/findByCountryRoute")
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

    @PostMapping("/findEmployeeById")
    public Mono<Employees> findEmployeeById(
            @RequestParam Long id
    ) {
        return employeeService.getById(id);
    }

    @PostMapping("findFlightById")
    public Mono<Flights> findFlightById(
            @RequestParam Long id
    ){
        return flightService.findById(id);
    }

    @PostMapping("/findEmployeeByRole")
    public Flux<Employees> findEmployeeByRole(
            @RequestParam String role
    ) {
        return employeeService.findByRole(role);
    }

    @PostMapping("/findByLicense")
    public Flux<Employees> findByLicense(
            @RequestParam String license
    ) {
        return employeeService.findByLicense(license);
    }

    @PostMapping("/findByVisa")
    public Flux<Employees> findByVisa(
            @RequestParam String visa
    ) {
        return employeeService.findByVisa(visa);
    }

    @PostMapping("/findByCountryOfOrigin")
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

    @RequestMapping("/listAll")
    public Flux<Employees> listAll(){
        return employeeService.listAll();
    }
}