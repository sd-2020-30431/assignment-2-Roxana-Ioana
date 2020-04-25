package main.factory;

import main.model.*;

public class WeeklyReportFactory extends ReportFactory {

    @Override
    public Report getReport(ReportType reportType) {
        return new WeeklyReport();
    }
}
