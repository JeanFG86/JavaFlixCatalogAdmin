package com.jg.admin.catalog.application.category.update;

import com.jg.admin.catalog.application.UseCase;
import com.jg.admin.catalog.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdateCategoryUseCase extends UseCase<UpdateCategoryCommand, Either<Notification, UpdateCategoryOutput>> {
}
