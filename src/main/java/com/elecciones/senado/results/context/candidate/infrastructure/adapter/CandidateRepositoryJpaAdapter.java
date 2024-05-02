package com.elecciones.senado.results.context.candidate.infrastructure.adapter;

import com.elecciones.senado.results.context.candidate.domain.model.Candidate;
import com.elecciones.senado.results.context.candidate.domain.port.CandidateRepository;
import com.elecciones.senado.results.context.candidate.infrastructure.mappers.CandidateMapper;
import com.elecciones.senado.results.context.candidate.infrastructure.persistence.CandidateEntity;
import com.elecciones.senado.results.context.candidate.infrastructure.persistence.CandidateJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CandidateRepositoryJpaAdapter implements CandidateRepository {

    private final CandidateJpaRepository candidateJpaRepository;
    private final CandidateMapper mapper = new CandidateMapper();

    @Override
    public List<Candidate> findAll() {
        List<CandidateEntity> candidateEntities = candidateJpaRepository.findAll();
        return mapper.entitiesToModels(candidateEntities);
    }

    @Override
    public Optional<Candidate> findById(Long id) {
        Optional<CandidateEntity> optionalCandidateEntity = candidateJpaRepository.findById(id);
        return optionalCandidateEntity.map(mapper::entityToModel);
    }

    @Override
    public Optional<Candidate> findByCardNumber(Long cardNumber) {
        Optional<CandidateEntity> optionalCandidateEntity = candidateJpaRepository.findByCardNumber(cardNumber);
        return optionalCandidateEntity.map(mapper::entityToModel);
    }

    @Override
    public Candidate create(Candidate candidate) {
        CandidateEntity candidateEntity = candidateJpaRepository.save(mapper.modelToEntity(candidate));
        return mapper.entityToModel(candidateEntity);
    }

    @Override
    public Candidate update(Candidate candidate) {
        CandidateEntity candidateEntity = candidateJpaRepository.save(mapper.modelToEntity(candidate));
        return mapper.entityToModel(candidateEntity);
    }

    @Override
    public void deleteById(Long id) {
        candidateJpaRepository.deleteById(id);
    }
}
