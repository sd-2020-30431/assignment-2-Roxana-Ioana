package wasteless.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import wasteless.model.*;

import java.util.*;

@Repository
public interface ItemRepository extends JpaRepository<GroceryItem, Integer> {

    GroceryItem findById(int id);

    List<GroceryItem> findByIdList(int idList);

    void deleteByIdItem(int idItem);
}
