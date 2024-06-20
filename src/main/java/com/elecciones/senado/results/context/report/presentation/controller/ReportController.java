package com.elecciones.senado.results.context.report.presentation.controller;

import com.elecciones.senado.results.context.report.application.dto.ReportCandidateDTO;
import com.elecciones.senado.results.context.report.application.dto.ReportElectionTableDTO;
import com.elecciones.senado.results.context.report.application.usecase.ReportCandidateUseCase;
import com.elecciones.senado.results.context.report.application.usecase.ReportElectionTableUseCase;
import com.elecciones.senado.results.context.report.infrastructure.mappers.ReportCandidateMapper;
import com.elecciones.senado.results.context.report.infrastructure.mappers.ReportElectionTableMapper;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import com.elecciones.senado.results.utils.http.HttpUtils;
import com.elecciones.senado.results.utils.messages.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/results/report")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReportController {

    private final ReportCandidateUseCase reportCandidateUseCase;
    private final ReportElectionTableUseCase reportElectionTableUseCase;

    private final ReportCandidateMapper reportCandidateMapper = new ReportCandidateMapper();
    private final ReportElectionTableMapper reportElectionTableMapper = new ReportElectionTableMapper();
    private final HttpUtils httpUtils = new HttpUtils();

    @GetMapping("/candidate")
    public ResponseEntity<ApiResponse<List<ReportCandidateDTO>>> findCandidateReport() {
        ApiResponse<List<ReportCandidateDTO>> response = new ApiResponse<>();
        try {
            List<ReportCandidateDTO> reportCandidateDTOS = reportCandidateMapper.modelsToDtos(reportCandidateUseCase.findCandidateReport());
            response.setData(reportCandidateDTOS);
            return ResponseEntity.ok(response);
        } catch (NoResultsException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @GetMapping("/election-table")
    public ResponseEntity<ApiResponse<List<ReportElectionTableDTO>>> findElectionTableReport() {
        ApiResponse<List<ReportElectionTableDTO>> response = new ApiResponse<>();
        try {
            List<ReportElectionTableDTO> reportElectionTableDTOS = reportElectionTableMapper.modelsToDtos(reportElectionTableUseCase.findElectionTableReport());
            response.setData(reportElectionTableDTOS);
            return ResponseEntity.ok(response);
        } catch (NoResultsException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

}
