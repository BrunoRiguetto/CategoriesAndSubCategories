package com.bruttos.CategoriesAndSubCategories.application.usecases;

import com.bruttos.CategoriesAndSubCategories.application.ports.in.commom.RepositoryMediator;
import com.bruttos.CategoriesAndSubCategories.application.ports.in.usecases.CreateCategoryUseCase;
import com.bruttos.CategoriesAndSubCategories.domain.Category;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {

    protected final RepositoryMediator mediator;

    public CreateCategoryUseCaseImpl(RepositoryMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public Category execute(Category category) throws NoSuchMethodException {
        var command = mediator.getCommand(category);
        return command.save(category);
    }
}
