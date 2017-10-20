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
 * @author royn
 */
public class OrderDirectory extends AbstractCatalog<Order>{    
    public OrderDirectory() {
        elementArrayList = new ArrayList<>();
    }
    
    @Override
    public Order createElement() {
        return new Order();
    }
    
}
