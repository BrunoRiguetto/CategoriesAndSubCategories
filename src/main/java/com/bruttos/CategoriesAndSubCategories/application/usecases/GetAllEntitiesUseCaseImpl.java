package com.bruttos.CategoriesAndSubCategories.application.usecases;

import com.bruttos.CategoriesAndSubCategories.application.ports.in.commom.RepositoryMediator;
import com.bruttos.CategoriesAndSubCategories.application.ports.in.usecases.GetAllEntitiesUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllEntitiesUseCaseImpl implements GetAllEntitiesUseCase {

    private final RepositoryMediator mediator;

    public GetAllEntitiesUseCaseImpl(RepositoryMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public <T> List<T> execute(Class<T> clazz) throws NoSuchMethodException {

        return mediator.getQuery(clazz).getAll();
    }
}
