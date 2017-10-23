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
    
    public double getTotalRevenue(boolean includeDrafted) {
        ArrayList<Order> orders;
        if (includeDrafted) {
            orders = this.getElementArrayList();
        } else {
            orders = this.findElements(o -> o.getStatus().equals("Placed"));
        }
        
        double res = 0;
        for (Order order : orders) {
            res += order.getRevenue();
        }
        return res;
    }
    
    public double getTotalGap(boolean includeDrafted) {
        ArrayList<Order> orders;
        if (includeDrafted) {
            orders = this.getElementArrayList();
        } else {
            orders = this.findElements(o -> o.getStatus().equals("Placed"));
        }
        
        double res = 0;
        for (Order order: orders) {
            res += order.getGap();
        }
        return res;
    }    
}
