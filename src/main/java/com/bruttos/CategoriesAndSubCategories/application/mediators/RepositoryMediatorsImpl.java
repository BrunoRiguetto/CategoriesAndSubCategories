package com.bruttos.CategoriesAndSubCategories.application.mediators;

import com.bruttos.CategoriesAndSubCategories.application.ports.in.commom.RepositoryMediator;
import com.bruttos.CategoriesAndSubCategories.application.ports.out.DataCommand;
import com.bruttos.CategoriesAndSubCategories.application.ports.out.DataQuery;
import com.bruttos.CategoriesAndSubCategories.application.ports.out.base.DataCommandQuery;
import com.bruttos.CategoriesAndSubCategories.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public class RepositoryMediatorsImpl implements RepositoryMediator {

    private final HashMap<Class, DataCommandQuery> queries = new HashMap<>();
    private final HashMap<Class, DataCommandQuery> commands = new HashMap<>();

    public RepositoryMediatorsImpl(
            @Autowired DataQuery<Category> categoryQuery,
            @Autowired DataCommand<Category> categoryCommand) {

        queries.put((Class) Category.class, (DataCommandQuery) categoryQuery);

        commands.put(Category.class, categoryCommand);
    }

    @Override
    public <T> DataQuery<T> getQuery(Class<T> clazz) throws NoSuchMethodException {
        return (DataQuery) get(clazz, queries);
    }

    @Override
    public <T> DataCommand<T> getCommand(Class<T> clazz) throws NoSuchMethodException {
        return (DataCommand) get(clazz, commands);
    }

    private<T> T get(Class<T> clazz, HashMap<Class, DataCommandQuery> services) throws NoSuchMethodException {

        var repository = services.get(clazz);
        if (repository == null) {
            throw new NoSuchMethodException("There is no repository provider.");
        }
        return (T) repository;
    }
}
