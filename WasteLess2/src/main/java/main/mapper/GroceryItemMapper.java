package main.mapper;

import main.dto.*;
import main.model.*;

public class GroceryItemMapper {

    public GroceryItem convertToGroceryItem(GroceryItemDTO groceryItemDTO) {
        GroceryItem groceryItem = new GroceryItem();

        groceryItem.setIdItem(groceryItemDTO.getIdItem());
        groceryItem.setIdList(groceryItemDTO.getIdList());
        groceryItem.setName(groceryItemDTO.getName());
        groceryItem.setCalories(groceryItemDTO.getCalories());
        groceryItem.setQuantity(groceryItemDTO.getQuantity());
        groceryItem.setPurchaseDate(groceryItemDTO.getPurchaseDate());
        groceryItem.setConsumptionDate(groceryItemDTO.getConsumptionDate());
        groceryItem.setExpirationDate(groceryItemDTO.getExpirationDate());

        return groceryItem;
    }

    public GroceryItemDTO convertToGroceryItemDTO(GroceryItem groceryItem) {
        GroceryItemDTO groceryItemDTO = new GroceryItemDTO();

        groceryItemDTO.setIdItem(groceryItem.getIdItem());
        groceryItemDTO.setIdList(groceryItem.getIdList());
        groceryItemDTO.setName(groceryItem.getName());
        groceryItemDTO.setCalories(groceryItem.getCalories());
        groceryItemDTO.setQuantity(groceryItem.getQuantity());
        groceryItemDTO.setPurchaseDate(groceryItem.getPurchaseDate());
        groceryItemDTO.setConsumptionDate(groceryItem.getConsumptionDate());
        groceryItemDTO.setExpirationDate(groceryItem.getExpirationDate());

        return groceryItemDTO;
    }
}
