package com.elecciones.senado.results.context.party.infrastructure.mappers;

import com.elecciones.senado.results.context.party.application.dto.PartyDTO;
import com.elecciones.senado.results.context.party.domain.model.Party;
import com.elecciones.senado.results.context.party.infrastructure.persistence.PartyEntity;
import com.elecciones.senado.results.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class PartyMapper implements Mapper<PartyEntity, Party, PartyDTO> {

    @Override
    public Party entityToModel(PartyEntity entity) {
        return Party.builder()
                .id(entity.getId())
                .name(entity.getName())
                .motto(entity.getMotto())
                .logo(entity.getLogo())
                .updateDate(entity.getUpdateDate())
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
                .updateDate(model.getUpdateDate())
                .state(model.getState())
                .build();
    }

    @Override
    public PartyDTO modelToDto(Party model) {
        return PartyDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .motto(model.getMotto())
                .logo(model.getLogo())
                .build();
    }

    @Override
    public Party dtoToModel(PartyDTO dto) {
        return Party.builder()
                .id(dto.getId())
                .name(dto.getName())
                .motto(dto.getMotto())
                .logo(dto.getLogo())
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
    public List<PartyDTO> modelsToDtos(List<Party> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Party> dtosToModels(List<PartyDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }

}
