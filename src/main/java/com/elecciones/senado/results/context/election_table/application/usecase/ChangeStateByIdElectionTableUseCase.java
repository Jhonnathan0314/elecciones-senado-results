package com.elecciones.senado.results.context.election_table.application.usecase;

import com.elecciones.senado.results.context.election_table.domain.model.ElectionTable;
import com.elecciones.senado.results.context.election_table.domain.port.ElectionTableRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.NonExistenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChangeStateByIdElectionTableUseCase {

    private final ElectionTableRepository electionTableRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public ElectionTable changeStateById(Long id) throws NonExistenceException {
        Optional<ElectionTable> optionalElectionTable = electionTableRepository.findById(id);
        if(optionalElectionTable.isEmpty()) throw new NonExistenceException(errorMessages.NON_EXISTENT_DATA);

        ElectionTable electionTable = optionalElectionTable.get();
        electionTable.setState(electionTable.getState().equals("active") ? "inactive" : "active");
        electionTable = electionTableRepository.update(electionTable);

        return electionTable;
    }

}
