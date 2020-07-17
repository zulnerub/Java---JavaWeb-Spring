package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.model.entity.CategoryName;
import softuni.exam.model.entity.Product;
import softuni.exam.model.view.ProductViewModel;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    List<ProductViewModel> findAllByCategory_CategoryName(CategoryName category);
}
