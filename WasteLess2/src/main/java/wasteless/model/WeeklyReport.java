package wasteless.model;

import java.util.*;

public class WeeklyReport extends Report {

    public GeneratedReport sendReport(List<GroceryItem> groceryItems) {
        return generateReport(getGroceryItems(groceryItems, 7));
    }
}
