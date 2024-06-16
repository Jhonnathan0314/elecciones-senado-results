package com.elecciones.senado.results.context.city.application.usecase;

import com.elecciones.senado.results.context.city.domain.model.City;
import com.elecciones.senado.results.context.city.domain.port.CityRepository;
import com.elecciones.senado.results.utils.constants.ErrorMessages;
import com.elecciones.senado.results.utils.exceptions.CommunicationErrorException;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindByDepartmentCityUseCase {

    private final CityRepository cityRepository;

    private final ErrorMessages errorMessages = new ErrorMessages();

    public List<City> findById(Long id) throws NoResultsException, CommunicationErrorException {
        List<City> cities = cityRepository.findByDepartment(id);
        if(cities.isEmpty()) throw new NoResultsException(errorMessages.NO_RESULTS);
        return cities;
    }

}