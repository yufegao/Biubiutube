package biz;

import biz.ctlg.AbstractCatalog;

public class SalesPersonCatalog extends AbstractCatalog<SalesPerson> {
    @Override
    public SalesPerson createElement() {
        return new SalesPerson();
    }
}
