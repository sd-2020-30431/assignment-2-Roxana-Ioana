package main.validators;

import main.dto.*;

public class GoalValidator implements Validator<GoalDTO> {

    @Override
    public void validate(GoalDTO goalDTO) throws IllegalArgumentException {
        if (goalDTO.getDailyCalories() < 0) {
            throw new IllegalArgumentException();
        }
    }
}
