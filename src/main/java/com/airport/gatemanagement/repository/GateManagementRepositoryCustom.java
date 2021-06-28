package com.airport.gatemanagement.repository;


import com.airport.gatemanagement.entities.GateEntity;

import java.util.Optional;




public interface GateManagementRepositoryCustom {

    Optional<GateEntity> findAvailableGate(final int passedTimeMinutes);

}
