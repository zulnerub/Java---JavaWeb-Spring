package prep.model.service;

import prep.model.entity.Category;
import prep.model.entity.GenderName;

import java.math.BigDecimal;

public class ItemServiceModel extends BaseServiceModel {
    private String name;
    private String description;
    private BigDecimal price;
    private GenderName gender;
    private CategoryServiceModel category;

    public ItemServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public GenderName getGender() {
        return gender;
    }

    public void setGender(GenderName gender) {
        this.gender = gender;
    }

    public CategoryServiceModel getCategory() {
        return category;
    }

    public void setCategory(CategoryServiceModel category) {
        this.category = category;
    }
}
