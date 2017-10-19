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
    public MarketOffer(Market market) {
        elementArrayList = new ArrayList<>();
        for (Product p: Business.getInstance().getAllProducts()) {
            // init each offerProduct by marketValue
            OfferProduct op = this.newElement();
            op.setProduct(p);
            double val = (1 + market.getMarketValue()) * p.getFactoryPrice();
            op.setHighestPrice(val * 5);
            op.setTargetPrice(val * 1.5);
            op.setLowestPrice(val * 1);
        }
    }
    
    @Override
    public OfferProduct createElement() {
        return new OfferProduct();
    }
}
