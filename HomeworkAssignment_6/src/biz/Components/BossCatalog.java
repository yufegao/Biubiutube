package biz.Components;

import biz.Catalog.AbstractCatalog;
import java.util.ArrayList;

public class BossCatalog extends AbstractCatalog<Boss> {
    public BossCatalog() {
        elementArrayList = new ArrayList<>();
    }
    
    @Override
    public Boss createElement() {
        return new Boss();
    }
}
