package factory;

import wasteless.model.*;

public abstract class AbstractFactory {
    abstract ReportFactory getFactory(ReportType reportType);
}
