package com.bruttos.CategoriesAndSubCategories.adapters.controller.v1;

import com.bruttos.CategoriesAndSubCategories.adapters.controller.v1.mappers.CategoryDtoMapper;
import com.bruttos.CategoriesAndSubCategories.adapters.controller.v1.model.CategoryDto;
import com.bruttos.CategoriesAndSubCategories.adapters.controller.v1.model.CategoryDtoEntry;
import com.bruttos.CategoriesAndSubCategories.application.ports.in.commom.UseCaseMediator;
import com.bruttos.CategoriesAndSubCategories.application.ports.in.usecases.*;
import com.bruttos.CategoriesAndSubCategories.domain.Category;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final UseCaseMediator mediator;

    public CategoryController(UseCaseMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CategoryDto createCategory(@RequestBody CategoryDtoEntry categoryRequest)
            throws NoSuchMethodException {

        var category = CategoryDtoMapper.toDomainEntry(categoryRequest);
        var createdCategory = mediator
                .get(CreateEntityUseCase.class)
                .execute(Category.class, category);

        return CategoryDtoMapper.fromDomain(createdCategory);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public CategoryDto[] getAllCategories() throws NoSuchMethodException{

        var category = mediator
                .get(GetAllEntitiesUseCase.class)
                .execute(Category.class);

        return CategoryDtoMapper.fromDomain(category);
    }

    @GetMapping("/category-id")
    @ResponseStatus(value = HttpStatus.OK)
    public CategoryDto getCategoryById(@RequestParam ("category-id") UUID categoryId)
        throws NoSuchMethodException, JsonProcessingException {

        var category = mediator
                .get(GetEntityByIdUseCase.class)
                .execute(Category.class, categoryId);

        return CategoryDtoMapper.fromDomain(category);
    }

    @DeleteMapping("/category-id")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeCategory(@RequestParam ("category-id") UUID categoryId)
            throws NoSuchMethodException {

        mediator.get(RemoveEntityUseCase.class)
                .execute(Category.class, categoryId);

    }

    @PutMapping("/category-id")
    @ResponseStatus(value = HttpStatus.OK)
    public CategoryDto updateCategory(@RequestParam ("category-id") UUID categoryId,
                                    @RequestBody CategoryDtoEntry categoryRequest)
            throws NoSuchMethodException{

        var category = CategoryDtoMapper.toDomainEntry(categoryRequest);
        var createdCategory = mediator
                .get(UpdateEntityUseCase.class)
                .execute(Category.class, category, categoryId);

        return CategoryDtoMapper.fromDomain(createdCategory);
    }
}
