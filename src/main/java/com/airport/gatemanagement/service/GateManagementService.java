package com.airport.gatemanagement.service;



import com.airport.gatemanagement.dto.GateDto;
import com.airport.gatemanagement.dto.OccupyRequestDto;
import com.airport.gatemanagement.dto.UpdateWorkingTimeRequestDto;




public interface GateManagementService {

    GateDto occupyGate(OccupyRequestDto flightNumber);

    GateDto freeGate(String gateNumber);

    GateDto updateWorkingTime(String gateNumber, UpdateWorkingTimeRequestDto request);

    GateDto removeWorkingTime(String gateNumber);

}
