package com.airport.gatemanagement.dto;


public class OccupyRequestDto {
    private String flightNumber;


    public OccupyRequestDto() {
    }


    public OccupyRequestDto(final String flightNumber) {
        this.flightNumber = flightNumber;
    }


    public String getFlightNumber() {
        return flightNumber;
    }


    public void setFlightNumber(final String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
