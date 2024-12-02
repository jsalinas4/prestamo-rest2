package com.TechConnecGrupo3.TechConnecapi.repository;

import com.TechConnecGrupo3.TechConnecapi.model.entity.PaymentSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentScheduleRepository extends JpaRepository<PaymentSchedule, Long> {
}
