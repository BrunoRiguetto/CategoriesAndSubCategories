package com.bruttos.CategoriesAndSubCategories.application.usecases;

import com.bruttos.CategoriesAndSubCategories.application.ports.in.commom.RepositoryMediator;
import com.bruttos.CategoriesAndSubCategories.application.ports.in.usecases.CreateEntityUseCase;
import com.bruttos.CategoriesAndSubCategories.domain.Category;
import com.bruttos.CategoriesAndSubCategories.domain.commom.BaseDomain;
import org.springframework.stereotype.Service;

@Service
public class CreateEntityUseCaseImpl implements CreateEntityUseCase {

    protected final RepositoryMediator mediator;

    public CreateEntityUseCaseImpl(RepositoryMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public<T> T execute(Class<T> clazz, BaseDomain domain) throws NoSuchMethodException {
        var command = mediator.getCommand(clazz);
        return command.save((T) domain);
    }
}
