package com.bruttos.CategoriesAndSubCategories.adapters.repositories.data;

import com.bruttos.CategoriesAndSubCategories.adapters.repositories.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryData extends JpaRepository<CategoryEntity, UUID> {
}
