package com.bruttos.CategoriesAndSubCategories.application.ports.out;

import com.bruttos.BankAndAccountService.application.ports.out.base.DataCommandQuery;

import java.util.List;
import java.util.UUID;

public interface DataQuery<T> extends DataCommandQuery {
    List<T> getAll();
    T getById(UUID id);
}
