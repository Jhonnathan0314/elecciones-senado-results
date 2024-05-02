package com.elecciones.senado.results.context.result.application.usecase;

import com.elecciones.senado.results.context.result.domain.model.Result;
import com.elecciones.senado.results.context.result.domain.port.ResultRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.NonExistenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteByIdResultUseCase {

    private final ResultRepository resultRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public void deleteById(Long id) throws NonExistenceException {

        Optional<Result> optionalResult = resultRepository.findById(id);
        if(optionalResult.isEmpty()) throw new NonExistenceException(errorMessages.NON_EXISTENT_DATA);
        resultRepository.deleteById(id);
        
    }

}
