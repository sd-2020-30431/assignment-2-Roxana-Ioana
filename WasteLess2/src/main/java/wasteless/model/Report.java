package wasteless.model;

import java.time.*;
import java.util.*;
import java.util.stream.*;

public abstract class Report {

    public List<GroceryItem> getGroceryItems(List<GroceryItem> groceryItems, int days) {
        LocalDate date = LocalDate.now().minusDays(days);
        return groceryItems.stream().filter(groceryItem -> groceryItem.getPurchaseDate().isAfter(date)).collect(Collectors.toList());
    }

    public GeneratedReport generateReport(List<GroceryItem> groceryItems) {
        int nbOfGroceryItems = groceryItems.size();

        List<GroceryItem> purchasedItems = groceryItems;
        int nbOfEatenCalories = 0;
        int nbOfWastedCalories = 0;
        List<GroceryItem> wastedGroceryItems = new ArrayList<>();

        for (GroceryItem groceryItem : groceryItems) {
            //if the item was not consumed and it has expired
            if (groceryItem.getConsumptionDate() == null && groceryItem.getExpirationDate().isBefore(LocalDate.now())) {
                nbOfWastedCalories += groceryItem.getCalories() * groceryItem.getQuantity();
                wastedGroceryItems.add(groceryItem);
            } else {
                if (groceryItem.getConsumptionDate() != null) {
                    nbOfEatenCalories += groceryItem.getCalories() * groceryItem.getQuantity();
                }
            }
        }

        return (new GeneratedReport(nbOfGroceryItems, purchasedItems, nbOfEatenCalories, nbOfWastedCalories, wastedGroceryItems));
    }

    public abstract GeneratedReport sendReport(List<GroceryItem> groceryItems);
}
