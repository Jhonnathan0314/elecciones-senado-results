package com.elecciones.senado.results.context.party.application.usecase;

import com.elecciones.senado.results.context.party.domain.model.Party;
import com.elecciones.senado.results.context.party.domain.port.PartyRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindByIdPartyUseCase {

    private final PartyRepository partyRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public Party findById(Long id) throws NoResultsException {
        Optional<Party> optionalParty = partyRepository.findById(id);
        if(optionalParty.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);
        return optionalParty.get();
    }

}
