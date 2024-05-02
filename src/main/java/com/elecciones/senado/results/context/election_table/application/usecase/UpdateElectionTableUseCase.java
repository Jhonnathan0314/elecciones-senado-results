package com.elecciones.senado.results.context.election_table.application.usecase;

import com.elecciones.senado.results.context.election_table.domain.model.ElectionTable;
import com.elecciones.senado.results.context.election_table.domain.port.ElectionTableRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.InvalidBodyException;
import com.elecciones.senado.results.utils.exceptions.NoChangesException;
import com.elecciones.senado.results.utils.exceptions.NoIdReceivedException;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateElectionTableUseCase {

    private final ElectionTableRepository electionTableRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public ElectionTable update(ElectionTable electionTable) throws NoIdReceivedException, InvalidBodyException, NoResultsException, NoChangesException {

        if(electionTable.getId() == null) throw new NoIdReceivedException(errorMessages.NO_ID_RECEIVED);

        if(!electionTable.isValid(electionTable)) throw new InvalidBodyException(errorMessages.INVALID_BODY);

        Optional<ElectionTable> optionalElectionTable = electionTableRepository.findById(electionTable.getId());
        if(optionalElectionTable.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);

        ElectionTable electionTableDb = optionalElectionTable.get();
        if(electionTableDb.equals(electionTable)) throw new NoChangesException(errorMessages.NO_CHANGES);

        electionTable.setState(electionTableDb.getState());
        electionTable.setCreationDate(electionTableDb.getCreationDate());

        return electionTableRepository.update(electionTable);

    }

}
