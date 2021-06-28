package com.airport.gatemanagement.dto;


public class UpdateWorkingTimeRequestDto {

    private int openingTime;
    private int closingTime;


    public UpdateWorkingTimeRequestDto() {
    }


    public UpdateWorkingTimeRequestDto(final int openingTime, final int closingTime) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }


    public int getOpeningTime() {
        return openingTime;
    }


    public void setOpeningTime(final int openingTime) {
        this.openingTime = openingTime;
    }


    public int getClosingTime() {
        return closingTime;
    }


    public void setClosingTime(final int closingTime) {
        this.closingTime = closingTime;
    }
}
