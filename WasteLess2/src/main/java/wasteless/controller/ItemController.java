package wasteless.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;
import wasteless.model.*;
import wasteless.service.*;

import java.time.*;
import java.time.format.*;
import java.util.*;

@RestController
@RequestMapping("/groceryItems")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<GroceryItem>> findItemsByIdList(@RequestParam(value = "errorMessage", required = false) String errorMessage, @RequestParam("listName") String listName, @RequestParam("idList") int idList) {
        /*model.addAttribute("idList", idList);
        model.addAttribute("listName", listName);
        model.addAttribute("errorMessage", errorMessage);*/

        List<GroceryItem> itemsList = itemService.findByIdList(idList);

        return new ResponseEntity<>(itemsList, HttpStatus.OK);
    }

    @RequestMapping(value = "/groceryItems", method = RequestMethod.POST)
    public String insertItem(@RequestParam("idList") int idList,
                             @RequestParam("listName") String listName,

                             @RequestParam("iname") String itemName,
                             @RequestParam("quantity") int quantity,
                             @RequestParam("calories") int calories,
                             @RequestParam("pDate") String purDate,
                             @RequestParam("eDate") String expDate,
                             @RequestParam("cDate") String conDate,
                             RedirectAttributes redirectAttrs) {

        String errorMessage = null;
        if (quantity <= 0 || calories <= 0) {
            errorMessage = "Invalid quantity or calories!";
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate purchaseDate = LocalDate.parse(purDate, formatter);
            LocalDate expirationDate = LocalDate.parse(expDate, formatter);

            if(!conDate.equals(""))
            {
                LocalDate consumptionDate = LocalDate.parse(conDate, formatter);
                if (consumptionDate.isBefore(purchaseDate) || consumptionDate.isAfter(expirationDate)) {
                    errorMessage = "Invalid consumption date!";
                } else {
                    itemService.insertItem(new GroceryItem(idList, itemName, quantity, calories, purchaseDate, expirationDate, consumptionDate));
                }
            }
            else
            {
                itemService.insertItem(new GroceryItem(idList, itemName, quantity, calories, purchaseDate, expirationDate));
            }

        }

        System.out.println(errorMessage);
        redirectAttrs.addAttribute("errorMessage", errorMessage);
        redirectAttrs.addAttribute("listName", listName);
        redirectAttrs.addAttribute("idList", idList);

        return "redirect:/groceryItems";
    }

    @Transactional
    @RequestMapping(value = "/donate", method = RequestMethod.POST)
    public String deleteItem(@RequestParam("idList") int idList, @RequestParam("listName") String listName, @RequestParam("idItem") int idItem, RedirectAttributes redirectAttrs) {
        itemService.deleteItem(idItem);

        redirectAttrs.addAttribute("idList", idList);
        redirectAttrs.addAttribute("listName", listName);

        return "redirect:/groceryItems";
    }
}
