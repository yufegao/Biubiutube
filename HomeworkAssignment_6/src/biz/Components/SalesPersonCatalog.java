package biz.Components;

import biz.Catalog.AbstractCatalog;
import java.util.ArrayList;

public class SalesPersonCatalog extends AbstractCatalog<SalesPerson> {
    public SalesPersonCatalog() {
        elementArrayList = new ArrayList<>();
    }
    
    @Override
    public SalesPerson createElement() {
        return new SalesPerson();
    }
}
