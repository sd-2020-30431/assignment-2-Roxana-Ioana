import main.controller.*;
import main.dto.*;
import main.mapper.*;
import main.model.*;
import main.service.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.runners.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GroceryItemControllerTest {

    @Mock
    private GroceryItemService groceryItemService;

    private GroceryItemController groceryItemController;

    private GroceryItemMapper groceryItemMapper;

    @Before
    public void setUp() {
        groceryItemController = new GroceryItemController(groceryItemService);
    }

    public GroceryItemControllerTest() {
        this.groceryItemMapper = new GroceryItemMapper();
    }

    @Test
    public void addGroceryItem() {
        int idList = 1;

        GroceryItemDTO groceryItemDTO = new GroceryItemDTO(idList, "paine");
        GroceryItem groceryItem = groceryItemMapper.convertToGroceryItem(groceryItemDTO);

        groceryItem.setIdItem(1);
        when(groceryItemService.addGroceryItem(groceryItem)).thenReturn(groceryItem);

        Integer idItem = groceryItemController.addGroceryItem(groceryItemDTO).getBody();
        System.out.println(idItem);
        assertEquals((Integer) groceryItem.getIdItem(), idItem);
    }
}
