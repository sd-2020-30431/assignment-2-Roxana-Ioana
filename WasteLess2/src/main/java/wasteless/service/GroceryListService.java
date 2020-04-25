package wasteless.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import wasteless.model.*;
import wasteless.repository.*;

import java.util.*;

@Service
public class GroceryListService {

    private final GroceryListRepository groceryListRepository;

    @Autowired
    public GroceryListService(GroceryListRepository groceryListRepository) {
        this.groceryListRepository = groceryListRepository;
    }

    public GroceryList createNewList(GroceryList groceryList) {
        return groceryListRepository.save(groceryList);
    }

    public ArrayList<GroceryList> selectAllLists(int idUser) {
        return groceryListRepository.findAllByIdUser(idUser);
    }

    public Optional<GroceryList> findListById(int idList) {
        return groceryListRepository.findById(idList);
    }
}
