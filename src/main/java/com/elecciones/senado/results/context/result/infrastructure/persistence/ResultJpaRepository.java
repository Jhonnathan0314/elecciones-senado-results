package com.elecciones.senado.results.context.result.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResultJpaRepository extends JpaRepository<ResultEntity, Long> {

}
