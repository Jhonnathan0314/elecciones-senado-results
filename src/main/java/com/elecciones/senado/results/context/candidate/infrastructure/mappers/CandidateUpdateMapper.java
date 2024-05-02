package com.elecciones.senado.results.context.candidate.infrastructure.mappers;

import com.elecciones.senado.results.context.candidate.application.dto.CandidateUpdateDTO;
import com.elecciones.senado.results.context.candidate.domain.model.Candidate;
import com.elecciones.senado.results.context.candidate.infrastructure.persistence.CandidateEntity;
import com.elecciones.senado.results.context.party.infrastructure.mappers.PartyUpdateMapper;
import com.elecciones.senado.results.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class CandidateUpdateMapper implements Mapper<CandidateEntity, Candidate, CandidateUpdateDTO> {

    private final PartyUpdateMapper partyUpdateMapper = new PartyUpdateMapper();
    
    @Override
    public Candidate entityToModel(CandidateEntity entity) {
        return Candidate.builder()
                .id(entity.getId())
                .cardNumber(entity.getCardNumber())
                .resolutionNumber(entity.getResolutionNumber())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .party(partyUpdateMapper.entityToModel(entity.getParty()))
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
                .party(partyUpdateMapper.modelToEntity(model.getParty()))
                .state(model.getState())
                .build();
    }

    @Override
    public CandidateUpdateDTO modelToDto(Candidate model) {
        return CandidateUpdateDTO.builder()
                .id(model.getId())
                .cardNumber(model.getCardNumber())
                .resolutionNumber(model.getResolutionNumber())
                .name(model.getName())
                .lastName(model.getLastName())
                .party(partyUpdateMapper.modelToDto(model.getParty()))
                .state(model.getState())
                .build();
    }

    @Override
    public Candidate dtoToModel(CandidateUpdateDTO dto) {
        return Candidate.builder()
                .id(dto.getId())
                .cardNumber(dto.getCardNumber())
                .resolutionNumber(dto.getResolutionNumber())
                .name(dto.getName())
                .lastName(dto.getLastName())
                .party(partyUpdateMapper.dtoToModel(dto.getParty()))
                .state(dto.getState())
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
    public List<CandidateUpdateDTO> modelsToDtos(List<Candidate> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Candidate> dtosToModels(List<CandidateUpdateDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }

}
