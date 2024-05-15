package com.bruttos.CategoriesAndSubCategories.application.ports.in.usecases;

import com.bruttos.CategoriesAndSubCategories.domain.Category;

public interface CreateCategoryUseCase {

    Category execute(Category category) throws NoSuchMethodException;
}
