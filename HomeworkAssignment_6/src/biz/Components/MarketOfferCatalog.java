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
    private String catalogName;
    
    public MarketOfferCatalog() {
        elementArrayList = new ArrayList<>();
    }


    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    @Override
    public MarketOffer createElement() {
        throw new UnsupportedOperationException("MarketOffer should be inited by each Market and add to this "); 
    }
    
}
