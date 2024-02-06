package com.jg.admin.catalog.infrastructure.category;

import com.jg.admin.catalog.domain.category.Category;
import com.jg.admin.catalog.domain.category.CategoryGateway;
import com.jg.admin.catalog.domain.category.CategoryID;
import com.jg.admin.catalog.domain.category.CategorySearchQuery;
import com.jg.admin.catalog.domain.pagination.Pagination;
import com.jg.admin.catalog.infrastructure.category.persistence.CategoryJpaEntity;
import com.jg.admin.catalog.infrastructure.category.persistence.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryMySQLGateway implements CategoryGateway {
    private final CategoryRepository repository;

    public CategoryMySQLGateway(final CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category create(final Category aCategory) {
        return save(aCategory);
    }

    @Override
    public void deleteById(CategoryID anId) {
        final String anIdValue = anId.getValue();
        if(this.repository.existsById(anIdValue)){
            this.repository.deleteById(anIdValue);
        }
    }

    @Override
    public Optional<Category> findById(CategoryID anId) {
        return this.repository.findById(anId.getValue()).map(CategoryJpaEntity::toAggregate);
    }

    @Override
    public Category update(final Category aCategory) {
        return save(aCategory);
    }

    @Override
    public Pagination<Category> findAll(CategorySearchQuery aQuery) {
        return null;
    }

    private Category save(final Category aCategory){
        return this.repository.save(CategoryJpaEntity.from(aCategory)).toAggregate();
    }
}
