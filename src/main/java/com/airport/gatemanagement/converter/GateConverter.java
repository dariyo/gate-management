package com.airport.gatemanagement.converter;


import com.airport.gatemanagement.dto.GateDto;
import com.airport.gatemanagement.entities.GateEntity;




public class GateConverter {

    public static GateEntity toEntity(final GateDto source) {
        if(source == null) {
            return null;
        }

        final GateEntity target = new GateEntity();
        target.setGateNumber(source.getGateNumber());
        target.setOccupiedBy(source.getOccupiedBy());
        target.setOpeningTime(source.getOpeningTime());
        target.setClosingTime(source.getClosingTime());
        return target;
    }

    public static GateDto toDto(final GateEntity source) {
        if(source == null) {
            return null;
        }

        final GateDto target = new GateDto();
        target.setGateNumber(source.getGateNumber());
        target.setOccupiedBy(source.getOccupiedBy());
        target.setOpeningTime(source.getOpeningTime());
        target.setClosingTime(source.getClosingTime());
        return target;
    }

}
