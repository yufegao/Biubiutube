package biz;

import biz.ctlg.AbstractCatalog;

public class BossCatalog extends AbstractCatalog<Boss> {
    @Override
    public Boss createElement() {
        return new Boss();
    }
}
