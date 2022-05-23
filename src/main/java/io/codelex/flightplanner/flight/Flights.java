package io.codelex.flightplanner.flight;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.codelex.flightplanner.airport.Airport;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flights {
    private final Long id;
    private final Airport from;
    private final Airport to;
    private final String carrier;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private final LocalDateTime departureTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private final LocalDateTime arrivalTime;

    public Flights(Long id, AddFlightRequest addFlightRequest) {
        this.id = id;
        this.from = addFlightRequest.getFrom();
        this.to = addFlightRequest.getTo();
        this.carrier = addFlightRequest.getCarrier();
        this.departureTime = addFlightRequest.getDepartureTime();
        this.arrivalTime = addFlightRequest.getArrivalTime();
    }


    public Long getId() {
        return id;
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }

    public String getCarrier() {
        return carrier;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flights)) return false;
        Flights flights = (Flights) o;
        return Objects.equals(id, flights.id) && getFrom().equals(flights.getFrom()) && getTo().equals(flights.getTo()) && getCarrier().equals(flights.getCarrier()) && getDepartureTime().equals(flights.getDepartureTime()) && getArrivalTime().equals(flights.getArrivalTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFrom(), getTo(), getCarrier(), getDepartureTime(), getArrivalTime());
    }

    @Override
    public String toString() {
        return "Flights{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                ", carrier='" + carrier + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
