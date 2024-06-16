package com.elecciones.senado.results.context.city.application.usecase;

import com.elecciones.senado.results.context.city.domain.model.City;
import com.elecciones.senado.results.context.city.domain.port.CityRepository;
import com.elecciones.senado.results.utils.exceptions.CommunicationErrorException;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindByIdCityUseCase {

    private final CityRepository cityRepository;

    public City findById(Long id) throws NoResultsException, CommunicationErrorException {
        return cityRepository.findById(id).get();
    }

}