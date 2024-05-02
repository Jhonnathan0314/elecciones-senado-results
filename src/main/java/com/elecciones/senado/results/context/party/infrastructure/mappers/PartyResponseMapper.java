package com.elecciones.senado.results.context.party.infrastructure.mappers;

import com.elecciones.senado.results.context.party.application.dto.PartyResponseDTO;
import com.elecciones.senado.results.context.party.domain.model.Party;
import com.elecciones.senado.results.context.party.infrastructure.persistence.PartyEntity;
import com.elecciones.senado.results.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class PartyResponseMapper implements Mapper<PartyEntity, Party, PartyResponseDTO> {

    @Override
    public Party entityToModel(PartyEntity entity) {
        return Party.builder()
                .id(entity.getId())
                .name(entity.getName())
                .motto(entity.getMotto())
                .build();
    }

    @Override
    public PartyEntity modelToEntity(Party model) {
        return PartyEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .motto(model.getMotto())
                .build();
    }

    @Override
    public PartyResponseDTO modelToDto(Party model) {
        return PartyResponseDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .motto(model.getMotto())
                .build();
    }

    @Override
    public Party dtoToModel(PartyResponseDTO dto) {
        return Party.builder()
                .id(dto.getId())
                .name(dto.getName())
                .motto(dto.getMotto())
                .build();
    }

    @Override
    public List<Party> entitiesToModels(List<PartyEntity> entities) {
        return entities.stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<PartyEntity> modelsToEntities(List<Party> models) {
        return models.stream()
                .map(this::modelToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<PartyResponseDTO> modelsToDtos(List<Party> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Party> dtosToModels(List<PartyResponseDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }

}
