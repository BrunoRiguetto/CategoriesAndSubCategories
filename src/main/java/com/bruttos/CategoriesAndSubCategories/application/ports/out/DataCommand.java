package com.bruttos.CategoriesAndSubCategories.application.ports.out;

import com.bruttos.CategoriesAndSubCategories.application.ports.out.base.DataCommandQuery;

public interface DataCommand <T> extends DataCommandQuery {
    T save(T domain);

    void remove(T domain);

}
