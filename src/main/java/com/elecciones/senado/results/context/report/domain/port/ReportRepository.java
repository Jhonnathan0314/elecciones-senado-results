package com.elecciones.senado.results.context.report.domain.port;

import com.elecciones.senado.results.context.report.domain.model.Report;

import java.util.List;

public interface ReportRepository {

    List<Report> findReport();

}
