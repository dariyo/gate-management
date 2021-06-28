package com.airport.gatemanagement.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;




@Entity
@Table(name = "gates", uniqueConstraints = @UniqueConstraint(columnNames={"gateNumber"}))
public class GateEntity {
    private long id;
    private String gateNumber;
    private String occupiedBy; // flight number
    private Integer openingTime; // time in minutes passed by start of the day
    private Integer closingTime; // time in minutes passed by start of the day


    public GateEntity() {
    }


    public GateEntity(final Integer id, final String gateNumber, final String occupiedBy) {
        this.id = id;
        this.gateNumber = gateNumber;
        this.occupiedBy = occupiedBy;
    }


    public void setId(final long id) {
        this.id = id;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }


    public String getGateNumber() {
        return gateNumber;
    }


    public void setGateNumber(final String gate_number) {
        this.gateNumber = gate_number;
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
