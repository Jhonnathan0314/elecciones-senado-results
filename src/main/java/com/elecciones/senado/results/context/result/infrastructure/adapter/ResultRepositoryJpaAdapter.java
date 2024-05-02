package com.elecciones.senado.results.context.result.infrastructure.adapter;

import com.elecciones.senado.results.context.result.domain.model.Result;
import com.elecciones.senado.results.context.result.domain.port.ResultRepository;
import com.elecciones.senado.results.context.result.infrastructure.mappers.ResultMapper;
import com.elecciones.senado.results.context.result.infrastructure.persistence.ResultEntity;
import com.elecciones.senado.results.context.result.infrastructure.persistence.ResultJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ResultRepositoryJpaAdapter implements ResultRepository {

    private final ResultJpaRepository resultJpaRepository;
    private final ResultMapper mapper = new ResultMapper();

    @Override
    public List<Result> findAll() {
        List<ResultEntity> resultEntities = resultJpaRepository.findAll();
        return mapper.entitiesToModels(resultEntities);
    }

    @Override
    public Optional<Result> findById(Long id) {
        Optional<ResultEntity> optionalResultEntity = resultJpaRepository.findById(id);
        return optionalResultEntity.map(mapper::entityToModel);
    }

    @Override
    public Result create(Result result) {
        ResultEntity resultEntity = resultJpaRepository.save(mapper.modelToEntity(result));
        return mapper.entityToModel(resultEntity);
    }

    @Override
    public Result update(Result result) {
        ResultEntity resultEntity = resultJpaRepository.save(mapper.modelToEntity(result));
        return mapper.entityToModel(resultEntity);
    }

    @Override
    public void deleteById(Long id) {
        resultJpaRepository.deleteById(id);
    }
}
