package com.jg.admin.catalog.application.category.retrieve;

import com.jg.admin.catalog.domain.category.Category;
import com.jg.admin.catalog.domain.category.CategoryGateway;
import com.jg.admin.catalog.domain.category.CategoryID;
import com.jg.admin.catalog.domain.exceptions.DomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GetCategoryByIdUseCaseTest {

    @InjectMocks
    private DefaultGetCategoryByIdUseCasee useCase;

    @Mock
    private CategoryGateway categoryGateway;

    @BeforeEach
    void cleanUp(){
        reset(categoryGateway);
    }

    @Test
    public void givenAValidId_whenCallsGetCategory_shouldReturnCategory(){
        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedIsActive = true;

        final var aCategory = Category.newCategory(expectedName, expectedDescription, expectedIsActive);
        final var expectedId = aCategory.getId();

        when(categoryGateway.findById(eq(expectedId))).thenReturn(Optional.of(aCategory.clone()));

        final var actualCategory = useCase.execute(expectedId.getValue());

        Assertions.assertEquals(expectedId, actualCategory.id());
        Assertions.assertEquals(expectedName, actualCategory.name());
        Assertions.assertEquals(expectedDescription, actualCategory.description());
        Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
        Assertions.assertEquals(actualCategory.getCreatedAt(), actualCategory.createdAt());
        Assertions.assertEquals(actualCategory.getUpdateddAt(), actualCategory.updatedAt());
        Assertions.assertEquals(actualCategory.getDeleteddAt(), actualCategory.deletedAt());
    }

    @Test
    public void givenAInvalidId_whenCallsGetCategory_shouldReturnNotFound(){
        final var expectedErrorMessage = "";
        final var expectedId = CategoryID.from("123");

        when(categoryGateway.findById(eq(expectedId))).thenReturn(Optional.empty());

        final var actualException = Assertions.assertThrows(DomainException.class, () -> useCase.execute(expectedId.getValue()));

        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());
    }

    @Test
    public void givenAValidId_whenGatewayThrowsException_shouldReturnException(){
        final var expectedErrorMessage = "Gateway error";
        final var expectedId = CategoryID.from("123");

        when(categoryGateway.findById(eq(expectedId))).thenThrow(new IllegalStateException(expectedErrorMessage));

        final var actualException = Assertions.assertThrows(IllegalStateException.class, () -> useCase.execute(expectedId.getValue()));

        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());
    }
}
