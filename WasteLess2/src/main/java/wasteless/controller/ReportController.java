package wasteless.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import wasteless.model.*;
import wasteless.service.*;

@Controller
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public String getMonthlyReport(@RequestParam("type") String reportType, @RequestParam("idUser") int idUser, Model model) {
        GeneratedReport report = reportService.getReport(ReportType.valueOf(reportType), idUser);

        model.addAttribute("type", reportType);
        model.addAttribute("idUser", idUser);
        model.addAttribute("nbPurchasedItems", report.getNbOfGroceryItems());
        model.addAttribute("nbConsumedCalories", report.getNbOfEatenCalories());
        model.addAttribute("nbWastedCalories", report.getNbOfWastedCalories());
        model.addAttribute("purchasedItems", report.getGroceryItems());
        model.addAttribute("wastedItems", report.getWastedGroceryItems());

        return "report";
    }

}
