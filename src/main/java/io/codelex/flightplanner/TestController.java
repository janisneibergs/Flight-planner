package io.codelex.flightplanner;


import io.codelex.flightplanner.flight.Flights;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/testing-api/")
public class TestController {
    private FlightService flightService;


    public TestController(FlightService flightService) {
        this.flightService = flightService;

    }

    @PostMapping("/clear")
    public void clearFlights() {
        flightService.clearFlights();
    }

    @GetMapping("/{id}")
    public Flights findFlightById(@PathVariable Long id) {
        return flightService.findFlightById(id);
    }

}
