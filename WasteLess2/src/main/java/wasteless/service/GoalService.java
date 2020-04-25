package wasteless.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import wasteless.model.*;
import wasteless.repository.*;

import java.time.*;
import java.util.*;
import java.util.stream.*;

@Service
public class GoalService {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final GroceryListRepository groceryListRepository;

    @Autowired
    public GoalService(UserRepository userRepository, ItemRepository itemRepository, GroceryListRepository groceryListRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.groceryListRepository = groceryListRepository;
    }

    public User createGoal(int idUser, int goal)
    {
        User user = userRepository.findByIdUser(idUser);
        user.setDailyCalories(goal);

        return userRepository.save(user);
    }

    public int getGoal(int idUser)
    {
        return  userRepository.findByIdUser(idUser).getDailyCalories();
    }

    public int caloriesToday(int idUser)
    {
        List<GroceryList> lists = groceryListRepository.findAllByIdUser(idUser);
        List<GroceryItem> items = lists.stream().map(groceryList -> itemRepository.findByIdList(groceryList.getIdList())).flatMap(Collection::stream).collect(Collectors.toList());

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
}
