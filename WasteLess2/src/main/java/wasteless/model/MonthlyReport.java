package wasteless.model;

import java.util.*;

public class MonthlyReport extends Report {

    public GeneratedReport sendReport(List<GroceryItem> groceryItems) {
        return generateReport(getGroceryItems(groceryItems, 30));
    }
}
