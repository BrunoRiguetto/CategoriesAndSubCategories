package com.bruttos.CategoriesAndSubCategories.adapters.controller.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class CategoryDtoEntry {

    @JsonProperty("categoryName")private String categoryName;
    @JsonProperty("description")private String description;

    public CategoryDtoEntry() {
    }

    public CategoryDtoEntry(String categoryName, String description) {
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
        CategoryDtoEntry that = (CategoryDtoEntry) o;
        return categoryName.equals(that.categoryName) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName, description);
    }
}
