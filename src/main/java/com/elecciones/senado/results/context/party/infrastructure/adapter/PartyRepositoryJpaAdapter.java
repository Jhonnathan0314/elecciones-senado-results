package com.elecciones.senado.results.context.party.infrastructure.adapter;

import com.elecciones.senado.results.context.party.domain.model.Party;
import com.elecciones.senado.results.context.party.domain.port.PartyRepository;
import com.elecciones.senado.results.context.party.infrastructure.mappers.PartyMapper;
import com.elecciones.senado.results.context.party.infrastructure.persistence.PartyEntity;
import com.elecciones.senado.results.context.party.infrastructure.persistence.PartyJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PartyRepositoryJpaAdapter implements PartyRepository {

    private final PartyJpaRepository partyJpaRepository;
    private final PartyMapper mapper = new PartyMapper();

    @Override
    public List<Party> findAll() {
        List<PartyEntity> partyEntities = partyJpaRepository.findAll();
        return mapper.entitiesToModels(partyEntities);
    }

    @Override
    public Optional<Party> findById(Long id) {
        Optional<PartyEntity> optionalPartyEntity = partyJpaRepository.findById(id);
        return optionalPartyEntity.map(mapper::entityToModel);
    }

    @Override
    public Optional<Party> findByName(String name) {
        Optional<PartyEntity> optionalPartyEntity = partyJpaRepository.findByName(name);
        return optionalPartyEntity.map(mapper::entityToModel);
    }

    @Override
    public Party create(Party party) {
        PartyEntity partyEntity = partyJpaRepository.save(mapper.modelToEntity(party));
        return mapper.entityToModel(partyEntity);
    }

    @Override
    public Party update(Party party) {
        PartyEntity partyEntity = partyJpaRepository.save(mapper.modelToEntity(party));
        return mapper.entityToModel(partyEntity);
    }

    @Override
    public void deleteById(Long id) {
        partyJpaRepository.deleteById(id);
    }
}
