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
public class FindByIdCandidateUseCase {

    private final CandidateRepository candidateRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public Candidate findById(Long id) throws NoResultsException {
        Optional<Candidate> optionalCandidate = candidateRepository.findById(id);
        if(optionalCandidate.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);
        return optionalCandidate.get();
    }

}
