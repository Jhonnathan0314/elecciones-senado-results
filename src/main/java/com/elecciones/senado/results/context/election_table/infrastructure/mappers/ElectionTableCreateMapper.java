package com.elecciones.senado.results.context.election_table.infrastructure.mappers;

import com.elecciones.senado.results.context.election_table.application.dto.ElectionTableCreateDTO;
import com.elecciones.senado.results.context.election_table.domain.model.ElectionTable;
import com.elecciones.senado.results.context.election_table.infrastructure.persistence.ElectionTableEntity;
import com.elecciones.senado.results.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class ElectionTableCreateMapper implements Mapper<ElectionTableEntity, ElectionTable, ElectionTableCreateDTO> {

    @Override
    public ElectionTable entityToModel(ElectionTableEntity entity) {
        return ElectionTable.builder()
                .numberIds(entity.getNumberIds())
                .totalVotes(entity.getTotalVotes())
                .build();
    }

    @Override
    public ElectionTableEntity modelToEntity(ElectionTable model) {
        return ElectionTableEntity.builder()
                .numberIds(model.getNumberIds())
                .totalVotes(model.getTotalVotes())
                .build();
    }

    @Override
    public ElectionTableCreateDTO modelToDto(ElectionTable model) {
        return ElectionTableCreateDTO.builder()
                .numberIds(model.getNumberIds())
                .totalVotes(model.getTotalVotes())
                .build();
    }

    @Override
    public ElectionTable dtoToModel(ElectionTableCreateDTO dto) {
        return ElectionTable.builder()
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
    public List<ElectionTableCreateDTO> modelsToDtos(List<ElectionTable> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ElectionTable> dtosToModels(List<ElectionTableCreateDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }

}
