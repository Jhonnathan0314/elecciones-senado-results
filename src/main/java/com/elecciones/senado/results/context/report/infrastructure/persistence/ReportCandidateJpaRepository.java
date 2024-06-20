package com.elecciones.senado.results.context.report.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ReportCandidateJpaRepository extends JpaRepository<ReportCandidateEntity, BigDecimal> {
}
