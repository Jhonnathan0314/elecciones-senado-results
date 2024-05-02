package com.elecciones.senado.results.context.party.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartyJpaRepository extends JpaRepository<PartyEntity, Long> {

    Optional<PartyEntity> findByName(String name);

}
