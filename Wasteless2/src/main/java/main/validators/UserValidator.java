package main.validators;

import main.dto.*;

import java.util.regex.*;

public class UserValidator implements Validator<UserDTO> {

    private static final String NAME_PATTERN = "^[a-zA-Z]*$";

    @Override
    public void validate(UserDTO userDTO) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        if (!pattern.matcher(userDTO.getUsername()).matches() || userDTO.getPassword().length() < 3) {
            throw new IllegalArgumentException();
        }
    }
}
