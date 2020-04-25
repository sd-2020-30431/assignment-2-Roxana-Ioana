package main.dto;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.time.*;

@JsonRootName(value = "grocery-item")
public class GroceryItemDTO {

    private int idItem;
    private int idList;
    private String name;
    private int quantity;
    private int calories;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate purchaseDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate expirationDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate consumptionDate;

    public GroceryItemDTO() {
    }

    public GroceryItemDTO(int idList, String name, int quantity, int calories, LocalDate purchaseDate, LocalDate expirationDate) {
        this.idList = idList;
        this.name = name;
        this.quantity = quantity;
        this.calories = calories;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
    }

    public GroceryItemDTO(int idList, String name, int quantity, int calories, LocalDate purchaseDate, LocalDate expirationDate, LocalDate consumptionDate) {
        this.idList = idList;
        this.name = name;
        this.quantity = quantity;
        this.calories = calories;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.consumptionDate = consumptionDate;
    }

    public int getIdList() {
        return idList;
    }

    public void setIdList(int idList) {
        this.idList = idList;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(LocalDate consumptionDate) {
        this.consumptionDate = consumptionDate;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "idItem=" + idItem +
                ", idList=" + idList +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", calories=" + calories +
                ", purchaseDate=" + purchaseDate +
                ", expirationDate=" + expirationDate +
                ", consumptionDate=" + consumptionDate +
                '}';
    }
}
