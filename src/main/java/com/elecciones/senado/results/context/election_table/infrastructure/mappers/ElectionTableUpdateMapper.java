package com.elecciones.senado.results.context.election_table.infrastructure.mappers;

import com.elecciones.senado.results.context.election_table.application.dto.ElectionTableUpdateDTO;
import com.elecciones.senado.results.context.election_table.domain.model.ElectionTable;
import com.elecciones.senado.results.context.election_table.infrastructure.persistence.ElectionTableEntity;
import com.elecciones.senado.results.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class ElectionTableUpdateMapper implements Mapper<ElectionTableEntity, ElectionTable, ElectionTableUpdateDTO> {

    @Override
    public ElectionTable entityToModel(ElectionTableEntity entity) {
        return ElectionTable.builder()
                .id(entity.getId())
                .numberIds(entity.getNumberIds())
                .totalVotes(entity.getTotalVotes())
                .location(entity.getLocation())
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
                .location(model.getLocation())
                .updateDate(model.getUpdateDate())
                .state(model.getState())
                .build();
    }

    @Override
    public ElectionTableUpdateDTO modelToDto(ElectionTable model) {
        return ElectionTableUpdateDTO.builder()
                .id(model.getId())
                .numberIds(model.getNumberIds())
                .totalVotes(model.getTotalVotes())
                .location(model.getLocation())
                .state(model.getState())
                .build();
    }

    @Override
    public ElectionTable dtoToModel(ElectionTableUpdateDTO dto) {
        return ElectionTable.builder()
                .id(dto.getId())
                .numberIds(dto.getNumberIds())
                .totalVotes(dto.getTotalVotes())
                .location(dto.getLocation())
                .state(dto.getState())
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
    public List<ElectionTableUpdateDTO> modelsToDtos(List<ElectionTable> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ElectionTable> dtosToModels(List<ElectionTableUpdateDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }

}
