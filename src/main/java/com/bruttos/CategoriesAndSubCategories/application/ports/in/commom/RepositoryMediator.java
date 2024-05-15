package com.bruttos.CategoriesAndSubCategories.application.ports.in.commom;

import com.bruttos.CategoriesAndSubCategories.application.ports.out.DataCommand;
import com.bruttos.CategoriesAndSubCategories.application.ports.out.DataQuery;

public interface RepositoryMediator {

    <T> DataQuery<T> getQuery(Class<T> clazz) throws NoSuchMethodException;

    <T> DataCommand<T> getCommand(Class<T> clazz) throws NoSuchMethodException;
}
