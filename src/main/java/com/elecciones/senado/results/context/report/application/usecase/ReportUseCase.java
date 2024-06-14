package com.elecciones.senado.results.context.report.application.usecase;

import com.elecciones.senado.results.context.report.domain.model.Report;
import com.elecciones.senado.results.context.report.domain.port.ReportRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportUseCase {

    private final ReportRepository reportRepository;
    private final ErrorMessages errorMessages = new ErrorMessages();

    public List<Report> findReport() throws NoResultsException {
        List<Report> reports = reportRepository.findReport();
        if(reports == null || reports.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);
        return reports;
    }

}
