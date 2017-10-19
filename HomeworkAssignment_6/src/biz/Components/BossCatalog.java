package biz.Components;

import biz.Catalog.AbstractCatalog;

public class BossCatalog extends AbstractCatalog<Boss> {
    @Override
    public Boss createElement() {
        return new Boss();
    }
}
