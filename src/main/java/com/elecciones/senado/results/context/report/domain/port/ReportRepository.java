package com.elecciones.senado.results.context.report.domain.port;

import com.elecciones.senado.results.context.report.domain.model.ReportCandidate;
import com.elecciones.senado.results.context.report.domain.model.ReportElectionTable;

import java.util.List;

public interface ReportRepository {

    List<ReportCandidate> findCandidateReport();
    List<ReportElectionTable> findElectionTableReport();

}
