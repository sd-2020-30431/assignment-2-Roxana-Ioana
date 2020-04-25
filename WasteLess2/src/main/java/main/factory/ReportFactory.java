package main.factory;

import main.model.*;

public abstract class ReportFactory {
    public abstract Report getReport(ReportType reportType);
}
