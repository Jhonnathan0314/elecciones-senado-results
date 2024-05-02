package com.elecciones.senado.results.context.election_table.infrastructure.mappers;

import com.elecciones.senado.results.context.election_table.application.dto.ElectionTableDTO;
import com.elecciones.senado.results.context.election_table.domain.model.ElectionTable;
import com.elecciones.senado.results.context.election_table.infrastructure.persistence.ElectionTableEntity;
import com.elecciones.senado.results.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class ElectionTableMapper implements Mapper<ElectionTableEntity, ElectionTable, ElectionTableDTO> {

    @Override
    public ElectionTable entityToModel(ElectionTableEntity entity) {
        return ElectionTable.builder()
                .id(entity.getId())
                .numberIds(entity.getNumberIds())
                .totalVotes(entity.getTotalVotes())
                .updateDate(entity.getUpdateDate())
                .state(entity.getState())
                .build();
    }

    @Override
    public ElectionTableEntity modelToEntity(ElectionTable model) {
        return ElectionTableEntity.builder()
                .id(model.getId())
                .numberIds(model.getNumberIds())
                .totalVotes(model.getTotalVotes())
                .updateDate(model.getUpdateDate())
                .state(model.getState())
                .build();
    }

    @Override
    public ElectionTableDTO modelToDto(ElectionTable model) {
        return ElectionTableDTO.builder()
                .id(model.getId())
                .numberIds(model.getNumberIds())
                .totalVotes(model.getTotalVotes())
                .build();
    }

    @Override
    public ElectionTable dtoToModel(ElectionTableDTO dto) {
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
    public List<ElectionTableDTO> modelsToDtos(List<ElectionTable> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ElectionTable> dtosToModels(List<ElectionTableDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }

}
