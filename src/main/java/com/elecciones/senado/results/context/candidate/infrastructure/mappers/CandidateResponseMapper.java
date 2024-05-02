package com.elecciones.senado.results.context.candidate.infrastructure.mappers;

import com.elecciones.senado.results.context.candidate.application.dto.CandidateResponseDTO;
import com.elecciones.senado.results.context.candidate.domain.model.Candidate;
import com.elecciones.senado.results.context.candidate.infrastructure.persistence.CandidateEntity;
import com.elecciones.senado.results.context.party.infrastructure.mappers.PartyResponseMapper;
import com.elecciones.senado.results.utils.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class CandidateResponseMapper implements Mapper<CandidateEntity, Candidate, CandidateResponseDTO> {

    private final PartyResponseMapper partyResponseMapper = new PartyResponseMapper();
    
    @Override
    public Candidate entityToModel(CandidateEntity entity) {
        return Candidate.builder()
                .id(entity.getId())
                .cardNumber(entity.getCardNumber())
                .resolutionNumber(entity.getResolutionNumber())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .party(partyResponseMapper.entityToModel(entity.getParty()))
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
                .party(partyResponseMapper.modelToEntity(model.getParty()))
                .updateDate(model.getUpdateDate())
                .state(model.getState())
                .build();
    }

    @Override
    public CandidateResponseDTO modelToDto(Candidate model) {
        return CandidateResponseDTO.builder()
                .id(model.getId())
                .cardNumber(model.getCardNumber())
                .resolutionNumber(model.getResolutionNumber())
                .name(model.getName())
                .lastName(model.getLastName())
                .party(partyResponseMapper.modelToDto(model.getParty()))
                .build();
    }

    @Override
    public Candidate dtoToModel(CandidateResponseDTO dto) {
        return Candidate.builder()
                .id(dto.getId())
                .cardNumber(dto.getCardNumber())
                .resolutionNumber(dto.getResolutionNumber())
                .name(dto.getName())
                .lastName(dto.getLastName())
                .party(partyResponseMapper.dtoToModel(dto.getParty()))
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
    public List<CandidateResponseDTO> modelsToDtos(List<Candidate> models) {
        return models.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Candidate> dtosToModels(List<CandidateResponseDTO> dtos) {
        return dtos.stream()
                .map(this::dtoToModel)
                .collect(Collectors.toList());
    }

}
