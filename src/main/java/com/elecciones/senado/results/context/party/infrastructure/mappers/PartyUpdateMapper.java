package com.elecciones.senado.results.context.party.infrastructure.mappers;

import com.elecciones.senado.results.context.party.application.dto.PartyUpdateDTO;
import com.elecciones.senado.results.context.party.domain.model.Party;
import com.elecciones.senado.results.context.party.infrastructure.persistence.PartyEntity;
import com.elecciones.senado.results.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class PartyUpdateMapper implements Mapper<PartyEntity, Party, PartyUpdateDTO> {

    @Override
    public Party entityToModel(PartyEntity entity) {
        return Party.builder()
                .id(entity.getId())
                .name(entity.getName())
                .motto(entity.getMotto())
                .logo(entity.getLogo())
                .state(entity.getState())
                .build();
    }

    @Override
    public PartyEntity modelToEntity(Party model) {
        return PartyEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .motto(model.getMotto())
                .logo(model.getLogo())
                .state(model.getState())
                .build();
    }

    @Override
    public PartyUpdateDTO modelToDto(Party model) {
        return PartyUpdateDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .motto(model.getMotto())
                .logo(model.getLogo())
                .state(model.getState())
                .build();
    }

    @Override
    public Party dtoToModel(PartyUpdateDTO dto) {
        return Party.builder()
                .id(dto.getId())
                .name(dto.getName())
                .motto(dto.getMotto())
                .logo(dto.getLogo())
                .state(dto.getState())
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
    public List<PartyUpdateDTO> modelsToDtos(List<Party> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Party> dtosToModels(List<PartyUpdateDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }

}
