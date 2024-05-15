package com.bruttos.CategoriesAndSubCategories.application.ports.out.category;

import com.bruttos.CategoriesAndSubCategories.application.ports.out.DataQuery;
import com.bruttos.CategoriesAndSubCategories.domain.Category;

import java.util.UUID;

public interface CategoryDataQuery extends DataQuery<Category> {

    //boolean existsAccountByBankId(UUID bankId);
}
