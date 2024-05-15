package com.bruttos.CategoriesAndSubCategories.domain;

import com.bruttos.CategoriesAndSubCategories.domain.commom.BaseDomain;

import java.util.Objects;
import java.util.UUID;

public class Category extends BaseDomain {

    private String categoryName;
    private String description;

    public Category(){
        super();
    }

    public Category(UUID id, String categoryName, String description) {
        super(id);
        this.categoryName = categoryName;
        this.description = description;
    }

    public Category(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryName.equals(category.categoryName) && description.equals(category.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName, description);
    }
}
