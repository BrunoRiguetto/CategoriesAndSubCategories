package com.bruttos.CategoriesAndSubCategories.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Search return is empty")
public class NotFoundException extends RuntimeException {

    public NotFoundException(Class<? extends Object> domainClass, UUID id) {
        super(String.format("%s with id = %s can not be found", domainClass.getSimpleName(), id));
    }
}
