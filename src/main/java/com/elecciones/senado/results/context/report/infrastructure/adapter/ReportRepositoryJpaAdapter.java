package com.elecciones.senado.results.context.report.infrastructure.adapter;

import com.elecciones.senado.results.context.report.domain.model.Report;
import com.elecciones.senado.results.context.report.domain.port.ReportRepository;
import com.elecciones.senado.results.context.report.infrastructure.mappers.ReportMapper;
import com.elecciones.senado.results.context.report.infrastructure.persistence.ReportEntity;
import com.elecciones.senado.results.context.report.infrastructure.persistence.ReportJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReportRepositoryJpaAdapter implements ReportRepository {

    private final ReportJpaRepository reportJpaRepository;
    private final ReportMapper reportMapper = new ReportMapper();

    @Override
    public List<Report> findReport() {
        List<ReportEntity> entities = reportJpaRepository.findAll();
        return reportMapper.entitiesToModels(entities);
    }

}
