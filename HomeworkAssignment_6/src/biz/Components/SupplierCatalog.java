package biz.Components;

import biz.Catalog.AbstractCatalog;
import java.util.ArrayList;

public class SupplierCatalog extends AbstractCatalog<Supplier> {
    public SupplierCatalog() {
        elementArrayList = new ArrayList<>();
    }
    
    @Override
    public Supplier createElement() {
        return new Supplier();
    }
}
