package com.elecciones.senado.results.context.report.infrastructure.mappers;

import com.elecciones.senado.results.context.report.application.dto.ReportElectionTableDTO;
import com.elecciones.senado.results.context.report.domain.model.ReportElectionTable;
import com.elecciones.senado.results.context.report.infrastructure.persistence.ReportElectionTableEntity;
import com.elecciones.senado.results.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class ReportElectionTableMapper implements Mapper<ReportElectionTableEntity, ReportElectionTable, ReportElectionTableDTO> {

    @Override
    public ReportElectionTable entityToModel(ReportElectionTableEntity entity) {
        return ReportElectionTable.builder()
                .cityId(entity.getCityId())
                .reportedTables(entity.getReportedTables())
                .totalVotes(entity.getTotalVotes())
                .percentage(entity.getPercentage())
                .build();
    }

    @Override
    public ReportElectionTableEntity modelToEntity(ReportElectionTable model) {
        return ReportElectionTableEntity.builder()
                .cityId(model.getCityId())
                .reportedTables(model.getReportedTables())
                .totalVotes(model.getTotalVotes())
                .percentage(model.getPercentage())
                .build();
    }

    @Override
    public ReportElectionTableDTO modelToDto(ReportElectionTable model) {
        return ReportElectionTableDTO.builder()
                .cityId(model.getCityId())
                .reportedTables(model.getReportedTables())
                .totalVotes(model.getTotalVotes())
                .percentage(model.getPercentage())
                .build();
    }

    @Override
    public ReportElectionTable dtoToModel(ReportElectionTableDTO dto) {
        return ReportElectionTable.builder()
                .cityId(dto.getCityId())
                .reportedTables(dto.getReportedTables())
                .totalVotes(dto.getTotalVotes())
                .percentage(dto.getPercentage())
                .build();
    }

    @Override
    public List<ReportElectionTable> entitiesToModels(List<ReportElectionTableEntity> entities) {
        return entities.stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportElectionTableEntity> modelsToEntities(List<ReportElectionTable> models) {
        return models.stream()
                .map(this::modelToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportElectionTableDTO> modelsToDtos(List<ReportElectionTable> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportElectionTable> dtosToModels(List<ReportElectionTableDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }
}
