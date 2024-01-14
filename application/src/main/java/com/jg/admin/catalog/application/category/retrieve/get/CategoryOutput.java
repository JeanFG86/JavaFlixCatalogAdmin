package com.jg.admin.catalog.application.category.retrieve.get;

import com.jg.admin.catalog.domain.category.Category;
import com.jg.admin.catalog.domain.category.CategoryID;

import java.time.Instant;

public record CategoryOutput(
        CategoryID id,
        String name,
        String description,
        boolean isActive,
        Instant createdAt,
        Instant updateAt,
        Instant deletedAt
) {

    public static CategoryOutput from(final Category aCategory){
        return new CategoryOutput(
                aCategory.getId(),
                aCategory.getName(),
                aCategory.getDescription(),
                aCategory.isActive(),
                aCategory.getCreatedAt(),
                aCategory.getUpdatedAt(),
                aCategory.getDeletedAt()
                );
    }
}
