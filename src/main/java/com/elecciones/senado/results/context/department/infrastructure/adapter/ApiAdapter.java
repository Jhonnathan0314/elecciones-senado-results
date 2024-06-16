package com.elecciones.senado.results.context.department.infrastructure.adapter;

import com.elecciones.senado.results.context.department.domain.model.Department;
import com.elecciones.senado.results.context.department.domain.port.DepartmentRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.CommunicationErrorException;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ApiAdapter implements DepartmentRepository {

    private RestTemplate restTemplate;
    private String apiColombiaUrl;

    private final ErrorMessages errorMessages = new ErrorMessages();

    @Override
    public List<Department> findAll() throws NoResultsException, CommunicationErrorException {
        try {
            ResponseEntity<List<Department>> response = restTemplate.exchange(
                    apiColombiaUrl + "/Department",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {}
            );
            return response.getBody();
        } catch (Exception e) {
            if(e.getMessage().contains("404")) throw new NoResultsException(errorMessages.NO_RESULTS);
            throw new CommunicationErrorException(errorMessages.COMMUNICATION_ERROR);
        }

    }

    @Override
    public Optional<Department> findById(Long id) throws NoResultsException, CommunicationErrorException {
        try {
            ResponseEntity<Department> response = restTemplate.exchange(
                    apiColombiaUrl + "/Department/" + id,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {}
            );
            return Optional.ofNullable(response.getBody());
        } catch (Exception e) {
            if(e.getMessage().contains("404")) throw new NoResultsException(errorMessages.NO_RESULTS);
            throw new CommunicationErrorException(errorMessages.COMMUNICATION_ERROR);
        }
    }
}
