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
public class MarketOffer extends AbstractCatalog<OfferProduct>{
    private ArrayList<OfferProduct> op;
    private String marketOfferName;

    public MarketOffer() {
        this.op = new ArrayList<OfferProduct>();
    }
    
    @Override
    public OfferProduct createElement() {
        return new OfferProduct();
    }
    
    
    
    public ArrayList<OfferProduct> getOp() {
        return op;
    }

    public void setOp(ArrayList<OfferProduct> op) {
        this.op = op;
    }

    public String getMarketOfferName() {
        return marketOfferName;
    }

    public void setMarketOfferName(String marketOfferName) {
        this.marketOfferName = marketOfferName;
    }
    
}
