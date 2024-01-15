package com.jg.admin.catalog.application.category.retrieve.list;

import com.jg.admin.catalog.application.UseCase;
import com.jg.admin.catalog.domain.category.CategorySearchQuery;
import com.jg.admin.catalog.domain.pagination.Pagination;

public abstract class ListCategoriesUseCase extends UseCase<CategorySearchQuery, Pagination<CategoryListOutput>> {
}
