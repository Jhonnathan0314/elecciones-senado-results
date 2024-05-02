package com.elecciones.senado.results.context.election_table.application.usecase;

import com.elecciones.senado.results.context.election_table.domain.model.ElectionTable;
import com.elecciones.senado.results.context.election_table.domain.port.ElectionTableRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindByIdElectionTableUseCase {

    private final ElectionTableRepository electionTableRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public ElectionTable findById(Long id) throws NoResultsException {
        Optional<ElectionTable> optionalElectionTable = electionTableRepository.findById(id);
        if(optionalElectionTable.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);
        return optionalElectionTable.get();
    }

}
