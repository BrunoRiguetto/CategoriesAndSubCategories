package com.bruttos.CategoriesAndSubCategories.adapters.controller.v1.mappers;

import com.bruttos.CategoriesAndSubCategories.adapters.controller.v1.model.CategoryDto;
import com.bruttos.CategoriesAndSubCategories.adapters.controller.v1.model.CategoryDtoEntry;
import com.bruttos.CategoriesAndSubCategories.domain.Category;

import java.util.List;

public class CategoryDtoMapper {

    public static Category toDomain(CategoryDto categoryRequest){

        return new Category(
                categoryRequest.getId(),
                categoryRequest.getCategoryName(),
                categoryRequest.getDescription()
        );
    }

    public static Category toDomainEntry(CategoryDtoEntry categoryRequest){

        return new Category(
                categoryRequest.getCategoryName(),
                categoryRequest.getDescription()
        );
    }

    public static CategoryDto fromDomain(Category category){

        var categoryDto = new CategoryDto(
                category.getCategoryName(),
                category.getDescription()
        );

        categoryDto.setId(category.getId());

        return categoryDto;
    }

    public static CategoryDto[] fromDomain(List<Category> categoryList){

        return categoryList.stream()
                .map(CategoryDtoMapper::fromDomain)
                .toArray(CategoryDto[]::new);
    }
}
