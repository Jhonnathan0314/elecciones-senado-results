package com.elecciones.senado.results.context.election_table.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ElectionTableJpaRepository extends JpaRepository<ElectionTableEntity, Long> {

}
