package com.elecciones.senado.results.context.candidate.application.usecase;

import com.elecciones.senado.results.context.candidate.domain.model.Candidate;
import com.elecciones.senado.results.context.candidate.domain.port.CandidateRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.DuplicatedException;
import com.elecciones.senado.results.utils.exceptions.InvalidBodyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCandidateUseCase {

    private final CandidateRepository candidateRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public Candidate create(Candidate candidate) throws InvalidBodyException, DuplicatedException {

        if(!candidate.isValid(candidate)) throw new InvalidBodyException(errorMessages.INVALID_BODY);

        if(candidateRepository.findByCardNumber(candidate.getCardNumber()).isPresent()) throw new DuplicatedException(errorMessages.DUPLICATED);

        return candidateRepository.create(candidate);

    }

}
