package main.dto;

import com.fasterxml.jackson.annotation.*;

@JsonRootName(value = "grocery-list")
public class GroceryListDTO {
    private int idList;
    private int idUser;
    private String name;

    public GroceryListDTO() {
    }

    public GroceryListDTO(int idUser, String name) {
        this.idUser = idUser;
        this.name = name;
    }

    public int getIdList() {
        return idList;
    }

    public void setIdList(int idList) {
        this.idList = idList;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
