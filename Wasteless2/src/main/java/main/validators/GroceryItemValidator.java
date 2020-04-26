package main.validators;

import main.dto.*;

import java.time.*;
import java.util.regex.*;

public class GroceryItemValidator implements Validator<GroceryItemDTO> {

    private static final String NAME_PATTERN = "^[a-zA-Z]*$";

    @Override
    public void validate(GroceryItemDTO groceryItemDTO) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        if (!pattern.matcher(groceryItemDTO.getName()).matches() || groceryItemDTO.getCalories() < 0 || groceryItemDTO.getQuantity() <= 0
                || groceryItemDTO.getPurchaseDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Invalid grocery item!");
        }
    }
}
