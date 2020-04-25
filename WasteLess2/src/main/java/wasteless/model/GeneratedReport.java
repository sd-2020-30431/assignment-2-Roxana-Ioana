package wasteless.model;

import java.util.*;

public class GeneratedReport {

    private int nbOfGroceryItems;
    private List<GroceryItem> groceryItems;
    private int nbOfEatenCalories;
    private int nbOfWastedCalories;
    private List<GroceryItem> wastedGroceryItems;

    public GeneratedReport() {
    }

    public GeneratedReport(int nbOfGroceryItems, List<GroceryItem> groceryItems, int nbOfEatenCalories, int nbOfWastedCalories, List<GroceryItem> wastedGroceryItems) {
        this.nbOfGroceryItems = nbOfGroceryItems;
        this.groceryItems = groceryItems;
        this.nbOfEatenCalories = nbOfEatenCalories;
        this.nbOfWastedCalories = nbOfWastedCalories;
        this.wastedGroceryItems = wastedGroceryItems;
    }

    public int getNbOfGroceryItems() {
        return nbOfGroceryItems;
    }

    public void setNbOfGroceryItems(int nbOfGroceryItems) {
        this.nbOfGroceryItems = nbOfGroceryItems;
    }

    public List<GroceryItem> getGroceryItems() {
        return groceryItems;
    }

    public void setGroceryItems(List<GroceryItem> groceryItems) {
        this.groceryItems = groceryItems;
    }

    public int getNbOfEatenCalories() {
        return nbOfEatenCalories;
    }

    public void setNbOfEatenCalories(int nbOfEatenCalories) {
        this.nbOfEatenCalories = nbOfEatenCalories;
    }

    public int getNbOfWastedCalories() {
        return nbOfWastedCalories;
    }

    public void setNbOfWastedCalories(int nbOfWastedCalories) {
        this.nbOfWastedCalories = nbOfWastedCalories;
    }

    public List<GroceryItem> getWastedGroceryItems() {
        return wastedGroceryItems;
    }

    public void setWastedGroceryItems(List<GroceryItem> wastedGroceryItems) {
        this.wastedGroceryItems = wastedGroceryItems;
    }
}
