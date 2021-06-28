package com.airport.gatemanagement.dto;


public class GateDto {

    private String gateNumber;
    private String occupiedBy;
    private Integer openingTime;
    private Integer closingTime;



    public String getGateNumber() {
        return gateNumber;
    }


    public void setGateNumber(final String gateNumber) {
        this.gateNumber = gateNumber;
    }


    public String getOccupiedBy() {
        return occupiedBy;
    }


    public void setOccupiedBy(final String occupiedBy) {
        this.occupiedBy = occupiedBy;
    }


    public Integer getOpeningTime() {
        return openingTime;
    }


    public void setOpeningTime(final Integer openingTime) {
        this.openingTime = openingTime;
    }


    public Integer getClosingTime() {
        return closingTime;
    }


    public void setClosingTime(final Integer closingTime) {
        this.closingTime = closingTime;
    }
}
