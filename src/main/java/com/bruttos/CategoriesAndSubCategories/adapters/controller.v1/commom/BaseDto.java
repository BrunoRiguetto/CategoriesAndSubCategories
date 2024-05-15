package com.bruttos.CategoriesAndSubCategories.adapters.controller.v1.commom;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class BaseDto {

    @JsonProperty("id") protected UUID id;

    public BaseDto() {
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}


