package com.airport.gatemanagement.service.exception;


public class NoAvailableGateException extends GateServiceException {

    public NoAvailableGateException() {
        super("Currently there is no available gate. Try again later.");
    }
}
