package com.elecciones.senado.results.context.report.presentation.controller;

import com.elecciones.senado.results.context.report.application.dto.ReportDTO;
import com.elecciones.senado.results.context.report.application.usecase.ReportUseCase;
import com.elecciones.senado.results.context.report.infrastructure.mappers.ReportMapper;
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

    private final ReportUseCase reportUseCase;

    private final ReportMapper mapper = new ReportMapper();
    private final HttpUtils httpUtils = new HttpUtils();

    @GetMapping
    public ResponseEntity<ApiResponse<List<ReportDTO>>> findReport() {
        ApiResponse<List<ReportDTO>> response = new ApiResponse<>();
        try {
            List<ReportDTO> reportDTOS = mapper.modelsToDtos(reportUseCase.findReport());
            response.setData(reportDTOS);
            return ResponseEntity.ok(response);
        } catch (NoResultsException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

}
