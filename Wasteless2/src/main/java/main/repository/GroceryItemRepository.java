package main.repository;

import main.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Integer> {

    GroceryItem findById(int id);

    List<GroceryItem> findByIdList(int idList);

    void deleteByIdItem(int idItem);
}
