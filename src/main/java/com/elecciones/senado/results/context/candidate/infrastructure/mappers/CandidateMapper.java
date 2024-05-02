package com.elecciones.senado.results.context.candidate.infrastructure.mappers;

import com.elecciones.senado.results.context.candidate.application.dto.CandidateDTO;
import com.elecciones.senado.results.context.candidate.domain.model.Candidate;
import com.elecciones.senado.results.context.candidate.infrastructure.persistence.CandidateEntity;
import com.elecciones.senado.results.context.party.infrastructure.mappers.PartyMapper;
import com.elecciones.senado.results.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class CandidateMapper implements Mapper<CandidateEntity, Candidate, CandidateDTO> {

    private final PartyMapper partyMapper = new PartyMapper();

    @Override
    public Candidate entityToModel(CandidateEntity entity) {
        return Candidate.builder()
                .id(entity.getId())
                .cardNumber(entity.getCardNumber())
                .resolutionNumber(entity.getResolutionNumber())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .party(partyMapper.entityToModel(entity.getParty()))
                .updateDate(entity.getUpdateDate())
                .state(entity.getState())
                .build();
    }

    @Override
    public CandidateEntity modelToEntity(Candidate model) {
        return CandidateEntity.builder()
                .id(model.getId())
                .cardNumber(model.getCardNumber())
                .resolutionNumber(model.getResolutionNumber())
                .name(model.getName())
                .lastName(model.getLastName())
                .party(partyMapper.modelToEntity(model.getParty()))
                .updateDate(model.getUpdateDate())
                .state(model.getState())
                .build();
    }

    @Override
    public CandidateDTO modelToDto(Candidate model) {
        return CandidateDTO.builder()
                .id(model.getId())
                .cardNumber(model.getCardNumber())
                .resolutionNumber(model.getResolutionNumber())
                .name(model.getName())
                .lastName(model.getLastName())
                .party(partyMapper.modelToDto(model.getParty()))
                .build();
    }

    @Override
    public Candidate dtoToModel(CandidateDTO dto) {
        return Candidate.builder()
                .id(dto.getId())
                .cardNumber(dto.getCardNumber())
                .resolutionNumber(dto.getResolutionNumber())
                .name(dto.getName())
                .lastName(dto.getLastName())
                .party(partyMapper.dtoToModel(dto.getParty()))
                .build();
    }

    @Override
    public List<Candidate> entitiesToModels(List<CandidateEntity> entities) {
        return entities.stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<CandidateEntity> modelsToEntities(List<Candidate> models) {
        return models.stream()
                .map(this::modelToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CandidateDTO> modelsToDtos(List<Candidate> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Candidate> dtosToModels(List<CandidateDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }

}
