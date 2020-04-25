package main.dto;

import com.fasterxml.jackson.annotation.*;
import main.model.*;

import java.util.*;

@JsonRootName(value = "report")
public class ReportDTO {
    private int nbOfGroceryItems;
    private List<GroceryItem> groceryItems;
    private int nbOfEatenCalories;
    private int nbOfWastedCalories;
    private List<GroceryItem> wastedGroceryItems;

    public ReportDTO() {
    }

    public ReportDTO(int nbOfGroceryItems, List<GroceryItem> groceryItems, int nbOfEatenCalories, int nbOfWastedCalories, List<GroceryItem> wastedGroceryItems) {
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

    @Override
    public String toString() {
        return "ReportDTO{" +
                "nbOfGroceryItems=" + nbOfGroceryItems +
                ", groceryItems=" + groceryItems +
                ", nbOfEatenCalories=" + nbOfEatenCalories +
                ", nbOfWastedCalories=" + nbOfWastedCalories +
                ", wastedGroceryItems=" + wastedGroceryItems +
                '}';
    }
}
