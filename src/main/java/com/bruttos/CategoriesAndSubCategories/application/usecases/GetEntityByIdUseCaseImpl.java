package com.bruttos.CategoriesAndSubCategories.application.usecases;

import com.bruttos.CategoriesAndSubCategories.application.ports.in.commom.RepositoryMediator;
import com.bruttos.CategoriesAndSubCategories.application.ports.in.usecases.GetEntityByIdUseCase;
import com.bruttos.CategoriesAndSubCategories.application.ports.out.DataQuery;
import com.bruttos.CategoriesAndSubCategories.domain.exceptions.NotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetEntityByIdUseCaseImpl implements GetEntityByIdUseCase {

    private final RepositoryMediator mediator;

    public GetEntityByIdUseCaseImpl(RepositoryMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public <T> T execute(Class<T> clazz, UUID Id) throws NotFoundException, NoSuchMethodException, JsonProcessingException {

        var query = (DataQuery<T>) mediator.getQuery(clazz);
        var domain = query.getById(Id);

        if (domain == null){
            throw new NotFoundException(clazz, Id);
        }

        return domain;
    }
}
