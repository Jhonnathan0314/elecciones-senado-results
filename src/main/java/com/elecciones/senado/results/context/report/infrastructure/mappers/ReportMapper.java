package com.elecciones.senado.results.context.report.infrastructure.mappers;

import com.elecciones.senado.results.context.candidate.infrastructure.mappers.CandidateMapper;
import com.elecciones.senado.results.context.election_table.infrastructure.mappers.ElectionTableMapper;
import com.elecciones.senado.results.context.report.application.dto.ReportDTO;
import com.elecciones.senado.results.context.report.domain.model.Report;
import com.elecciones.senado.results.context.report.infrastructure.persistence.ReportEntity;
import com.elecciones.senado.results.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class ReportMapper implements Mapper<ReportEntity, Report, ReportDTO> {

    private final CandidateMapper candidateMapper = new CandidateMapper();
    private final ElectionTableMapper electionTableMapper = new ElectionTableMapper();

    @Override
    public Report entityToModel(ReportEntity entity) {
        return Report.builder()
                .candidate(candidateMapper.entityToModel(entity.getCandidate()))
                .electionTable(electionTableMapper.entityToModel(entity.getElectionTable()))
                .votePercentage(entity.getVotePercentage())
                .build();
    }

    @Override
    public ReportEntity modelToEntity(Report model) {
        return ReportEntity.builder()
                .candidate(candidateMapper.modelToEntity(model.getCandidate()))
                .electionTable(electionTableMapper.modelToEntity(model.getElectionTable()))
                .votePercentage(model.getVotePercentage())
                .build();
    }

    @Override
    public ReportDTO modelToDto(Report model) {
        return ReportDTO.builder()
                .candidate(candidateMapper.modelToDto(model.getCandidate()))
                .electionTable(electionTableMapper.modelToDto(model.getElectionTable()))
                .votePercentage(model.getVotePercentage())
                .build();
    }

    @Override
    public Report dtoToModel(ReportDTO dto) {
        return Report.builder()
                .candidate(candidateMapper.dtoToModel(dto.getCandidate()))
                .electionTable(electionTableMapper.dtoToModel(dto.getElectionTable()))
                .votePercentage(dto.getVotePercentage())
                .build();
    }

    @Override
    public List<Report> entitiesToModels(List<ReportEntity> entities) {
        return entities.stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportEntity> modelsToEntities(List<Report> models) {
        return models.stream()
                .map(this::modelToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportDTO> modelsToDtos(List<Report> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Report> dtosToModels(List<ReportDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }
}
