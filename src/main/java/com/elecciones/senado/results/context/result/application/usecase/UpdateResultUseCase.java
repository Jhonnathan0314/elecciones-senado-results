package com.elecciones.senado.results.context.result.application.usecase;

import com.elecciones.senado.results.context.result.domain.model.Result;
import com.elecciones.senado.results.context.result.domain.port.ResultRepository;
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
public class UpdateResultUseCase {

    private final ResultRepository resultRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public Result update(Result result) throws NoIdReceivedException, InvalidBodyException, NoResultsException, NoChangesException {

        if(result.getId() == null) throw new NoIdReceivedException(errorMessages.NO_ID_RECEIVED);

        if(!result.isValid(result)) throw new InvalidBodyException(errorMessages.INVALID_BODY);

        Optional<Result> optionalResult = resultRepository.findById(result.getId());
        if(optionalResult.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);

        Result resultDb = optionalResult.get();
        if(resultDb.equals(result)) throw new NoChangesException(errorMessages.NO_CHANGES);

        return resultRepository.update(result);

    }

}
