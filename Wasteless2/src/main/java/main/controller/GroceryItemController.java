package main.controller;

import main.dto.*;
import main.mapper.*;
import main.model.*;
import main.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.*;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/grocery-items")
public class GroceryItemController {

    private final GroceryItemService groceryItemService;
    private GroceryItemMapper groceryItemMapper;

    @Autowired
    public GroceryItemController(GroceryItemService groceryItemService) {
        this.groceryItemService = groceryItemService;
        groceryItemMapper = new GroceryItemMapper();
    }

    @RequestMapping(value = "/{idList}", method = RequestMethod.GET)
    public ResponseEntity<List<GroceryItem>> findItemsByIdList(@PathVariable("idList") int idList) {
        List<GroceryItem> itemsList = groceryItemService.findByIdList(idList);
        return new ResponseEntity<>(itemsList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Integer> addGroceryItem(@RequestBody GroceryItemDTO groceryItemDTO) {
        GroceryItem groceryItem = groceryItemService.addGroceryItem(groceryItemMapper.convertToGroceryItem(groceryItemDTO));
        return new ResponseEntity<>(groceryItem.getIdItem(), HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/{idItem}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteGroceryItem(@PathVariable("idItem") int idItem) {
        groceryItemService.deleteItem(idItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{idItem}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateGroceryItem(@RequestBody GroceryItemDTO groceryItemDTO){
        groceryItemService.setConsumptionDate();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/to-expire/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<List<GroceryItem>> getGroceryItemsWhichExpire(@PathVariable("idUser") int idUser){
        List<GroceryItem> groceryItems = groceryItemService.getGroceryItemsWhichExpire(idUser);
        return new ResponseEntity<>(groceryItems, HttpStatus.OK);
    }
}
