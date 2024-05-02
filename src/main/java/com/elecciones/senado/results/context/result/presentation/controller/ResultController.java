package com.elecciones.senado.results.context.result.presentation.controller;

import com.elecciones.senado.results.context.party.application.dto.PartyUpdateDTO;
import com.elecciones.senado.results.context.result.application.dto.ResultCreateDTO;
import com.elecciones.senado.results.context.result.application.dto.ResultResponseDTO;
import com.elecciones.senado.results.context.result.application.dto.ResultUpdateDTO;
import com.elecciones.senado.results.context.result.application.usecase.*;
import com.elecciones.senado.results.context.result.infrastructure.mappers.ResultCreateMapper;
import com.elecciones.senado.results.context.result.infrastructure.mappers.ResultResponseMapper;
import com.elecciones.senado.results.context.result.infrastructure.mappers.ResultUpdateMapper;
import com.elecciones.senado.results.utils.exceptions.*;
import com.elecciones.senado.results.utils.http.HttpUtils;
import com.elecciones.senado.results.utils.messages.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results/result")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ResultController {

    private final FindAllResultUseCase findAllResultUseCase;
    private final FindByIdResultUseCase findByIdResultUseCase;
    private final CreateResultUseCase createResultUseCase;
    private final UpdateResultUseCase updateResultUseCase;
    private final DeleteByIdResultUseCase deleteByIdResultUseCase;

    private final ResultCreateMapper resultCreateMapper = new ResultCreateMapper();
    private final ResultUpdateMapper resultUpdateMapper = new ResultUpdateMapper();
    private final ResultResponseMapper resultResponseMapper = new ResultResponseMapper();
    private final HttpUtils httpUtils = new HttpUtils();

    @GetMapping
    public ResponseEntity<ApiResponse<List<ResultResponseDTO>>> findAll() {
        ApiResponse<List<ResultResponseDTO>> response = new ApiResponse<>();
        try {
            List<ResultResponseDTO> results = resultResponseMapper.modelsToDtos(findAllResultUseCase.findAll());
            response.setData(results);
            return ResponseEntity.ok(response);
        } catch (NoResultsException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ResultResponseDTO>> findById(@PathVariable Long id) {
        ApiResponse<ResultResponseDTO> response = new ApiResponse<>();
        try {
            ResultResponseDTO result = resultResponseMapper.modelToDto(findByIdResultUseCase.findById(id));
            response.setData(result);
            return ResponseEntity.ok(response);
        } catch (NoResultsException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ResultResponseDTO>> create(@RequestBody ResultCreateDTO result) {
        ApiResponse<ResultResponseDTO> response = new ApiResponse<>();
        try {
            result.getCandidate().setParty(new PartyUpdateDTO());
            result.getCandidate().getParty().setId(1L);
            ResultResponseDTO resultDto = resultResponseMapper.modelToDto(createResultUseCase.create(resultCreateMapper.dtoToModel(result)));
            response.setData(resultDto);
            return ResponseEntity.ok(response);
        } catch (InvalidBodyException | DuplicatedException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @PutMapping
    public ResponseEntity<ApiResponse<ResultResponseDTO>> update(@RequestBody ResultUpdateDTO result) {
        ApiResponse<ResultResponseDTO> response = new ApiResponse<>();
        try {
            result.getCandidate().setParty(new PartyUpdateDTO());
            result.getCandidate().getParty().setId(1L);
            ResultResponseDTO resultDto = resultResponseMapper.modelToDto(updateResultUseCase.update(resultUpdateMapper.dtoToModel(result)));
            response.setData(resultDto);
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
            deleteByIdResultUseCase.deleteById(id);
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } catch (NonExistenceException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

}
