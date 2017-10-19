package biz;

import biz.ctlg.AbstractCatalog;

public class SupplierCatalog extends AbstractCatalog<Supplier> {
    @Override
    public Supplier createElement() {
        return new Supplier();
    }
}
