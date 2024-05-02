package com.elecciones.senado.results.context.result.application.usecase;

import com.elecciones.senado.results.context.result.domain.model.Result;
import com.elecciones.senado.results.context.result.domain.port.ResultRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindByIdResultUseCase {

    private final ResultRepository resultRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public Result findById(Long id) throws NoResultsException {
        Optional<Result> optionalResult = resultRepository.findById(id);
        if(optionalResult.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);
        return optionalResult.get();
    }

}
