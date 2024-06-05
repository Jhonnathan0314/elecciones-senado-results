package com.elecciones.senado.results.context.party.infrastructure.mappers;

import com.elecciones.senado.results.context.party.application.dto.PartyCreateDTO;
import com.elecciones.senado.results.context.party.domain.model.Party;
import com.elecciones.senado.results.context.party.infrastructure.persistence.PartyEntity;
import com.elecciones.senado.results.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class PartyCreateMapper implements Mapper<PartyEntity, Party, PartyCreateDTO> {

    @Override
    public Party entityToModel(PartyEntity entity) {
        return Party.builder()
                .name(entity.getName())
                .motto(entity.getMotto())
                .logo(entity.getLogo())
                .build();
    }

    @Override
    public PartyEntity modelToEntity(Party model) {
        return PartyEntity.builder()
                .name(model.getName())
                .motto(model.getMotto())
                .logo(model.getLogo())
                .build();
    }

    @Override
    public PartyCreateDTO modelToDto(Party model) {
        return PartyCreateDTO.builder()
                .name(model.getName())
                .motto(model.getMotto())
                .logo(model.getLogo())
                .build();
    }

    @Override
    public Party dtoToModel(PartyCreateDTO dto) {
        return Party.builder()
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
    public List<PartyCreateDTO> modelsToDtos(List<Party> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Party> dtosToModels(List<PartyCreateDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }

}
