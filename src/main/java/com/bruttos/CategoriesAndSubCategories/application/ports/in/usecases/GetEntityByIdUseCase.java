package com.bruttos.CategoriesAndSubCategories.application.ports.in.usecases;

import com.bruttos.CategoriesAndSubCategories.domain.exceptions.NotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.UUID;

public interface GetEntityByIdUseCase {

    <T> T execute(Class<T> clazz, UUID Id) throws NotFoundException, NoSuchMethodException, JsonProcessingException;
}
