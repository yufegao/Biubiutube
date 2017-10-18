/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Market {
    private ArrayList<Customer> customer;
    private String marketName;
    private MarketOffer marketOffer;

    public Market() {
        this.customer = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(ArrayList<Customer> customer) {
        this.customer = customer;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }
    
    
}
