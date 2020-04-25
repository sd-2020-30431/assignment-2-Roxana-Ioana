package factory;

import wasteless.model.*;

public class MonthlyReportFactory extends ReportFactory{

    @Override
    public Report getReport(ReportType reportType) {
        return new MonthlyReport();
    }
}
