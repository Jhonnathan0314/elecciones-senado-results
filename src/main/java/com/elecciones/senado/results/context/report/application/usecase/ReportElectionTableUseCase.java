package com.elecciones.senado.results.context.report.application.usecase;

import com.elecciones.senado.results.context.report.domain.model.ReportElectionTable;
import com.elecciones.senado.results.context.report.domain.port.ReportRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportElectionTableUseCase {

    private final ReportRepository reportRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public List<ReportElectionTable> findElectionTableReport() throws NoResultsException {
        List<ReportElectionTable> reportElectionTables = reportRepository.findElectionTableReport();
        if(reportElectionTables == null || reportElectionTables.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);
        return reportElectionTables;
    }

}
