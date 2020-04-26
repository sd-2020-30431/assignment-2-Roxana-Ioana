package main.validators;

import main.dto.*;

import java.util.regex.*;

public class GroceryListValidator implements Validator<GroceryListDTO> {

    private static final String NAME_PATTERN = "^[a-zA-Z]*$";

    @Override
    public void validate(GroceryListDTO groceryListDTO) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        if (!pattern.matcher(groceryListDTO.getName()).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
