package com.jg.admin.catalog.application.category.create;

import com.jg.admin.catalog.application.UseCase;
import com.jg.admin.catalog.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class CreateCategoryUseCase extends UseCase<CreateCategoryCommand, Either<Notification, CreateCategoryOutput>> {
}
