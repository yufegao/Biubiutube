package biz.Components;

import biz.Catalog.AbstractCatalog;

public class SupplierCatalog extends AbstractCatalog<Supplier> {
    @Override
    public Supplier createElement() {
        return new Supplier();
    }
}
