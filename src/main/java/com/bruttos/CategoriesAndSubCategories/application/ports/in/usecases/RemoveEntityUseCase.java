package com.bruttos.CategoriesAndSubCategories.application.ports.in.usecases;

import java.util.UUID;

public interface RemoveEntityUseCase {

    <T> void execute(Class<T> clazz, UUID id) throws NoSuchMethodException;
}
