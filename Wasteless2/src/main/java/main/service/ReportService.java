package main.service;

import main.dto.*;
import main.factory.*;
import main.model.*;
import main.repository.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class ReportService {
    private GroceryListRepository groceryListRepository;
    private GroceryItemRepository groceryItemRepository;

    public ReportService(GroceryListRepository groceryListRepository,
                         GroceryItemRepository groceryItemRepository) {
        this.groceryListRepository = groceryListRepository;
        this.groceryItemRepository = groceryItemRepository;
    }

    public ReportDTO getReport(int idUser, ReportType reportType) {
        List<GroceryList> lists = groceryListRepository.findAllByIdUser(idUser);
        List<GroceryItem> items = lists.stream().map(groceryList -> groceryItemRepository.findByIdList(groceryList.getIdList())).flatMap(Collection::stream).collect(Collectors.toList());

        return new FactoryProvider().getFactory(reportType).getReport(reportType).sendReport(items);
    }
}
