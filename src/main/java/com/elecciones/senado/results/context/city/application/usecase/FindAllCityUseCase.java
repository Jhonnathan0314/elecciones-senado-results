package com.elecciones.senado.results.context.city.application.usecase;

import com.elecciones.senado.results.context.city.domain.model.City;
import com.elecciones.senado.results.context.city.domain.port.CityRepository;
import com.elecciones.senado.results.utils.exceptions.CommunicationErrorException;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllCityUseCase {

    private final CityRepository cityRepository;

    public List<City> findAll() throws NoResultsException, CommunicationErrorException {
        return cityRepository.findAll();
    }

}