package com.elecciones.senado.results.context.result.application.usecase;

import com.elecciones.senado.results.context.party.domain.model.Party;
import com.elecciones.senado.results.context.result.domain.model.Result;
import com.elecciones.senado.results.context.result.domain.port.ResultRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.DuplicatedException;
import com.elecciones.senado.results.utils.exceptions.InvalidBodyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateResultUseCase {

    private final ResultRepository resultRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public Result create(Result result) throws InvalidBodyException, DuplicatedException {

        if(!result.isValid(result)) throw new InvalidBodyException(errorMessages.INVALID_BODY);

        return resultRepository.create(result);

    }

}
