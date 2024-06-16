package com.elecciones.senado.results.context.city.infrastructure.adapter;

import com.elecciones.senado.results.context.city.domain.model.City;
import com.elecciones.senado.results.context.city.domain.port.CityRepository;
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
public class CityApiAdapter implements CityRepository {

    private RestTemplate restTemplate;
    private String apiColombiaUrl;

    private final ErrorMessages errorMessages = new ErrorMessages();

    @Override
    public List<City> findAll() throws NoResultsException, CommunicationErrorException {
        try {
            ResponseEntity<List<City>> response = restTemplate.exchange(
                    apiColombiaUrl + "/City",
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
    public Optional<City> findById(Long id) throws NoResultsException, CommunicationErrorException {
        try {
            ResponseEntity<City> response = restTemplate.exchange(
                    apiColombiaUrl + "/City/" + id,
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

    @Override
    public List<City> findByDepartment(Long id) throws NoResultsException, CommunicationErrorException {
        try {
            ResponseEntity<List<City>> response = restTemplate.exchange(
                    apiColombiaUrl + "/Department/" + id + "/cities",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {}
            );
            return response.getBody();
        } catch (Exception e) {
            throw new CommunicationErrorException(errorMessages.COMMUNICATION_ERROR);
        }
    }
}
