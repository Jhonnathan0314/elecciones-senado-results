package com.elecciones.senado.results.context.report.infrastructure.adapter;

import com.elecciones.senado.results.context.report.domain.model.ReportCandidate;
import com.elecciones.senado.results.context.report.domain.model.ReportElectionTable;
import com.elecciones.senado.results.context.report.domain.port.ReportRepository;
import com.elecciones.senado.results.context.report.infrastructure.mappers.ReportCandidateMapper;
import com.elecciones.senado.results.context.report.infrastructure.mappers.ReportElectionTableMapper;
import com.elecciones.senado.results.context.report.infrastructure.persistence.ReportCandidateEntity;
import com.elecciones.senado.results.context.report.infrastructure.persistence.ReportCandidateJpaRepository;
import com.elecciones.senado.results.context.report.infrastructure.persistence.ReportElectionTableEntity;
import com.elecciones.senado.results.context.report.infrastructure.persistence.ReportElectionTableJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReportRepositoryJpaAdapter implements ReportRepository {

    private final ReportCandidateJpaRepository reportCandidateJpaRepository;
    private final ReportElectionTableJpaRepository reportElectionTableJpaRepository;
    private final ReportCandidateMapper reportCandidateMapper = new ReportCandidateMapper();
    private final ReportElectionTableMapper reportElectionTableMapper = new ReportElectionTableMapper();

    @Override
    public List<ReportCandidate> findCandidateReport() {
        List<ReportCandidateEntity> entities = reportCandidateJpaRepository.findAll();
        return reportCandidateMapper.entitiesToModels(entities);
    }

    @Override
    public List<ReportElectionTable> findElectionTableReport() {
        List<ReportElectionTableEntity> entities = reportElectionTableJpaRepository.findAll();
        return reportElectionTableMapper.entitiesToModels(entities);
    }

}
