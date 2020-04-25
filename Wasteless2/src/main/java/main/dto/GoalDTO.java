package main.dto;

import com.fasterxml.jackson.annotation.*;

@JsonRootName(value = "goal")
public class GoalDTO {

    private int idGoal;
    private int idUser;
    private int dailyCalories;

    public GoalDTO() {
    }

    public int getIdGoal() {
        return idGoal;
    }

    public void setIdGoal(int idGoal) {
        this.idGoal = idGoal;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getDailyCalories() {
        return dailyCalories;
    }

    public void setDailyCalories(int dailyCalories) {
        this.dailyCalories = dailyCalories;
    }
}
