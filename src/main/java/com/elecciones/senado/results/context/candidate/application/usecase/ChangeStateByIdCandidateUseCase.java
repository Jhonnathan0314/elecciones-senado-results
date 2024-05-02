package com.elecciones.senado.results.context.candidate.application.usecase;

import com.elecciones.senado.results.context.candidate.domain.model.Candidate;
import com.elecciones.senado.results.context.candidate.domain.port.CandidateRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.NonExistenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChangeStateByIdCandidateUseCase {

    private final CandidateRepository candidateRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public Candidate changeStateById(Long id) throws NonExistenceException {
        Optional<Candidate> optionalCandidate = candidateRepository.findById(id);
        if(optionalCandidate.isEmpty()) throw new NonExistenceException(errorMessages.NON_EXISTENT_DATA);

        Candidate candidate = optionalCandidate.get();
        candidate.setState(candidate.getState().equals("active") ? "inactive" : "active");
        candidate = candidateRepository.update(candidate);

        return candidate;
    }

}
