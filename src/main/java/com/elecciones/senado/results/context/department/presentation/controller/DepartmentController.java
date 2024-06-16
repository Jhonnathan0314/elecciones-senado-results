package com.elecciones.senado.results.context.department.presentation.controller;

import com.elecciones.senado.results.context.department.application.usecase.FindAllDepartmentUseCase;
import com.elecciones.senado.results.context.department.application.usecase.FindByIdDepartmentUseCase;
import com.elecciones.senado.results.context.department.domain.model.Department;
import com.elecciones.senado.results.utils.exceptions.CommunicationErrorException;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import com.elecciones.senado.results.utils.http.HttpUtils;
import com.elecciones.senado.results.utils.messages.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/results/department")
@CrossOrigin("*")
@AllArgsConstructor
public class DepartmentController {

    private final FindAllDepartmentUseCase findAllDepartmentUseCase;
    private final FindByIdDepartmentUseCase findByIdDepartmentUseCase;

    private final HttpUtils httpUtils = new HttpUtils();

    @GetMapping
    public ResponseEntity<ApiResponse<List<Department>>> findAll() {
        ApiResponse<List<Department>> response = new ApiResponse<>();
        try {
            List<Department> departments = findAllDepartmentUseCase.findAll();
            response.setData(departments);
            return ResponseEntity.ok(response);
        } catch (NoResultsException | CommunicationErrorException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Department>> findById(@PathVariable Long id) {
        ApiResponse<Department> response = new ApiResponse<>();
        try {
            Department department = findByIdDepartmentUseCase.findById(id);
            response.setData(department);
            return ResponseEntity.ok(response);
        } catch (NoResultsException | CommunicationErrorException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

}