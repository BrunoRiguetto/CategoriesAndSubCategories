package com.bruttos.CategoriesAndSubCategories.application.mediators;

import com.bruttos.CategoriesAndSubCategories.application.ports.in.commom.UseCaseMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class UseCaseMediatorImpl implements UseCaseMediator {

    private HashMap<Class, Object> useCases = new HashMap<>();

    public UseCaseMediatorImpl(

    ){

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