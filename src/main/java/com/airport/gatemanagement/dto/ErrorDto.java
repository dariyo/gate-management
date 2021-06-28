package com.airport.gatemanagement.dto;


public class ErrorDto {

    public ErrorDto() {
    }


    public ErrorDto(final String message) {
        this.message = message;
    }


    private String message;


    public String getMessage() {
        return message;
    }


    public void setMessage(final String message) {
        this.message = message;
    }
}
