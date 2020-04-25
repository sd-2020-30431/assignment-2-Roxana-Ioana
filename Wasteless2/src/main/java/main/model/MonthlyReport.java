package main.model;

import main.dto.*;

import java.util.*;

public class MonthlyReport extends Report {

    public ReportDTO sendReport(List<GroceryItem> groceryItems) {
        return generateReport(getGroceryItems(groceryItems, 30));
    }
}
