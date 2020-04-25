package factory;

import wasteless.model.*;

public abstract class ReportFactory {
    public abstract Report getReport(ReportType reportType);
}
