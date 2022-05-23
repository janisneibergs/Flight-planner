package io.codelex.flightplanner;


import io.codelex.flightplanner.airport.Airport;
import io.codelex.flightplanner.airport.AirportService;
import io.codelex.flightplanner.flight.Flights;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private FlightService flightService;
    private AirportService airportService;

    public CustomerController(FlightService flightService, AirportService airportService) {
        this.flightService = flightService;
        this.airportService = airportService;
    }

    @GetMapping("/{id}")
    public Flights findFlightById(@PathVariable Long id) {
        return flightService.findFlightById(id);
    }

    @GetMapping("/airports")
    public List<Airport> searchAirports(@PathParam("search") String search) {
        return airportService.searchAirports(search);
    }

}
