package com.elecciones.senado.results.context.department.application.usecase;

import com.elecciones.senado.results.context.department.domain.model.Department;
import com.elecciones.senado.results.context.department.domain.port.DepartmentRepository;
import com.elecciones.senado.results.utils.exceptions.CommunicationErrorException;
import com.elecciones.senado.results.utils.exceptions.NoResultsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindByIdDepartmentUseCase {

    private final DepartmentRepository departmentRepository;

    public Department findById(Long id) throws NoResultsException, CommunicationErrorException {
        return departmentRepository.findById(id).get();
    }

}