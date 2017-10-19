/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.Components;

import biz.Catalog.AbstractCatalog;

/**
 *
 * @author royn
 */
public class Order extends AbstractCatalog<OrderProduct>{
    private String OrderCode;
    private int Number;
    private SalesPerson SoldBy;
    private Customer BoughtBy;
    private String status = "init";
   
    
    @Override
    public OrderProduct createElement() {
        return new OrderProduct();
    }

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String OrderCode) {
        this.OrderCode = OrderCode;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }



    public SalesPerson getSoldBy() {
        return SoldBy;
    }

    public void setSoldBy(SalesPerson SoldBy) {
        this.SoldBy = SoldBy;
    }

    public Customer getBoughtBy() {
        return BoughtBy;
    }

    public void setBoughtBy(Customer BoughtBy) {
        this.BoughtBy = BoughtBy;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }
    
    public double totalPrice() {
        float totalPrice = 0;
        for (OrderProduct op: this.elementArrayList) {
            totalPrice += op.getTotalPrice();
        }
        return totalPrice;
    }
    
    public double getRevenue() {
        return 0; // TODO: calc revenue
    }
    
    @Override
    public String toString() {
        return OrderCode;
    }
}
