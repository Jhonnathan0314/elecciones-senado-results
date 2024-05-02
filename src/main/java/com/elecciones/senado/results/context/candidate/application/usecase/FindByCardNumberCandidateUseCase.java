package com.elecciones.senado.results.context.candidate.application.usecase;

import com.elecciones.senado.results.context.candidate.domain.model.Candidate;
import com.elecciones.senado.results.context.candidate.domain.port.CandidateRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindByCardNumberCandidateUseCase {

    private final CandidateRepository candidateRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public Candidate findByCardNumber(Long cardNumber) throws NoResultsException {
        Optional<Candidate> optionalCandidate = candidateRepository.findByCardNumber(cardNumber);
        if(optionalCandidate.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);
        return optionalCandidate.get();
    }

}
