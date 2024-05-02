package com.elecciones.senado.results.context.party.presentation.controller;

import com.elecciones.senado.results.context.party.application.dto.PartyCreateDTO;
import com.elecciones.senado.results.context.party.application.dto.PartyResponseDTO;
import com.elecciones.senado.results.context.party.application.dto.PartyUpdateDTO;
import com.elecciones.senado.results.context.party.application.usecase.*;
import com.elecciones.senado.results.context.party.domain.model.Party;
import com.elecciones.senado.results.context.party.infrastructure.mappers.PartyCreateMapper;
import com.elecciones.senado.results.context.party.infrastructure.mappers.PartyResponseMapper;
import com.elecciones.senado.results.context.party.infrastructure.mappers.PartyUpdateMapper;
import com.elecciones.senado.results.utils.exceptions.*;
import com.elecciones.senado.results.utils.http.HttpUtils;
import com.elecciones.senado.results.utils.messages.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results/party")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PartyController {

    private final FindAllPartyUseCase findAllPartyUseCase;
    private final FindByIdPartyUseCase findByIdPartyUseCase;
    private final CreatePartyUseCase createPartyUseCase;
    private final UpdatePartyUseCase updatePartyUseCase;
    private final DeleteByIdPartyUseCase deleteByIdPartyUseCase;
    private final ChangeStateByIdPartyUseCase changeStateByIdPartyUseCase;

    private final PartyCreateMapper partyCreateMapper = new PartyCreateMapper();
    private final PartyUpdateMapper partyUpdateMapper = new PartyUpdateMapper();
    private final PartyResponseMapper partyResponseMapper = new PartyResponseMapper();
    private final HttpUtils httpUtils = new HttpUtils();

    @GetMapping
    public ResponseEntity<ApiResponse<List<PartyResponseDTO>>> findAll() {
        ApiResponse<List<PartyResponseDTO>> response = new ApiResponse<>();
        try {
            List<PartyResponseDTO> parties = partyResponseMapper.modelsToDtos(findAllPartyUseCase.findAll());
            response.setData(parties);
            return ResponseEntity.ok(response);
        } catch (NoResultsException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PartyResponseDTO>> findById(@PathVariable Long id) {
        ApiResponse<PartyResponseDTO> response = new ApiResponse<>();
        try {
            PartyResponseDTO party = partyResponseMapper.modelToDto(findByIdPartyUseCase.findById(id));
            response.setData(party);
            return ResponseEntity.ok(response);
        } catch (NoResultsException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PartyResponseDTO>> create(@RequestBody PartyCreateDTO party) {
        ApiResponse<PartyResponseDTO> response = new ApiResponse<>();
        try {
            PartyResponseDTO partyDto = partyResponseMapper.modelToDto(createPartyUseCase.create(partyCreateMapper.dtoToModel(party)));
            response.setData(partyDto);
            return ResponseEntity.ok(response);
        } catch (InvalidBodyException | DuplicatedException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @PutMapping
    public ResponseEntity<ApiResponse<PartyResponseDTO>> update(@RequestBody PartyUpdateDTO party) {
        ApiResponse<PartyResponseDTO> response = new ApiResponse<>();
        try {
            PartyResponseDTO partyDto = partyResponseMapper.modelToDto(updatePartyUseCase.update(partyUpdateMapper.dtoToModel(party)));
            response.setData(partyDto);
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
            deleteByIdPartyUseCase.deleteById(id);
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } catch (NonExistenceException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @DeleteMapping("/change-state/{id}")
    public ResponseEntity<ApiResponse<PartyResponseDTO>> changeStateById(@PathVariable Long id) {
        ApiResponse<PartyResponseDTO> response = new ApiResponse<>();
        try {
            Party party = changeStateByIdPartyUseCase.changeStateById(id);
            response.setData(partyResponseMapper.modelToDto(party));
            return ResponseEntity.ok(response);
        } catch (NonExistenceException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

}
