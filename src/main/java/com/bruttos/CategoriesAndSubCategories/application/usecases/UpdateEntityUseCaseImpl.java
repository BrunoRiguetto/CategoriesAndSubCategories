package com.bruttos.CategoriesAndSubCategories.application.usecases;

import com.bruttos.CategoriesAndSubCategories.application.ports.in.commom.RepositoryMediator;
import com.bruttos.CategoriesAndSubCategories.application.ports.in.usecases.UpdateEntityUseCase;
import com.bruttos.CategoriesAndSubCategories.application.ports.out.DataCommand;
import com.bruttos.CategoriesAndSubCategories.application.ports.out.DataQuery;
import com.bruttos.CategoriesAndSubCategories.domain.commom.BaseDomain;
import com.bruttos.CategoriesAndSubCategories.domain.exceptions.UpdateException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateEntityUseCaseImpl implements UpdateEntityUseCase {

    private final RepositoryMediator mediator;

    public UpdateEntityUseCaseImpl(RepositoryMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public <T> T execute(Class<T> clazz, BaseDomain domain, UUID Id) throws NoSuchMethodException {

        var query = (DataQuery<T>) mediator.getQuery(clazz);
        var command = (DataCommand<T>) mediator.getCommand(clazz);

        var persist = query.getById(Id);

        if(persist == null){
            throw new UpdateException(clazz, Id);
        }
        domain.setId(Id);

        return command.save((T) domain);
    }
}
