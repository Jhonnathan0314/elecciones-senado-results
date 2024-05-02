package com.elecciones.senado.results.context.election_table.domain.port;

import com.elecciones.senado.results.context.election_table.domain.model.ElectionTable;

import java.util.List;
import java.util.Optional;

public interface ElectionTableRepository {

    List<ElectionTable> findAll();
    Optional<ElectionTable> findById(Long id);
    ElectionTable create(ElectionTable electionTable);
    ElectionTable update(ElectionTable electionTable);
    void deleteById(Long id);

}
