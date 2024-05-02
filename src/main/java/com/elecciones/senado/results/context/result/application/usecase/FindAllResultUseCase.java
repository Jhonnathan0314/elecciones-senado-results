package com.elecciones.senado.results.context.result.application.usecase;

import com.elecciones.senado.results.context.result.domain.model.Result;
import com.elecciones.senado.results.context.result.domain.port.ResultRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllResultUseCase {

    private final ResultRepository resultRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public List<Result> findAll() throws NoResultsException {
        List<Result> results = resultRepository.findAll();
        if(results == null || results.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);
        return results;
    }

}
