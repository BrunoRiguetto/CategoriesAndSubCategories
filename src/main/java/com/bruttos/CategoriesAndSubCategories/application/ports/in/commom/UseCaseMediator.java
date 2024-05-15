package com.bruttos.CategoriesAndSubCategories.application.ports.in.commom;

public interface UseCaseMediator {

    <T> T get(Class<T> clazz) throws NoSuchMethodException;
}
