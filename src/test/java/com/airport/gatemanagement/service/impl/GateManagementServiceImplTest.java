package com.airport.gatemanagement.service.impl;


import com.airport.gatemanagement.dto.OccupyRequestDto;
import com.airport.gatemanagement.dto.UpdateWorkingTimeRequestDto;
import com.airport.gatemanagement.entities.GateEntity;
import com.airport.gatemanagement.repository.GateManagementRepository;
import com.airport.gatemanagement.service.GateManagementService;
import com.airport.gatemanagement.service.exception.GateNotFoundException;
import com.airport.gatemanagement.service.exception.NoAvailableGateException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;




class GateManagementServiceImplTest {

    private final GateManagementRepository gateManagementRepository = Mockito.mock(GateManagementRepository.class);

    private final GateManagementService gateManagementService = new GateManagementServiceImpl(gateManagementRepository);


    @Test
    public void occupy_success() {
        Mockito.when(gateManagementRepository.findAvailableGate(Mockito.anyInt())).thenReturn(createAvailableGateEntity());

        gateManagementService.occupyGate(new OccupyRequestDto("flightNumber1"));

        Mockito.verify(gateManagementRepository, Mockito.times(1)).saveAndFlush(
            Mockito.argThat(argument ->
                                argument.getGateNumber().equals("gateNumber1")
                                    && argument.getOccupiedBy().equals("flightNumber1")
            )
        );
    }


    @Test()
    public void occupy_throwNoAvailableGate() {
        Mockito.when(gateManagementRepository.findAvailableGate(Mockito.anyInt())).thenReturn(Optional.empty());

        assertThrows(NoAvailableGateException.class, () -> {
            gateManagementService.occupyGate(new OccupyRequestDto("flightNumber1"));
        });
    }


    @Test
    public void freeGate_success() {
        Mockito.when(gateManagementRepository.findByGateNumber(Mockito.anyString())).thenReturn(createAvailableGateEntity());

        gateManagementService.freeGate("gateNumber1");

        Mockito.verify(gateManagementRepository, Mockito.times(1)).saveAndFlush(
            Mockito.argThat(argument ->
                                argument.getGateNumber().equals("gateNumber1")
                                    && argument.getOccupiedBy() == null
            )
        );
    }


    @Test()
    public void freeGate_throwGateNotFound() {
        Mockito.when(gateManagementRepository.findByGateNumber(Mockito.anyString())).thenReturn(Optional.empty());

        assertThrows(GateNotFoundException.class, () -> {
            gateManagementService.freeGate("gateNumber1");
        });
    }


    @Test
    public void updateWorkingTime_success() {
        Mockito.when(gateManagementRepository.findByGateNumber(Mockito.anyString())).thenReturn(createAvailableGateEntity());

        gateManagementService.updateWorkingTime("gateNumber1", new UpdateWorkingTimeRequestDto(240, 480));

        Mockito.verify(gateManagementRepository, Mockito.times(1)).saveAndFlush(
            Mockito.argThat(argument ->
                                argument.getGateNumber().equals("gateNumber1")
                                    && argument.getOccupiedBy() == null
                                    && argument.getOpeningTime() == 240
                                    && argument.getClosingTime() == 480
            )
        );
    }

    @Test
    public void updateWorkingTime_throwGateNotFound() {
        Mockito.when(gateManagementRepository.findByGateNumber(Mockito.anyString())).thenReturn(Optional.empty());

        assertThrows(GateNotFoundException.class, () -> {
            gateManagementService.updateWorkingTime("gateNumber1", new UpdateWorkingTimeRequestDto(240, 480));
        });
    }

    @Test
    public void removeWorkingTime_success() {
        Mockito.when(gateManagementRepository.findByGateNumber(Mockito.anyString())).thenReturn(createAvailableGateEntity());

        gateManagementService.removeWorkingTime("gateNumber1");

        Mockito.verify(gateManagementRepository, Mockito.times(1)).saveAndFlush(
            Mockito.argThat(argument ->
                                argument.getGateNumber().equals("gateNumber1")
                                    && argument.getOccupiedBy() == null
                                    && argument.getOpeningTime() == null
                                    && argument.getClosingTime() == null
            )
        );
    }

    @Test
    public void removeWorkingTime_throwGateNotFound() {
        Mockito.when(gateManagementRepository.findByGateNumber(Mockito.anyString())).thenReturn(Optional.empty());

        assertThrows(GateNotFoundException.class, () -> {
            gateManagementService.removeWorkingTime("gateNumber1");
        });
    }


    private Optional<GateEntity> createAvailableGateEntity() {
        final GateEntity entity = new GateEntity();
        entity.setGateNumber("gateNumber1");
        entity.setOccupiedBy(null);
        entity.setOpeningTime(null);
        entity.setClosingTime(null);
        return Optional.of(entity);
    }

}