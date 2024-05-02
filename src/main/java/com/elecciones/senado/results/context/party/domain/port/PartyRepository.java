package com.elecciones.senado.results.context.party.domain.port;

import com.elecciones.senado.results.context.party.domain.model.Party;

import java.util.List;
import java.util.Optional;

public interface PartyRepository {

    List<Party> findAll();
    Optional<Party> findById(Long id);
    Optional<Party> findByName(String name);
    Party create(Party party);
    Party update(Party party);
    void deleteById(Long id);

}
