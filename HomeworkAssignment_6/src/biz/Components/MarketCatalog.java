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
    
    public MarketCatalog() {
        this.elementArrayList = new ArrayList<>();
    }
    
    @Override
    public Market createElement() {
        return new Market();      
    }
}
