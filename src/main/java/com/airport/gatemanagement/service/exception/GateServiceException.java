package com.airport.gatemanagement.service.exception;


public class GateServiceException extends RuntimeException {

    public GateServiceException() {
    }


    public GateServiceException(final String message) {
        super(message);
    }


    public GateServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }


    public GateServiceException(final Throwable cause) {
        super(cause);
    }


    public GateServiceException(
        final String message,
        final Throwable cause,
        final boolean enableSuppression,
        final boolean writableStackTrace
    ) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
