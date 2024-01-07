package com.jg.admin.catalog.application.category.update;

import com.jg.admin.catalog.application.category.create.CreateCategoryOutput;
import com.jg.admin.catalog.domain.category.Category;
import com.jg.admin.catalog.domain.category.CategoryID;

public record UpdateCategoryOutput(CategoryID id) {
    public static UpdateCategoryOutput from(final Category aCategory){
        return new UpdateCategoryOutput(aCategory.getId());
    }
}
