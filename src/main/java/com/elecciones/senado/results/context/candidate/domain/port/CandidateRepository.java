package com.elecciones.senado.results.context.candidate.domain.port;

import com.elecciones.senado.results.context.candidate.domain.model.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository {

    List<Candidate> findAll();
    Optional<Candidate> findById(Long id);
    Optional<Candidate> findByCardNumber(Long cardNumber);
    Candidate create(Candidate candidate);
    Candidate update(Candidate candidate);
    void deleteById(Long id);

}
