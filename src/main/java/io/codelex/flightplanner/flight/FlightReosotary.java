package io.codelex.flightplanner.flight;

import io.codelex.flightplanner.airport.AirportRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Repository
public class FlightReosotary {
    private final AirportRepository airportRepository;
    private final List<Flights> flightList = new ArrayList<>();
    private Long id = 0L;


    public FlightReosotary(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public void clearFlights() {
        flightList.clear();
    }

    public synchronized Flights addFlights(AddFlightRequest addFlightRequest) {
        for (Flights flights : flightList) {
            if (addFlightRequest.getFrom().equals(flights.getFrom())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT);
            }
        }

        if (addFlightRequest.sameAirport()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        if (!addFlightRequest.checkDates()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        airportRepository.addAirport(addFlightRequest.getFrom());
        airportRepository.addAirport(addFlightRequest.getTo());
        id++;
        Flights addFly = new Flights(id, addFlightRequest);
        flightList.add(addFly);
        return addFly;
    }


    public synchronized Flights findFlightById(Long id) {
        for (Flights flights : flightList) {
            if (flights.getId().equals(id)) {
                return flights;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void deleteFlight(Long id) {
        flightList.removeIf(flights -> flights.getId().equals(id));


    }


}
