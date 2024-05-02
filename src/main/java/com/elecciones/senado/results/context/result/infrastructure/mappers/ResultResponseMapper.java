package com.elecciones.senado.results.context.result.infrastructure.mappers;

import com.elecciones.senado.results.context.candidate.infrastructure.mappers.CandidateResponseMapper;
import com.elecciones.senado.results.context.election_table.infrastructure.mappers.ElectionTableResponseMapper;
import com.elecciones.senado.results.context.result.application.dto.ResultResponseDTO;
import com.elecciones.senado.results.context.result.domain.model.Result;
import com.elecciones.senado.results.context.result.infrastructure.persistence.ResultEntity;
import com.elecciones.senado.results.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class ResultResponseMapper implements Mapper<ResultEntity, Result, ResultResponseDTO> {

    private final ElectionTableResponseMapper electionTableMapper = new ElectionTableResponseMapper();
    private final CandidateResponseMapper candidateMapper = new CandidateResponseMapper();
    
    @Override
    public Result entityToModel(ResultEntity entity) {
        return Result.builder()
                .id(entity.getId())
                .votes(entity.getVotes())
                .electionTable(electionTableMapper.entityToModel(entity.getElectionTable()))
                .candidate(candidateMapper.entityToModel(entity.getCandidate()))
                .build();
    }

    @Override
    public ResultEntity modelToEntity(Result model) {
        return ResultEntity.builder()
                .id(model.getId())
                .votes(model.getVotes())
                .electionTable(electionTableMapper.modelToEntity(model.getElectionTable()))
                .candidate(candidateMapper.modelToEntity(model.getCandidate()))
                .build();
    }

    @Override
    public ResultResponseDTO modelToDto(Result model) {
        return ResultResponseDTO.builder()
                .id(model.getId())
                .votes(model.getVotes())
                .electionTable(electionTableMapper.modelToDto(model.getElectionTable()))
                .candidate(candidateMapper.modelToDto(model.getCandidate()))
                .build();
    }

    @Override
    public Result dtoToModel(ResultResponseDTO dto) {
        return Result.builder()
                .id(dto.getId())
                .votes(dto.getVotes())
                .electionTable(electionTableMapper.dtoToModel(dto.getElectionTable()))
                .candidate(candidateMapper.dtoToModel(dto.getCandidate()))
                .build();
    }

    @Override
    public List<Result> entitiesToModels(List<ResultEntity> entities) {
        return entities.stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResultEntity> modelsToEntities(List<Result> models) {
        return models.stream()
                .map(this::modelToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResultResponseDTO> modelsToDtos(List<Result> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Result> dtosToModels(List<ResultResponseDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }

}
