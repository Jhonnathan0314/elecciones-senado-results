package com.elecciones.senado.results.context.party.application.usecase;

import com.elecciones.senado.results.context.party.domain.model.Party;
import com.elecciones.senado.results.context.party.domain.port.PartyRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdatePartyUseCase {

    private final PartyRepository partyRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public Party update(Party party) throws NoIdReceivedException, InvalidBodyException, NoResultsException, NoChangesException {

        if(party.getId() == null) throw new NoIdReceivedException(errorMessages.NO_ID_RECEIVED);

        if(!party.isValid(party)) throw new InvalidBodyException(errorMessages.INVALID_BODY);

        Optional<Party> optionalParty = partyRepository.findById(party.getId());
        if(optionalParty.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);

        Party partyDb = optionalParty.get();
        if(partyDb.equals(party)) throw new NoChangesException(errorMessages.NO_CHANGES);

        party.setState(partyDb.getState());
        party.setCreationDate(partyDb.getCreationDate());

        return partyRepository.update(party);

    }

}
