package wasteless.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import wasteless.model.*;
import wasteless.repository.*;

import java.util.*;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public GroceryItem findById(int id) {
        return itemRepository.findById(id);
    }

    public List<GroceryItem> findByIdList(int idList) {
        return itemRepository.findByIdList(idList);
    }

    public void insertItem(GroceryItem groceryItem) {
        itemRepository.save(groceryItem);
    }

    public void deleteItem(int idItem) {
        itemRepository.deleteByIdItem(idItem);
    }
}
