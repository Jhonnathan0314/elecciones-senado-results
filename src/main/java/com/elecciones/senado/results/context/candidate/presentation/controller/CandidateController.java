package com.elecciones.senado.results.context.candidate.presentation.controller;

import com.elecciones.senado.results.context.candidate.application.dto.CandidateCreateDTO;
import com.elecciones.senado.results.context.candidate.application.dto.CandidateResponseDTO;
import com.elecciones.senado.results.context.candidate.application.dto.CandidateUpdateDTO;
import com.elecciones.senado.results.context.candidate.application.usecase.*;
import com.elecciones.senado.results.context.candidate.domain.model.Candidate;
import com.elecciones.senado.results.context.candidate.infrastructure.mappers.CandidateCreateMapper;
import com.elecciones.senado.results.context.candidate.infrastructure.mappers.CandidateResponseMapper;
import com.elecciones.senado.results.context.candidate.infrastructure.mappers.CandidateUpdateMapper;
import com.elecciones.senado.results.utils.exceptions.*;
import com.elecciones.senado.results.utils.http.HttpUtils;
import com.elecciones.senado.results.utils.messages.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results/candidate")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CandidateController {

    private final FindAllCandidateUseCase findAllCandidateUseCase;
    private final FindByIdCandidateUseCase findByIdCandidateUseCase;
    private final CreateCandidateUseCase createCandidateUseCase;
    private final UpdateCandidateUseCase updateCandidateUseCase;
    private final DeleteByIdCandidateUseCase deleteByIdCandidateUseCase;
    private final ChangeStateByIdCandidateUseCase changeStateByIdCandidateUseCase;

    private final CandidateCreateMapper candidateCreateMapper = new CandidateCreateMapper();
    private final CandidateUpdateMapper candidateUpdateMapper = new CandidateUpdateMapper();
    private final CandidateResponseMapper candidateResponseMapper = new CandidateResponseMapper();
    private final HttpUtils httpUtils = new HttpUtils();

    @GetMapping
    public ResponseEntity<ApiResponse<List<CandidateResponseDTO>>> findAll() {
        ApiResponse<List<CandidateResponseDTO>> response = new ApiResponse<>();
        try {
            List<CandidateResponseDTO> candidates = candidateResponseMapper.modelsToDtos(findAllCandidateUseCase.findAll());
            response.setData(candidates);
            return ResponseEntity.ok(response);
        } catch (NoResultsException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CandidateResponseDTO>> findById(@PathVariable Long id) {
        ApiResponse<CandidateResponseDTO> response = new ApiResponse<>();
        try {
            CandidateResponseDTO candidate = candidateResponseMapper.modelToDto(findByIdCandidateUseCase.findById(id));
            response.setData(candidate);
            return ResponseEntity.ok(response);
        } catch (NoResultsException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CandidateResponseDTO>> create(@RequestBody CandidateCreateDTO candidate) {
        ApiResponse<CandidateResponseDTO> response = new ApiResponse<>();
        try {
            CandidateResponseDTO candidateDto = candidateResponseMapper.modelToDto(createCandidateUseCase.create(candidateCreateMapper.dtoToModel(candidate)));
            response.setData(candidateDto);
            return ResponseEntity.ok(response);
        } catch (InvalidBodyException | DuplicatedException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @PutMapping
    public ResponseEntity<ApiResponse<CandidateResponseDTO>> update(@RequestBody CandidateUpdateDTO candidate) {
        ApiResponse<CandidateResponseDTO> response = new ApiResponse<>();
        try {
            CandidateResponseDTO candidateDto = candidateResponseMapper.modelToDto(updateCandidateUseCase.update(candidateUpdateMapper.dtoToModel(candidate)));
            response.setData(candidateDto);
            return ResponseEntity.ok(response);
        } catch (InvalidBodyException | NoIdReceivedException | NoResultsException |
                 NoChangesException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteById(@PathVariable Long id) {
        ApiResponse<Object> response = new ApiResponse<>();
        try {
            deleteByIdCandidateUseCase.deleteById(id);
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } catch (NonExistenceException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @DeleteMapping("/change-state/{id}")
    public ResponseEntity<ApiResponse<CandidateResponseDTO>> changeStateById(@PathVariable Long id) {
        ApiResponse<CandidateResponseDTO> response = new ApiResponse<>();
        try {
            Candidate candidate = changeStateByIdCandidateUseCase.changeStateById(id);
            response.setData(candidateResponseMapper.modelToDto(candidate));
            return ResponseEntity.ok(response);
        } catch (NonExistenceException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

}
