package io.codelex.flightplanner;

import io.codelex.flightplanner.flight.*;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class FlightService {
    private final FlightReosotary flightReosotary;

    public FlightService(FlightReosotary flightReosotary) {
        this.flightReosotary = flightReosotary;
    }

    public void clearFlights() {
        flightReosotary.clearFlights();
    }

    public Flights addFlights(@Valid AddFlightRequest addFlightRequest) {

        return flightReosotary.addFlights(addFlightRequest);

    }

    public void deleteFlight(Long id) {
        flightReosotary.deleteFlight(id);
    }


    public Flights findFlightById(Long id) {
        return flightReosotary.findFlightById(id);
    }
}
