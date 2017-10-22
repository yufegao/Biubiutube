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
public class Market extends AbstractCatalog<Customer>{
    private String marketName;
    private MarketOffer marketOffer;
    private double marketValue = 1;  // (0, 2]

    public Market() {
        this.elementArrayList = new ArrayList<Customer>();
        this.marketOffer = new MarketOffer(this);
        Business.getInstance().getMarketOfferCatalog().addElement(this.marketOffer);
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public Customer createElement() {
        return new Customer(this);
    }

    public String getMarketName() {
        return marketName;
    }

    public MarketOffer getMarketOffer() {
        return marketOffer;
    }

    public void setMarketOffer(MarketOffer marketOffer) {
        this.marketOffer = marketOffer;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public Customer findCustomer(int i) throws Failed{
        Customer cust = findElement(c -> c.getId() == i);
        if(cust == null){
            throw new Failed("Customer not exist");
        }
        return cust;
    }
    
    public class Failed extends Exception{
        Failed(String message){
        super(message);
        }
    }
    
    public double getMarketRevenue() {
        double res = 0;
        Order targetOrder = Business.getInstance().getOrderDirectory().getElementArrayList().get(0);
        for(Market market: elementArrayList){
            if(targetOrder.getBoughtBy().getMarket().equals(market)){
                res += targetOrder.getRevenue();
            }
        }
        return res;
    }
    
    @Override
    public String toString(){
        return marketName;
    }

}

