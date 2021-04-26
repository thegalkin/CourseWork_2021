package thegalkin.courseWork_v3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import thegalkin.courseWork_v3.domain.Employee;
import thegalkin.courseWork_v3.domain.Flight;
import thegalkin.courseWork_v3.service.EmployeeService;
import thegalkin.courseWork_v3.service.FlightService;

import java.util.Date;

@RestController
@RequestMapping("/controller")
public class MainController {
    private final FlightService flightService;
    private final EmployeeService employeeService;

    @Autowired
    public MainController(FlightService flightService) {
        this.flightService = flightService;
    }

    public Flux<Flight> findByCities(
            @RequestParam() String startCity,
            @RequestParam() String endCity
    ){
        return flightService.findByCities(startCity, endCity);
    }

    public Flux<Flight> findByDate(
            @RequestParam() Date date //Dragons be here: возможна несовместимость даты из свифта и Джавы
    ){
        return flightService.findByDate(date);
    }

    public Flux<Flight> findByCountryRoute(
            @RequestParam String startCountry,
            @RequestParam String endCountry
    ){
        return flightService.findByCountries(startCountry, endCountry);
    }

    public Flux<Flight> listAllFlights(){
        return flightService.listAll();
    }


    public Flux<Employee> listAllEmployees(){
        return employeeService.listAll();
    }

    public Flux<Employee> findEmployeeById(
            @RequestParam 
    )
}
