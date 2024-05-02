package com.elecciones.senado.results.context.election_table.infrastructure.mappers;

import com.elecciones.senado.results.context.election_table.application.dto.ElectionTableResponseDTO;
import com.elecciones.senado.results.context.election_table.domain.model.ElectionTable;
import com.elecciones.senado.results.context.election_table.infrastructure.persistence.ElectionTableEntity;
import com.elecciones.senado.results.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class ElectionTableResponseMapper implements Mapper<ElectionTableEntity, ElectionTable, ElectionTableResponseDTO> {

    @Override
    public ElectionTable entityToModel(ElectionTableEntity entity) {
        return ElectionTable.builder()
                .id(entity.getId())
                .numberIds(entity.getNumberIds())
                .totalVotes(entity.getTotalVotes())
                .build();
    }

    @Override
    public ElectionTableEntity modelToEntity(ElectionTable model) {
        return ElectionTableEntity.builder()
                .id(model.getId())
                .numberIds(model.getNumberIds())
                .totalVotes(model.getTotalVotes())
                .build();
    }

    @Override
    public ElectionTableResponseDTO modelToDto(ElectionTable model) {
        return ElectionTableResponseDTO.builder()
                .id(model.getId())
                .numberIds(model.getNumberIds())
                .totalVotes(model.getTotalVotes())
                .build();
    }

    @Override
    public ElectionTable dtoToModel(ElectionTableResponseDTO dto) {
        return ElectionTable.builder()
                .id(dto.getId())
                .numberIds(dto.getNumberIds())
                .totalVotes(dto.getTotalVotes())
                .build();
    }

    @Override
    public List<ElectionTable> entitiesToModels(List<ElectionTableEntity> entities) {
        return entities.stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<ElectionTableEntity> modelsToEntities(List<ElectionTable> models) {
        return models.stream()
                .map(this::modelToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ElectionTableResponseDTO> modelsToDtos(List<ElectionTable> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ElectionTable> dtosToModels(List<ElectionTableResponseDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }

}
