/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.Components;

import biz.Catalog.AbstractCatalog;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class MarketOfferCatalog extends AbstractCatalog<MarketOffer> {
    private ArrayList<MarketOffer> mo;
    private String catalogName;
    @Override
    public MarketOffer createElement() {
        return new MarketOffer();
    }

    public ArrayList<MarketOffer> getMo() {
        return mo;
    }

    public void setMo(ArrayList<MarketOffer> mo) {
        this.mo = mo;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }
    
}
