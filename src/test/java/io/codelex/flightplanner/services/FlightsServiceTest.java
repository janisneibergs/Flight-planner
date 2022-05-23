package io.codelex.flightplanner.services;


import io.codelex.flightplanner.airport.Airport;
import io.codelex.flightplanner.flight.AddFlightRequest;
import io.codelex.flightplanner.flight.FlightReosotary;
import io.codelex.flightplanner.flight.Flights;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ExtendWith(MockitoExtension.class)
public class FlightsServiceTest {

    @Mock
    FlightReosotary flightsRepository;

    @InjectMocks
    FlightReosotary flightsService;

    @Test
    public void testAddFlight() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Airport from = new Airport("Latvia", "Riga", "RIX");
        Airport to = new Airport("Estonia", "Tallin", "EST");
        String carrier = "airBaltic";
        String departureTime = "2022-05-02 08:30";
        String arrivalTime = "2022-05-03 10:30";

        AddFlightRequest addFlightRequest = new AddFlightRequest(from, to, carrier, departureTime, arrivalTime);

        Mockito.doAnswer(invocation -> {
            AddFlightRequest request = invocation.getArgument(0);
            Assertions.assertEquals(addFlightRequest, request);
            return new Flights(67L, request);
        }).when(flightsRepository).addFlights(addFlightRequest);

        Flights flight = flightsService.addFlights(addFlightRequest);

        Mockito.verify(flightsRepository).addFlights(addFlightRequest);
    }
}
