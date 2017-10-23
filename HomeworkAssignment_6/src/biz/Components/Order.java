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
public class Order extends AbstractCatalog<OrderProduct>{
    private static int orderId = 0;
    private int id;
    private SalesPerson SoldBy;
    private Customer BoughtBy;
    private String status = "Drafted";

    public Order () {
        elementArrayList = new ArrayList<>();
        orderId++;
        id = orderId;
    }

    @Override
    public OrderProduct createElement() {
        return new OrderProduct();
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

    public double getOrderReward() {
        double reward = 0;
        for (OrderProduct op: this.elementArrayList){
            reward += (op.getActualPrice() - op.getOfferProduct().getProduct().getFactoryPrice()) * op.getQuantity() *0.05;
        }
        return reward;
    }

    public double getRevenue(){
        double revenue = 0;
        for (OrderProduct op: this.elementArrayList){
            revenue += (op.getActualPrice() -  op.getOfferProduct().getProduct().getFactoryPrice())*op.getQuantity();
        }
        return revenue;
    }
    
    public double getGap(){
        double gap = 0;
        for (OrderProduct op: this.elementArrayList){
            gap += (op.getActualPrice() -  op.getOfferProduct().getTargetPrice())*op.getQuantity();
        }
        return gap;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }

    public int getId() {
        return id;
    }

}
