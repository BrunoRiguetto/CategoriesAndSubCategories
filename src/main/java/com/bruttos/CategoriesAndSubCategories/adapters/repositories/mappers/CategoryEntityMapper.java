package com.bruttos.CategoriesAndSubCategories.adapters.repositories.mappers;

import com.bruttos.CategoriesAndSubCategories.adapters.repositories.entities.CategoryEntity;
import com.bruttos.CategoriesAndSubCategories.domain.Category;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryEntityMapper {

    public static Category toDomain(CategoryEntity categoryEntity){

        if(categoryEntity == null)
            return null;

        return new Category(
                categoryEntity.getCategoryId(),
                categoryEntity.getCategoryName(),
                categoryEntity.getDescription()
        );
    }

    public static List<Category> toDomain(List<CategoryEntity> categoryEntities){

        if (categoryEntities == null)
            return Collections.emptyList();

        return categoryEntities.stream()
                .map(CategoryEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    public static CategoryEntity fromDomain(Category category){

        if (category == null)
            return null;

        return new CategoryEntity(
                category.getId(),
                category.getCategoryName(),
                category.getDescription()
        );
    }
}
