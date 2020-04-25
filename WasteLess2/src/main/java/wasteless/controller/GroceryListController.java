package wasteless.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;
import wasteless.model.*;
import wasteless.service.*;

import java.util.*;

@Controller
public class GroceryListController {

    private final GroceryListService groceryListService;

    @Autowired
    public GroceryListController(GroceryListService groceryListService) {
        this.groceryListService = groceryListService;
    }

    @RequestMapping(value = "/groceryList", method = RequestMethod.GET)
    public String start(Model model, @RequestParam("idUser") int idUser) {
        List<GroceryList> allLists = groceryListService.selectAllLists(idUser);

        model.addAttribute("lists", allLists);
        model.addAttribute("idUser", idUser);

        return "groceryList";
    }

    @RequestMapping(value = "/groceryList", method = RequestMethod.POST)
    public String createNewList(@RequestParam("idUser") int idUser, @RequestParam("lname") String listName, RedirectAttributes redirectAttrs) {
        GroceryList groceryList = new GroceryList(idUser, listName);
        groceryListService.createNewList(groceryList);

        redirectAttrs.addAttribute("idUser", idUser);

        return "redirect:/groceryList";
    }

    @RequestMapping(value = "/groceryList/edit", method = RequestMethod.POST)
    public String editList(@RequestParam("idList") int idList, RedirectAttributes redirectAttrs) {
        redirectAttrs.addAttribute("idList", idList);
        Optional<GroceryList> list = groceryListService.findListById(idList);
        if (list.isPresent()) {
            GroceryList listFound = list.get();
            redirectAttrs.addAttribute("listName", listFound.getName());
        }

        return "redirect:/groceryItems";
    }
}
