/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.Components;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Customer {
    private String name;
    private static int count = 0;
    private int id;
    private Market market;
    
    public Customer(Market market) {
        this.market = market;
        count++;
        id = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }
    @Override
    public String toString(){
        return name;
    }
}
