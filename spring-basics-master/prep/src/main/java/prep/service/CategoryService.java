package prep.service;


import prep.model.entity.CategoryName;
import prep.model.service.CategoryServiceModel;

public interface CategoryService{
    void initCategories();

    CategoryServiceModel findByCategoryName(CategoryName categoryName);
}
