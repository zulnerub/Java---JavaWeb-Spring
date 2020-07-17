package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.model.entity.Category;
import softuni.exam.model.entity.CategoryName;
import softuni.exam.model.service.CategoryServiceModel;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findByCategoryName(CategoryName categoryName);
}
