package com.bruttos.CategoriesAndSubCategories.adapters.repositories;

import com.bruttos.CategoriesAndSubCategories.adapters.repositories.data.CategoryData;
import com.bruttos.CategoriesAndSubCategories.adapters.repositories.mappers.CategoryEntityMapper;
import com.bruttos.CategoriesAndSubCategories.application.ports.out.DataCommand;
import com.bruttos.CategoriesAndSubCategories.application.ports.out.DataQuery;
import com.bruttos.CategoriesAndSubCategories.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CategoryRepository implements DataQuery<Category>, DataCommand<Category> {

    private CategoryData categoryData;

    public CategoryRepository(CategoryData categoryData) {
        this.categoryData = categoryData;
    }

    @Override
    public Category save(Category category){

        var categoryEntity = CategoryEntityMapper.fromDomain(category);
        categoryData.save(categoryEntity);
        category.setId(categoryEntity.getCategoryId());

        return category;
    }

    @Override
    public void remove(Category category){

        var categoryEntity = CategoryEntityMapper.fromDomain(category);

        categoryData.delete(categoryEntity);
    }

    @Override
    public List<Category> getAll(){

        var categoryReleaseEntities = categoryData.findAll();

        return CategoryEntityMapper.toDomain(categoryReleaseEntities);
    }

    @Override
    public Category getById(UUID id){

        var optCategoryEntity = categoryData.findById(id);

        return optCategoryEntity
                .map(CategoryEntityMapper::toDomain)
                .orElse(null);
    }
}
