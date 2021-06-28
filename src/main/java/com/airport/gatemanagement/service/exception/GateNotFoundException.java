package com.airport.gatemanagement.service.exception;


public class GateNotFoundException extends GateServiceException {

    private final String gateNumber;

    public GateNotFoundException(final String gateNumber) {
        this.gateNumber = gateNumber;
    }


    public String getGateNumber() {
        return gateNumber;
    }
}
