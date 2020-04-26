package main.controller;

import main.dto.*;
import main.mapper.*;
import main.model.*;
import main.service.*;
import main.validators.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/grocery-lists")
public class GroceryListController {

    private final GroceryListService groceryListService;
    private GroceryListMapper groceryListMapper;
    private GroceryListValidator groceryListValidator;

    @Autowired
    public GroceryListController(GroceryListService groceryListService) {
        this.groceryListService = groceryListService;
        groceryListMapper = new GroceryListMapper();
        groceryListValidator = new GroceryListValidator();
    }

    @RequestMapping(value = "/{idUser}", method = RequestMethod.GET)
    public ResponseEntity<List<GroceryList>> getAllGroceryLists(@PathVariable("idUser") int idUser) {
        List<GroceryList> groceryLists = groceryListService.selectAllLists(idUser);
        return new ResponseEntity<>(groceryLists, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Integer> createGroceryList(@RequestBody GroceryListDTO groceryListDTO) {
        try {
            groceryListValidator.validate(groceryListDTO);
            GroceryList groceryList1 = groceryListService.createNewList(groceryListMapper.convertToGroceryList(groceryListDTO));
            return new ResponseEntity<>(groceryList1.getIdList(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/{idList}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteGroceryList(@PathVariable("idList") int idList) {
        groceryListService.deleteList(idList);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
