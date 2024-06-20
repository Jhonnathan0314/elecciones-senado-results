package com.elecciones.senado.results.context.report.application.usecase;

import com.elecciones.senado.results.context.report.domain.model.ReportCandidate;
import com.elecciones.senado.results.context.report.domain.port.ReportRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportCandidateUseCase {

    private final ReportRepository reportRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public List<ReportCandidate> findCandidateReport() throws NoResultsException {
        List<ReportCandidate> reportCandidates = reportRepository.findCandidateReport();
        if(reportCandidates == null || reportCandidates.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);
        return reportCandidates;
    }

}
