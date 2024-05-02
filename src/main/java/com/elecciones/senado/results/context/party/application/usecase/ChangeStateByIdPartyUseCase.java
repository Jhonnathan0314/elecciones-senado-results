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
public class ChangeStateByIdPartyUseCase {

    private final PartyRepository partyRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public Party changeStateById(Long id) throws NonExistenceException {
        Optional<Party> optionalParty = partyRepository.findById(id);
        if(optionalParty.isEmpty()) throw new NonExistenceException(errorMessages.NON_EXISTENT_DATA);

        Party party = optionalParty.get();
        party.setState(party.getState().equals("active") ? "inactive" : "active");
        party = partyRepository.update(party);

        return party;
    }

}
