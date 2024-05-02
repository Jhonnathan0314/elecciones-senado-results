package com.elecciones.senado.results.context.election_table.application.usecase;

import com.elecciones.senado.results.context.election_table.domain.model.ElectionTable;
import com.elecciones.senado.results.context.election_table.domain.port.ElectionTableRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.DuplicatedException;
import com.elecciones.senado.results.utils.exceptions.InvalidBodyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateElectionTableUseCase {

    private final ElectionTableRepository electionTableRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public ElectionTable create(ElectionTable electionTable) throws InvalidBodyException, DuplicatedException {

        if(!electionTable.isValid(electionTable)) throw new InvalidBodyException(errorMessages.INVALID_BODY);

        return electionTableRepository.create(electionTable);

    }

}
