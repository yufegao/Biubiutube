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
public class MarketCatalog extends AbstractCatalog<Market>{

    private String catalogName;
    private ArrayList<Market> markets;

    public MarketCatalog() {
        this.markets = new ArrayList<Market>();
    }
    
    @Override
    public Market createElement() {
        return new Market();      
    }
    
    public boolean addMaeket(Market market){
        return this.getElementArrayList().add(market);
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public ArrayList<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(ArrayList<Market> markets) {
        this.markets = markets;
    }
    
}
