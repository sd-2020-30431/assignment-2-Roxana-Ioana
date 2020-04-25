package main.service;

import main.model.*;
import main.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class GroceryItemService {

    private final GroceryItemRepository groceryItemRepository;

    @Autowired
    public GroceryItemService(GroceryItemRepository groceryItemRepository) {
        this.groceryItemRepository = groceryItemRepository;
    }

    public List<GroceryItem> findByIdList(int idList) {
        return groceryItemRepository.findByIdList(idList);
    }

    public GroceryItem addGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    public void deleteItem(int idItem) {
        groceryItemRepository.deleteByIdItem(idItem);
    }

    public void setConsumptionDate() {
    }
}

