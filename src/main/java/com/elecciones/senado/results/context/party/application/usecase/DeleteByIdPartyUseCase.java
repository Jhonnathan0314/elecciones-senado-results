package com.elecciones.senado.results.context.party.application.usecase;

import com.elecciones.senado.results.context.party.domain.model.Party;
import com.elecciones.senado.results.context.party.domain.port.PartyRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.NonExistenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteByIdPartyUseCase {

    private final PartyRepository partyRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public void deleteById(Long id) throws NonExistenceException {

        Optional<Party> optionalParty = partyRepository.findById(id);
        if(optionalParty.isEmpty()) throw new NonExistenceException(errorMessages.NON_EXISTENT_DATA);
        partyRepository.deleteById(id);

    }

}
