package com.airport.gatemanagement.repository.impl;


import com.airport.gatemanagement.entities.GateEntity;
import com.airport.gatemanagement.repository.GateManagementRepositoryCustom;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;




@Repository
public class GateManagementRepositoryImpl implements GateManagementRepositoryCustom {

    @PersistenceContext
    private final EntityManager em;


    public GateManagementRepositoryImpl(final EntityManager em) {
        this.em = em;
    }


    @Override
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    public Optional<GateEntity> findAvailableGate(final int passedTimeMinutes) {
        final TypedQuery<GateEntity> query = em.createQuery(
            "SELECT g FROM GateEntity g WHERE g.occupiedBy IS null AND (g.closingTime IS null OR g.closingTime < :passedTime) AND (g.openingTime IS null OR g.openingTime > :passedTime)",
            GateEntity.class
        );
        query.setParameter("passedTime", passedTimeMinutes);
        query.setMaxResults(1);

        return query.getResultList().stream().findFirst();
    }

}
