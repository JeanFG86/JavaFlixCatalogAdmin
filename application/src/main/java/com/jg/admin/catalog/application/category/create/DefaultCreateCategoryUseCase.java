package com.jg.admin.catalog.application.category.create;

import com.jg.admin.catalog.domain.category.Category;
import com.jg.admin.catalog.domain.category.CategoryGateway;
import com.jg.admin.catalog.domain.validation.handler.Notification;
import com.jg.admin.catalog.domain.validation.handler.ThrowsValidationHandler;
import io.vavr.control.Either;

import java.util.Objects;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase{

    private final CategoryGateway categoryGateway;

    public DefaultCreateCategoryUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public Either<Notification, CreateCategoryOutput> execute(final CreateCategoryCommand aCommand) {
        final var aName = aCommand.name();
        final var aDescription = aCommand.description();
        final var isActive = aCommand.isActive();

        final var notification = Notification.create();
        final var aCategory = Category.newCategory(aName, aDescription, isActive);
        aCategory.validate(notification);

        if(notification.hasError()){

        }

        return CreateCategoryOutput.from(this.categoryGateway.create(aCategory));
    }
}
