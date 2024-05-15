package com.bruttos.CategoriesAndSubCategories.adapters.controller.v1;

import com.bruttos.CategoriesAndSubCategories.adapters.controller.v1.mappers.CategoryDtoMapper;
import com.bruttos.CategoriesAndSubCategories.adapters.controller.v1.model.CategoryDto;
import com.bruttos.CategoriesAndSubCategories.adapters.controller.v1.model.CategoryDtoEntry;
import com.bruttos.CategoriesAndSubCategories.application.ports.in.commom.UseCaseMediator;
import com.bruttos.CategoriesAndSubCategories.application.ports.in.usecases.CreateCategoryUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        var useCase = mediator.get(CreateCategoryUseCase.class);
        var createdCategory = useCase.execute(category);

        return CategoryDtoMapper.fromDomain(createdCategory);
    }
}
