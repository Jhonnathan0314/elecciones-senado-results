package com.elecciones.senado.results.context.party.application.usecase;

import com.elecciones.senado.results.context.party.domain.model.Party;
import com.elecciones.senado.results.context.party.domain.port.PartyRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllPartyUseCase {

    private final PartyRepository partyRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public List<Party> findAll() throws NoResultsException {
        List<Party> parties = partyRepository.findAll();
        if(parties == null || parties.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);
        return parties;
    }

}
