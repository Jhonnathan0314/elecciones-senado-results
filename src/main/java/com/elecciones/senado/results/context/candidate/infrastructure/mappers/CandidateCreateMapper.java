package com.elecciones.senado.results.context.candidate.infrastructure.mappers;

import com.elecciones.senado.results.context.candidate.application.dto.CandidateCreateDTO;
import com.elecciones.senado.results.context.candidate.domain.model.Candidate;
import com.elecciones.senado.results.context.candidate.infrastructure.persistence.CandidateEntity;
import com.elecciones.senado.results.context.party.infrastructure.mappers.PartyUpdateMapper;
import com.elecciones.senado.results.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class CandidateCreateMapper implements Mapper<CandidateEntity, Candidate, CandidateCreateDTO> {

    private final PartyUpdateMapper partyUpdateMapper = new PartyUpdateMapper();
    
    @Override
    public Candidate entityToModel(CandidateEntity entity) {
        return Candidate.builder()
                .cardNumber(entity.getCardNumber())
                .resolutionNumber(entity.getResolutionNumber())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .party(partyUpdateMapper.entityToModel(entity.getParty()))
                .build();
    }

    @Override
    public CandidateEntity modelToEntity(Candidate model) {
        return CandidateEntity.builder()
                .cardNumber(model.getCardNumber())
                .resolutionNumber(model.getResolutionNumber())
                .name(model.getName())
                .lastName(model.getLastName())
                .party(partyUpdateMapper.modelToEntity(model.getParty()))
                .build();
    }

    @Override
    public CandidateCreateDTO modelToDto(Candidate model) {
        return CandidateCreateDTO.builder()
                .cardNumber(model.getCardNumber())
                .resolutionNumber(model.getResolutionNumber())
                .name(model.getName())
                .lastName(model.getLastName())
                .party(partyUpdateMapper.modelToDto(model.getParty()))
                .build();
    }

    @Override
    public Candidate dtoToModel(CandidateCreateDTO dto) {
        return Candidate.builder()
                .cardNumber(dto.getCardNumber())
                .resolutionNumber(dto.getResolutionNumber())
                .name(dto.getName())
                .lastName(dto.getLastName())
                .party(partyUpdateMapper.dtoToModel(dto.getParty()))
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
    public List<CandidateCreateDTO> modelsToDtos(List<Candidate> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Candidate> dtosToModels(List<CandidateCreateDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }

}
