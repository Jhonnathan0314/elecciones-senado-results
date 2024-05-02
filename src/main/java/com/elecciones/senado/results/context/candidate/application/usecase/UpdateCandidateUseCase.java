package com.elecciones.senado.results.context.candidate.application.usecase;

import com.elecciones.senado.results.context.candidate.domain.model.Candidate;
import com.elecciones.senado.results.context.candidate.domain.port.CandidateRepository;
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
public class UpdateCandidateUseCase {

    private final CandidateRepository candidateRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public Candidate update(Candidate candidate) throws NoIdReceivedException, InvalidBodyException, NoResultsException, NoChangesException {

        if(candidate.getId() == null) throw new NoIdReceivedException(errorMessages.NO_ID_RECEIVED);

        if(!candidate.isValid(candidate)) throw new InvalidBodyException(errorMessages.INVALID_BODY);

        Optional<Candidate> optionalCandidate = candidateRepository.findById(candidate.getId());
        if(optionalCandidate.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);

        Candidate candidateDb = optionalCandidate.get();
        if(candidateDb.equals(candidate)) throw new NoChangesException(errorMessages.NO_CHANGES);

        candidate.setState(candidateDb.getState());
        candidate.setCreationDate(candidateDb.getCreationDate());

        return candidateRepository.update(candidate);

    }

}
