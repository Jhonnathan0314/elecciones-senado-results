package com.elecciones.senado.results.context.report.infrastructure.mappers;

import com.elecciones.senado.results.context.report.application.dto.ReportCandidateDTO;
import com.elecciones.senado.results.context.report.domain.model.ReportCandidate;
import com.elecciones.senado.results.context.report.infrastructure.persistence.ReportCandidateEntity;
import com.elecciones.senado.results.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class ReportCandidateMapper implements Mapper<ReportCandidateEntity, ReportCandidate, ReportCandidateDTO> {

    @Override
    public ReportCandidate entityToModel(ReportCandidateEntity entity) {
        return ReportCandidate.builder()
                .candidateName(entity.getCandidateName())
                .partyName(entity.getPartyName())
                .reportedTables(entity.getReportedTables())
                .totalVotes(entity.getTotalVotes())
                .percentage(entity.getPercentage())
                .build();
    }

    @Override
    public ReportCandidateEntity modelToEntity(ReportCandidate model) {
        return ReportCandidateEntity.builder()
                .candidateName(model.getCandidateName())
                .partyName(model.getPartyName())
                .reportedTables(model.getReportedTables())
                .totalVotes(model.getTotalVotes())
                .percentage(model.getPercentage())
                .build();
    }

    @Override
    public ReportCandidateDTO modelToDto(ReportCandidate model) {
        return ReportCandidateDTO.builder()
                .candidateName(model.getCandidateName())
                .partyName(model.getPartyName())
                .reportedTables(model.getReportedTables())
                .totalVotes(model.getTotalVotes())
                .percentage(model.getPercentage())
                .build();
    }

    @Override
    public ReportCandidate dtoToModel(ReportCandidateDTO dto) {
        return ReportCandidate.builder()
                .candidateName(dto.getCandidateName())
                .partyName(dto.getPartyName())
                .reportedTables(dto.getReportedTables())
                .totalVotes(dto.getTotalVotes())
                .percentage(dto.getPercentage())
                .build();
    }

    @Override
    public List<ReportCandidate> entitiesToModels(List<ReportCandidateEntity> entities) {
        return entities.stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportCandidateEntity> modelsToEntities(List<ReportCandidate> models) {
        return models.stream()
                .map(this::modelToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportCandidateDTO> modelsToDtos(List<ReportCandidate> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportCandidate> dtosToModels(List<ReportCandidateDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }
}
