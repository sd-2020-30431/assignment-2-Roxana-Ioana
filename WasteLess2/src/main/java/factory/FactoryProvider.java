package factory;

import wasteless.model.*;

public class FactoryProvider extends AbstractFactory {

    @Override
    public ReportFactory getFactory(ReportType reportType) {
        if (reportType.equals(ReportType.MONTHLY)) {
            return new MonthlyReportFactory();
        } else if (reportType.equals(ReportType.WEEKLY)) {
            return new WeeklyReportFactory();
        }
        return null;
    }
}
