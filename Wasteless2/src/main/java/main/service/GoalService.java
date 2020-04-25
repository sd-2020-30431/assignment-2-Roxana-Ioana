package main.service;

import main.model.*;
import main.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;
import java.util.stream.*;

@Service
public class GoalService {

    private final GoalRepository goalRepository;
    private final GroceryListRepository groceryListRepository;
    private final GroceryItemRepository groceryItemRepository;

    @Autowired
    public GoalService(GoalRepository goalRepository, GroceryListRepository groceryListRepository, GroceryItemRepository groceryItemRepository) {
        this.goalRepository = goalRepository;
        this.groceryListRepository = groceryListRepository;
        this.groceryItemRepository = groceryItemRepository;
    }

    public Goal createGoal(Goal goal)
    {
        return goalRepository.save(goal);
    }

    public int getNecessaryDailyCalories(int idUser)
    {
        List<GroceryList> lists = groceryListRepository.findAllByIdUser(idUser);
        List<GroceryItem> items = lists.stream().map(groceryList -> groceryItemRepository.findByIdList(groceryList.getIdList())).flatMap(Collection::stream).collect(Collectors.toList());

        int totalCaloriesPerDay = 0;
       for(GroceryItem item:items)
       {
           if(item.getConsumptionDate()==null && item.getExpirationDate().isAfter(LocalDate.now()))
           {
               LocalDate currentDate = LocalDate.now();
               Period periodUntilExpiration = currentDate.until(item.getExpirationDate());
               int daysUntilExpiration = periodUntilExpiration.getDays();

               int idealBurndown = item.getCalories()/daysUntilExpiration;
               totalCaloriesPerDay += idealBurndown;
           }
       }

       return totalCaloriesPerDay;
    }

    public Goal getGoal(int idUser)
    {
        List<Goal> goals = goalRepository.findAllByIdUser(idUser).get();
        return goals.get(goals.size()-1);
    }
}
