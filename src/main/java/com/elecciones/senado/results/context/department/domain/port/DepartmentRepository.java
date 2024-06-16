package com.elecciones.senado.results.context.department.domain.port;

import com.elecciones.senado.results.context.department.domain.model.Department;
import com.elecciones.senado.results.utils.exceptions.CommunicationErrorException;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository {

    List<Department> findAll() throws NoResultsException, CommunicationErrorException;
    Optional<Department> findById(Long id) throws NoResultsException, CommunicationErrorException;

}