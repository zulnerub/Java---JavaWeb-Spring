package softuni.exam.service;

import softuni.exam.model.entity.CategoryName;
import softuni.exam.model.service.CategoryServiceModel;

import java.util.Optional;

public interface CategoryService {
    void initCategories();

    CategoryServiceModel findByCategoryName(CategoryName categoryName);
}
