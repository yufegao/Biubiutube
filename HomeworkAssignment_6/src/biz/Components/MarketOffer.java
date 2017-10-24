/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.Components;

import biz.Catalog.AbstractCatalog;
import biz.Catalog.Finder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Administrator
 */
public class MarketOffer extends AbstractCatalog<OfferProduct>{
    private Market market;

    public Market getMarket() {
        return market;
    }
    public MarketOffer(Market ma) {
        this.market = ma;
        elementArrayList = new ArrayList<>();
    }
    
    @Override
    public OfferProduct createElement() {
        return new OfferProduct();
    }


    private void updateElementArrayList() {
        for(Product product : Business.getInstance().getAllProducts()){
            if(this.elementArrayList.stream().filter(op -> op.getProduct().equals(product)).count() > 0){
                continue;
            }
            OfferProduct op = this.newElement();
            op.setProduct(product);
            double val = (1 + market.getMarketValue()) * product.getFactoryPrice();
            op.setHighestPrice(val * 5);
            op.setTargetPrice(val * 1.5);
            op.setLowestPrice(val * 1);            
        }
    }

    @Override
    public OfferProduct findElement(Finder<OfferProduct> finder) {
        updateElementArrayList();
        return super.findElement(finder);
    }

    @Override
    public ArrayList<OfferProduct> findElements(Finder<OfferProduct> finder) {
        updateElementArrayList();
        return super.findElements(finder);
    }

    @Override
    public ArrayList<OfferProduct> getElementArrayList() {
        updateElementArrayList();
        return super.getElementArrayList();
    }
    
}
