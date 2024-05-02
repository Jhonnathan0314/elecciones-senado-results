package com.elecciones.senado.results.context.election_table.presentation.controller;

import com.elecciones.senado.results.context.election_table.application.dto.ElectionTableCreateDTO;
import com.elecciones.senado.results.context.election_table.application.dto.ElectionTableResponseDTO;
import com.elecciones.senado.results.context.election_table.application.dto.ElectionTableUpdateDTO;
import com.elecciones.senado.results.context.election_table.application.usecase.*;
import com.elecciones.senado.results.context.election_table.domain.model.ElectionTable;
import com.elecciones.senado.results.context.election_table.infrastructure.mappers.ElectionTableCreateMapper;
import com.elecciones.senado.results.context.election_table.infrastructure.mappers.ElectionTableResponseMapper;
import com.elecciones.senado.results.context.election_table.infrastructure.mappers.ElectionTableUpdateMapper;
import com.elecciones.senado.results.utils.exceptions.*;
import com.elecciones.senado.results.utils.http.HttpUtils;
import com.elecciones.senado.results.utils.messages.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results/election-table")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ElectionTableController {

    private final FindAllElectionTableUseCase findAllElectionTableUseCase;
    private final FindByIdElectionTableUseCase findByIdElectionTableUseCase;
    private final CreateElectionTableUseCase createElectionTableUseCase;
    private final UpdateElectionTableUseCase updateElectionTableUseCase;
    private final DeleteByIdElectionTableUseCase deleteByIdElectionTableUseCase;
    private final ChangeStateByIdElectionTableUseCase changeStateByIdElectionTableUseCase;

    private final ElectionTableCreateMapper electionTableCreateMapper = new ElectionTableCreateMapper();
    private final ElectionTableUpdateMapper electionTableUpdateMapper = new ElectionTableUpdateMapper();
    private final ElectionTableResponseMapper electionTableResponseMapper = new ElectionTableResponseMapper();
    private final HttpUtils httpUtils = new HttpUtils();

    @GetMapping
    public ResponseEntity<ApiResponse<List<ElectionTableResponseDTO>>> findAll() {
        ApiResponse<List<ElectionTableResponseDTO>> response = new ApiResponse<>();
        try {
            List<ElectionTableResponseDTO> electionTables = electionTableResponseMapper.modelsToDtos(findAllElectionTableUseCase.findAll());
            response.setData(electionTables);
            return ResponseEntity.ok(response);
        } catch (NoResultsException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ElectionTableResponseDTO>> findById(@PathVariable Long id) {
        ApiResponse<ElectionTableResponseDTO> response = new ApiResponse<>();
        try {
            ElectionTableResponseDTO electionTable = electionTableResponseMapper.modelToDto(findByIdElectionTableUseCase.findById(id));
            response.setData(electionTable);
            return ResponseEntity.ok(response);
        } catch (NoResultsException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ElectionTableResponseDTO>> create(@RequestBody ElectionTableCreateDTO electionTable) {
        ApiResponse<ElectionTableResponseDTO> response = new ApiResponse<>();
        try {
            ElectionTableResponseDTO electionTableDto = electionTableResponseMapper.modelToDto(createElectionTableUseCase.create(electionTableCreateMapper.dtoToModel(electionTable)));
            response.setData(electionTableDto);
            return ResponseEntity.ok(response);
        } catch (InvalidBodyException | DuplicatedException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @PutMapping
    public ResponseEntity<ApiResponse<ElectionTableResponseDTO>> update(@RequestBody ElectionTableUpdateDTO electionTable) {
        ApiResponse<ElectionTableResponseDTO> response = new ApiResponse<>();
        try {
            ElectionTableResponseDTO electionTableDto = electionTableResponseMapper.modelToDto(updateElectionTableUseCase.update(electionTableUpdateMapper.dtoToModel(electionTable)));
            response.setData(electionTableDto);
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
            deleteByIdElectionTableUseCase.deleteById(id);
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } catch (NonExistenceException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @DeleteMapping("/change-state/{id}")
    public ResponseEntity<ApiResponse<ElectionTableResponseDTO>> changeStateById(@PathVariable Long id) {
        ApiResponse<ElectionTableResponseDTO> response = new ApiResponse<>();
        try {
            ElectionTable electionTable = changeStateByIdElectionTableUseCase.changeStateById(id);
            response.setData(electionTableResponseMapper.modelToDto(electionTable));
            return ResponseEntity.ok(response);
        } catch (NonExistenceException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

}
