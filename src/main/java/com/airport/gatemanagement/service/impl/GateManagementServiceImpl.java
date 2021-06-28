package com.airport.gatemanagement.service.impl;


import com.airport.gatemanagement.converter.GateConverter;
import com.airport.gatemanagement.dto.GateDto;
import com.airport.gatemanagement.dto.OccupyRequestDto;
import com.airport.gatemanagement.dto.UpdateWorkingTimeRequestDto;
import com.airport.gatemanagement.entities.GateEntity;
import com.airport.gatemanagement.repository.GateManagementRepository;
import com.airport.gatemanagement.service.GateManagementService;
import com.airport.gatemanagement.service.exception.GateNotFoundException;
import com.airport.gatemanagement.service.exception.NoAvailableGateException;
import com.airport.gatemanagement.util.TimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;




@Service
@Transactional
public class GateManagementServiceImpl implements GateManagementService {

    private final GateManagementRepository repository;


    public GateManagementServiceImpl(final GateManagementRepository repository) {
        this.repository = repository;
    }


    @Override
    public GateDto occupyGate(final OccupyRequestDto occupyRequestDto) {
        Assert.notNull(occupyRequestDto.getFlightNumber(), "flightNumber must not be null");

        final int passedTimeMinutes = TimeUtil.calculatePassedTimeInMinutes();
        final GateEntity gateDb = repository.findAvailableGate(passedTimeMinutes)
                                            .orElseThrow(NoAvailableGateException::new);

        gateDb.setOccupiedBy(occupyRequestDto.getFlightNumber());

        return GateConverter.toDto(repository.saveAndFlush(gateDb));
    }


    public GateDto freeGate(final String gateNumber) {
        Assert.notNull(gateNumber, "gateNumber must not be null");

        final GateEntity gateDB = repository.findByGateNumber(gateNumber)
                                            .orElseThrow(() -> new GateNotFoundException(gateNumber));

        gateDB.setOccupiedBy(null);

        return GateConverter.toDto(repository.saveAndFlush(gateDB));
    }


    @Override
    public GateDto updateWorkingTime(final String gateNumber, final UpdateWorkingTimeRequestDto request) {
        Assert.notNull(gateNumber, "gateNumber must not be null");

        final GateEntity gateDb = repository.findByGateNumber(gateNumber)
                                            .orElseThrow(() -> new GateNotFoundException(gateNumber));

        gateDb.setOpeningTime(request.getOpeningTime());
        gateDb.setClosingTime(request.getClosingTime());

        return GateConverter.toDto(repository.saveAndFlush(gateDb));
    }


    @Override
    public GateDto removeWorkingTime(final String gateNumber) {
        Assert.notNull(gateNumber, "gateNumber must not be null");

        final GateEntity gateDb = repository.findByGateNumber(gateNumber)
                                            .orElseThrow(() -> new GateNotFoundException(gateNumber));

        gateDb.setOpeningTime(null);
        gateDb.setClosingTime(null);

        return GateConverter.toDto(repository.saveAndFlush(gateDb));
    }
}
