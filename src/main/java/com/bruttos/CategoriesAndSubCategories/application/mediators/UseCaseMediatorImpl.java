package com.bruttos.CategoriesAndSubCategories.application.mediators;

import com.bruttos.CategoriesAndSubCategories.application.ports.in.commom.UseCaseMediator;
import com.bruttos.CategoriesAndSubCategories.application.ports.in.usecases.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class UseCaseMediatorImpl implements UseCaseMediator {

    private HashMap<Class, Object> useCases = new HashMap<>();

    public UseCaseMediatorImpl(
            @Autowired CreateEntityUseCase createCategoryUseCase,
            @Autowired GetAllEntitiesUseCase getAllEntitiesUseCase,
            @Autowired GetEntityByIdUseCase getEntityByIdUseCaseImpl,
            @Autowired RemoveEntityUseCase removeEntityUseCase,
            @Autowired UpdateEntityUseCase updateEntityUseCase
            ){
        useCases.put(CreateEntityUseCase.class, createCategoryUseCase);
        useCases.put(GetAllEntitiesUseCase.class, getAllEntitiesUseCase);
        useCases.put(GetEntityByIdUseCase.class, getEntityByIdUseCaseImpl);
        useCases.put(RemoveEntityUseCase.class, removeEntityUseCase);
        useCases.put(UpdateEntityUseCase.class, updateEntityUseCase);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> clazz) throws NoSuchMethodException {

        var useCase = (T) useCases.get(clazz);
        if(useCase == null){
            throw new NoSuchMethodException("There is no use case provider");
        }
        return useCase;
    }
}