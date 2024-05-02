package com.elecciones.senado.results.context.candidate.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateJpaRepository extends JpaRepository<CandidateEntity, Long> {

    Optional<CandidateEntity> findByCardNumber(Long cardNumber);

}
