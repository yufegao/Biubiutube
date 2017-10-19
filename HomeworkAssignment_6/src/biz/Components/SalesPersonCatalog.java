package biz.Components;

import biz.Catalog.AbstractCatalog;

public class SalesPersonCatalog extends AbstractCatalog<SalesPerson> {
    @Override
    public SalesPerson createElement() {
        return new SalesPerson();
    }
}
