package com.elecciones.senado.results.context.city.presentation.controller;

import com.elecciones.senado.results.context.city.application.usecase.FindByDepartmentCityUseCase;
import com.elecciones.senado.results.context.city.domain.model.City;
import com.elecciones.senado.results.context.city.application.usecase.FindAllCityUseCase;
import com.elecciones.senado.results.context.city.application.usecase.FindByIdCityUseCase;
import com.elecciones.senado.results.utils.exceptions.CommunicationErrorException;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import com.elecciones.senado.results.utils.http.HttpUtils;
import com.elecciones.senado.results.utils.messages.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/results/city")
@CrossOrigin("*")
@AllArgsConstructor
public class CityController {

    private final FindAllCityUseCase findAllCityUseCase;
    private final FindByIdCityUseCase findByIdCityUseCase;
    private final FindByDepartmentCityUseCase findByDepartmentCityUseCase;

    private final HttpUtils httpUtils = new HttpUtils();

    @GetMapping
    public ResponseEntity<ApiResponse<List<City>>> findAll() {
        ApiResponse<List<City>> response = new ApiResponse<>();
        try {
            List<City> cities = findAllCityUseCase.findAll();
            response.setData(cities);
            return ResponseEntity.ok(response);
        } catch (NoResultsException | CommunicationErrorException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<City>> findById(@PathVariable Long id) {
        ApiResponse<City> response = new ApiResponse<>();
        try {
            City city = findByIdCityUseCase.findById(id);
            response.setData(city);
            return ResponseEntity.ok(response);
        } catch (NoResultsException | CommunicationErrorException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<ApiResponse<List<City>>> findByDepartment(@PathVariable Long id) {
        ApiResponse<List<City>> response = new ApiResponse<>();
        try {
            List<City> cities = findByDepartmentCityUseCase.findById(id);
            response.setData(cities);
            return ResponseEntity.ok(response);
        } catch (NoResultsException | CommunicationErrorException e) {
            response.setError(httpUtils.determineErrorMessage(e));
            return new ResponseEntity<>(response, httpUtils.determineHttpStatus(e));
        }
    }

}