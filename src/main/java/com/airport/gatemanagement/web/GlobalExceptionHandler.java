package com.airport.gatemanagement.web;


import com.airport.gatemanagement.dto.ErrorDto;
import com.airport.gatemanagement.service.exception.GateNotFoundException;
import com.airport.gatemanagement.service.exception.NoAvailableGateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;




@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = NoAvailableGateException.class)
    public ResponseEntity<ErrorDto> handleException(final NoAvailableGateException e) {
        return new ResponseEntity<>(new ErrorDto("Currently there is no available gate. Try again later."), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = GateNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(final GateNotFoundException e) {
        return new ResponseEntity<>(new ErrorDto("Could not find gate with number " + e.getGateNumber() + "."), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ErrorDto> handleException(final IllegalArgumentException e) {
        return new ResponseEntity<>(new ErrorDto(e.getMessage()), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorDto> handleException(final Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorDto("Server encountered error."), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
