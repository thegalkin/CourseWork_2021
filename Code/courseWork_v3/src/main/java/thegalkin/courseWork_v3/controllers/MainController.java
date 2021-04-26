package thegalkin.courseWork_v3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import thegalkin.courseWork_v3.domain.Flight;
import thegalkin.courseWork_v3.service.FlightService;

@RestController
@RequestMapping("/controller")
public class MainController {
    private final FlightService flightService;

    @Autowired
    public MainController(FlightService flightService) {
        this.flightService = flightService;
    }

    public Flux<Flight> listByCityOfArrival(
            @RequestParam() String startCity,
            @RequestParam() String endCity
    ){
        return flightService.listAll();
    }



}
