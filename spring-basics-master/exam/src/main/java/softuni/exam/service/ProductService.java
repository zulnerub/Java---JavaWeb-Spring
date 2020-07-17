package softuni.exam.service;

import softuni.exam.model.service.ProductServiceModel;
import softuni.exam.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void addProduct(ProductServiceModel productServiceModel);

    BigDecimal totalPriceAllProducts();

    void delete(String id);

    List<ProductViewModel> findAllFoodProducts();
    List<ProductViewModel> findAllDrinkProducts();
    List<ProductViewModel> findAllHouseholdProducts();
    List<ProductViewModel> findAllOtherProducts();
}
