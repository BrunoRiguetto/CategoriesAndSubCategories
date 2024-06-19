package com.bruttos.CategoriesAndSubCategories.application.ports.in.usecases;

import java.util.List;

public interface GetAllEntitiesUseCase {

    <T> List<T> execute(Class<T> clazz) throws NoSuchMethodException;

}
