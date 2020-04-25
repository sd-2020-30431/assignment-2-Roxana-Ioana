package wasteless.model;

import javax.persistence.*;

@Entity
@Table(name = "grocery_list")
public class GroceryList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idList;
    private int idUser;
    private String name;

    public GroceryList() {
    }

    public GroceryList(int idUser, String name) {
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
