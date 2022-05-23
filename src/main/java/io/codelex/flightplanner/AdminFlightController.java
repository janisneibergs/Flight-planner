package io.codelex.flightplanner;

import io.codelex.flightplanner.flight.AddFlightRequest;
import io.codelex.flightplanner.flight.Flights;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin-api/flights")
public class AdminFlightController {
    private final FlightService flightService;

    public AdminFlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Flights addFlight(@Valid @RequestBody AddFlightRequest addFlightRequest) {
        return flightService.addFlights(addFlightRequest);
    }

    @GetMapping("/{id}")
    public Flights findFlightById(@PathVariable Long id) {
        return flightService.findFlightById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }
}