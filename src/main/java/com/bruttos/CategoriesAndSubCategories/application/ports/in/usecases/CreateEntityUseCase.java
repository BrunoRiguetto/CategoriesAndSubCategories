package com.bruttos.CategoriesAndSubCategories.application.ports.in.usecases;

import com.bruttos.CategoriesAndSubCategories.domain.commom.BaseDomain;

public interface CreateEntityUseCase {

    <T> T execute(Class<T> clazz, BaseDomain domain) throws NoSuchMethodException;
}
