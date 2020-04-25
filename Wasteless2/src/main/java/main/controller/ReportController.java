package main.controller;

import main.dto.*;
import main.model.*;
import main.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @RequestMapping(value = "/{idUser}/{type}", method = RequestMethod.GET)
    public ResponseEntity<ReportDTO> getMonthlyReport(@PathVariable("idUser") int idUser, @PathVariable("type") String reportType) {
        ReportDTO reportDTO = reportService.getReport(idUser, ReportType.valueOf(reportType));
        return new ResponseEntity<>(reportDTO, HttpStatus.OK);
    }
}
