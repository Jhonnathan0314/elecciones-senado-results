package com.elecciones.senado.results.context.election_table.infrastructure.adapter;

import com.elecciones.senado.results.context.election_table.domain.model.ElectionTable;
import com.elecciones.senado.results.context.election_table.domain.port.ElectionTableRepository;
import com.elecciones.senado.results.context.election_table.infrastructure.mappers.ElectionTableMapper;
import com.elecciones.senado.results.context.election_table.infrastructure.persistence.ElectionTableEntity;
import com.elecciones.senado.results.context.election_table.infrastructure.persistence.ElectionTableJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ElectionTableRepositoryJpaAdapter implements ElectionTableRepository {

    private final ElectionTableJpaRepository electionTableJpaRepository;
    private final ElectionTableMapper mapper = new ElectionTableMapper();

    @Override
    public List<ElectionTable> findAll() {
        List<ElectionTableEntity> electionTableEntities = electionTableJpaRepository.findAll();
        return mapper.entitiesToModels(electionTableEntities);
    }

    @Override
    public Optional<ElectionTable> findById(Long id) {
        Optional<ElectionTableEntity> optionalElectionTableEntity = electionTableJpaRepository.findById(id);
        return optionalElectionTableEntity.map(mapper::entityToModel);
    }

    @Override
    public ElectionTable create(ElectionTable electionTable) {
        ElectionTableEntity electionTableEntity = electionTableJpaRepository.save(mapper.modelToEntity(electionTable));
        return mapper.entityToModel(electionTableEntity);
    }

    @Override
    public ElectionTable update(ElectionTable electionTable) {
        ElectionTableEntity electionTableEntity = electionTableJpaRepository.save(mapper.modelToEntity(electionTable));
        return mapper.entityToModel(electionTableEntity);
    }

    @Override
    public void deleteById(Long id) {
        electionTableJpaRepository.deleteById(id);
    }
}
