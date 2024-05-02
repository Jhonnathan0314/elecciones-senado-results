package com.elecciones.senado.results.context.result.domain.port;

import com.elecciones.senado.results.context.result.domain.model.Result;

import java.util.List;
import java.util.Optional;

public interface ResultRepository {

    List<Result> findAll();
    Optional<Result> findById(Long id);
    Result create(Result result);
    Result update(Result result);
    void deleteById(Long id);

}
