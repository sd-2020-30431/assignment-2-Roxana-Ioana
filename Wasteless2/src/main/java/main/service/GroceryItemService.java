package main.service;

import main.model.*;
import main.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;
import java.util.stream.*;

@Service
public class GroceryItemService {

    private final GroceryItemRepository groceryItemRepository;
    private final GroceryListRepository groceryListRepository;

    @Autowired
    public GroceryItemService(GroceryItemRepository groceryItemRepository, GroceryListRepository groceryListRepository) {
        this.groceryItemRepository = groceryItemRepository;
        this.groceryListRepository = groceryListRepository;
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

    public void updateItem(GroceryItem groceryItem) {
        groceryItemRepository.save(groceryItem);
    }

    public List<GroceryItem> getGroceryItemsWhichExpire(int idUser) {
        //get all items for user
        List<GroceryList> lists = groceryListRepository.findAllByIdUser(idUser);
        List<GroceryItem> items = lists.stream().map(groceryList -> groceryItemRepository.findByIdList(groceryList.getIdList())).flatMap(Collection::stream).collect(Collectors.toList());

        //filter those which expire in the next 5 days
        return getItemsWhichExpireNext5Days(items);
    }

    private List<GroceryItem> getItemsWhichExpireNext5Days(List<GroceryItem> items) {
        LocalDate date = LocalDate.now().plusDays(5);
        return items.stream().filter(groceryItem -> groceryItem.getExpirationDate().isBefore(date) && groceryItem.getConsumptionDate() == null).collect(Collectors.toList());
    }
}

