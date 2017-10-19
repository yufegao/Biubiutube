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
    private Market market;
    public MarketOffer(Market ma) {
        elementArrayList = new ArrayList<>();
    }
    
    @Override
    public OfferProduct createElement() {
        return new OfferProduct();
    }

    
    @Override
    public ArrayList<OfferProduct> getElementArrayList() {
        for(Product product : Business.getInstance().getAllProducts()){
            OfferProduct offerProduct = this.findElement(op -> op.getProduct().equals(product));
            if(offerProduct != null){
                continue;
            }
            OfferProduct op = this.newElement();
            op.setProduct(product);
            double val = (1 + market.getMarketValue()) * product.getFactoryPrice();
            op.setHighestPrice(val * 5);
            op.setTargetPrice(val * 1.5);
            op.setLowestPrice(val * 1);        
        }
        return elementArrayList;
    }
}
