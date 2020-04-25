package wasteless.service;

import factory.*;
import org.springframework.stereotype.*;
import wasteless.model.*;
import wasteless.repository.*;

import java.util.*;
import java.util.stream.*;

@Service
public class ReportService {
    private GroceryListRepository groceryListRepository;
    private ItemRepository itemRepository;

    public ReportService(GroceryListRepository groceryListRepository,
                         ItemRepository itemRepository) {
        this.groceryListRepository = groceryListRepository;
        this.itemRepository = itemRepository;
    }

    public GeneratedReport getReport(ReportType reportType, int idUser) {
        List<GroceryList> lists = groceryListRepository.findAllByIdUser(idUser);
        List<GroceryItem> items = lists.stream().map(groceryList -> itemRepository.findByIdList(groceryList.getIdList())).flatMap(Collection::stream).collect(Collectors.toList());

        return new FactoryProvider().getFactory(reportType).getReport(reportType).sendReport(items);
    }
}
