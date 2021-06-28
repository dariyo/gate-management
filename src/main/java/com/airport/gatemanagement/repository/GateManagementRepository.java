package com.airport.gatemanagement.repository;


import com.airport.gatemanagement.entities.GateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Optional;




@Repository
public interface GateManagementRepository extends JpaRepository<GateEntity, Integer>, GateManagementRepositoryCustom {

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    Optional<GateEntity> findByGateNumber(String gateNumber);

}
