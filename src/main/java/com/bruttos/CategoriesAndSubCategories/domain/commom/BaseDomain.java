package com.bruttos.CategoriesAndSubCategories.domain.commom;

import java.util.UUID;

public abstract class BaseDomain {
    private UUID id;

    public BaseDomain(UUID id) {
        setId(id);
    }

    public BaseDomain() {

    }

    public <T> T getId() {
        return (T) id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}

