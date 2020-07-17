package softuni.exam.model.service;

import softuni.exam.model.entity.CategoryName;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

public class CategoryServiceModel {
    private CategoryName categoryName;
    private String description;

    public CategoryServiceModel(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    @Enumerated
    @NotNull
    public CategoryName getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
