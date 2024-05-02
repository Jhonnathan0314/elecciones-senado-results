package com.elecciones.senado.results.context.party.application.usecase;

import com.elecciones.senado.results.context.party.domain.model.Party;
import com.elecciones.senado.results.context.party.domain.port.PartyRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.DuplicatedException;
import com.elecciones.senado.results.utils.exceptions.InvalidBodyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePartyUseCase {

    private final PartyRepository partyRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public Party create(Party party) throws InvalidBodyException, DuplicatedException {

        if(!party.isValid(party)) throw new InvalidBodyException(errorMessages.INVALID_BODY);

        if(partyRepository.findByName(party.getName()).isPresent()) throw new DuplicatedException(errorMessages.DUPLICATED);

        return partyRepository.create(party);

    }

}
