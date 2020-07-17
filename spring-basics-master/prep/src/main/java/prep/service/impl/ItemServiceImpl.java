package prep.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import prep.model.entity.Item;
import prep.model.service.CategoryServiceModel;
import prep.model.service.ItemServiceModel;
import prep.model.view.ItemViewModel;
import prep.repository.ItemRepository;
import prep.service.CategoryService;
import prep.service.ItemService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ItemServiceImpl(ItemRepository itemRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void addItem(ItemServiceModel itemServiceModel) {
        CategoryServiceModel categoryServiceModel =
                this.categoryService.findByCategoryName(
                        itemServiceModel.getCategory().getCategoryName()
                );

        itemServiceModel.setCategory(categoryServiceModel);

        this.itemRepository.saveAndFlush(this.modelMapper.map(itemServiceModel, Item.class));
    }

    @Override
    public List<ItemViewModel> findAllItems() {

        return this.itemRepository.findAll()
                .stream()
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper
                            .map(item, ItemViewModel.class);

                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg",
                            item.getGender(), item.getCategory().getCategoryName()));

                    return itemViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(String id) {
        return this.itemRepository.findById(id)
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper
                            .map(item, ItemViewModel.class);

                    itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg",
                            item.getGender(), item.getCategory().getCategoryName()));

                    return itemViewModel;
                })
                .orElse(null);
    }

    @Override
    public void delete(String id) {
        this.itemRepository.deleteById(id);
    }
}
