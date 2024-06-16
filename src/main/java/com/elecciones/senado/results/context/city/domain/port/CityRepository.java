package com.elecciones.senado.results.context.city.domain.port;

import com.elecciones.senado.results.context.city.domain.model.City;
import com.elecciones.senado.results.utils.exceptions.CommunicationErrorException;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;

import java.util.List;
import java.util.Optional;

public interface CityRepository {

    List<City> findAll() throws NoResultsException, CommunicationErrorException;
    Optional<City> findById(Long id) throws NoResultsException, CommunicationErrorException;
    List<City> findByDepartment(Long id) throws NoResultsException, CommunicationErrorException;

}