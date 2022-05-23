package io.codelex.flightplanner.airport;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AirportRepository {
    private final List<Airport> airportList = new ArrayList<>();

    public void addAirport(Airport airport) {
        if (!airportList.contains(airport)) {
            airportList.add(airport);
        }

    }


    public List<Airport> searchAirports(String search) {
        List<Airport> tempAirportList = new ArrayList<>();
        for (Airport airport : airportList) {
            if (airport.getCountry().toLowerCase().contains(search.toLowerCase().trim())
                    || airport.getCity().toLowerCase().contains(search.toLowerCase().trim())
                    || airport.getAirport().toLowerCase().contains(search.toLowerCase().trim())) {
                tempAirportList.add(airport);
            }
        }
        return null;

    }
}
