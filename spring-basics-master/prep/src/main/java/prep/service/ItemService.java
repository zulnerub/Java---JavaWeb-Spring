package prep.service;

import prep.model.service.ItemServiceModel;
import prep.model.view.ItemViewModel;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    void addItem(ItemServiceModel itemServiceModel);

    List<ItemViewModel> findAllItems();

    ItemViewModel findById(String id);

    void delete(String id);
}
