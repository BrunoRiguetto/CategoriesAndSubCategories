package com.bruttos.CategoriesAndSubCategories.application.ports.in.usecases;

import com.bruttos.CategoriesAndSubCategories.domain.commom.BaseDomain;

import java.util.UUID;

public interface UpdateEntityUseCase {

    <T> T execute(Class<T> clazz, BaseDomain domain, UUID Id) throws NoSuchMethodException;

}
