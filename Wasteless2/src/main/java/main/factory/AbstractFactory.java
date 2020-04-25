package main.factory;

import main.model.*;

public abstract class AbstractFactory {
    abstract ReportFactory getFactory(ReportType reportType);
}
