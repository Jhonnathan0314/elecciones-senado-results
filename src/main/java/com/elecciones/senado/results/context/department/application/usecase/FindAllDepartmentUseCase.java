package com.elecciones.senado.results.context.department.application.usecase;

import com.elecciones.senado.results.context.department.domain.model.Department;
import com.elecciones.senado.results.context.department.domain.port.DepartmentRepository;
import com.elecciones.senado.results.utils.exceptions.CommunicationErrorException;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllDepartmentUseCase {

    private final DepartmentRepository departmentRepository;

    public List<Department> findAll() throws NoResultsException, CommunicationErrorException {
        return departmentRepository.findAll();
    }

}