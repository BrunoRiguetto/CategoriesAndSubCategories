package com.bruttos.CategoriesAndSubCategories.application.usecases;

import com.bruttos.CategoriesAndSubCategories.application.ports.in.commom.RepositoryMediator;
import com.bruttos.CategoriesAndSubCategories.application.ports.in.usecases.RemoveEntityUseCase;
import com.bruttos.CategoriesAndSubCategories.domain.Category;
import com.bruttos.CategoriesAndSubCategories.domain.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RemoveEntityUseCaseImpl implements RemoveEntityUseCase {

    private final RepositoryMediator mediator;

    public RemoveEntityUseCaseImpl(RepositoryMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public <T> void execute(Class<T> clazz, UUID Id) throws NoSuchMethodException {
        var query = mediator.getQuery(clazz);
        var command = mediator.getCommand(clazz);

        var persistedEntity = query.getById(Id);

        if (persistedEntity == null){
            throw new NotFoundException(clazz, Id);
        }

        command.remove(persistedEntity);
    }
}
