package com.elecciones.senado.results.context.election_table.application.usecase;

import com.elecciones.senado.results.context.election_table.domain.model.ElectionTable;
import com.elecciones.senado.results.context.election_table.domain.port.ElectionTableRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllElectionTableUseCase {

    private final ElectionTableRepository electionTableRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public List<ElectionTable> findAll() throws NoResultsException {
        List<ElectionTable> electionTables = electionTableRepository.findAll();
        if(electionTables == null || electionTables.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);
        return electionTables;
    }

}
