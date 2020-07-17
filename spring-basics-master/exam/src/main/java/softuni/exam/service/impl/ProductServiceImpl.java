package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import softuni.exam.model.entity.Category;
import softuni.exam.model.entity.CategoryName;
import softuni.exam.model.entity.Product;
import softuni.exam.model.service.CategoryServiceModel;
import softuni.exam.model.service.ProductServiceModel;
import softuni.exam.model.view.ProductViewModel;
import softuni.exam.repository.ProductRepository;
import softuni.exam.service.CategoryService;
import softuni.exam.service.ProductService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) {
        CategoryServiceModel categoryServiceModel =
                this.categoryService.findByCategoryName(
                        productServiceModel.getCategory().getCategoryName()
                );

        productServiceModel.setCategory(categoryServiceModel);

        this.productRepository.saveAndFlush(this.modelMapper.map(productServiceModel, Product.class));
    }

    @Override
    public BigDecimal totalPriceAllProducts() {
        BigDecimal total = new BigDecimal("0");

        this.productRepository.findAll()
                .forEach(product -> total.add(product.getPrice()));

        return total;
    }

    @Override
    public void delete(String id) {
        this.productRepository.deleteById(id);
    }



    @Override
    public List<ProductViewModel> findAllFoodProducts() {
        return this.productRepository.findAllByCategory_CategoryName(CategoryName.FOOD);
    }

    @Override
    public List<ProductViewModel> findAllHouseholdProducts() {
        return this.productRepository.findAllByCategory_CategoryName(CategoryName.HOUSEHOLD);
    }

    @Override
    public List<ProductViewModel> findAllDrinkProducts() {
        return this.productRepository.findAllByCategory_CategoryName(CategoryName.DRINK);
    }
    @Override
    public List<ProductViewModel> findAllOtherProducts() {
        return this.productRepository.findAllByCategory_CategoryName(CategoryName.OTHER);
    }
}
