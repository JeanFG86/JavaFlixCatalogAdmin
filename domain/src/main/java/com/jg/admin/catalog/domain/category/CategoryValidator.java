package com.jg.admin.catalog.domain.category;

import com.jg.admin.catalog.domain.validation.ValidationHandler;
import com.jg.admin.catalog.domain.validation.Validator;

public class CategoryValidator extends Validator {

    private final Category category;
    public CategoryValidator(final Category aCategory, final ValidationHandler aHandler) {
        super(aHandler);
        this.category = aCategory;
    }

    @Override
    public void validate() {

    }
}
