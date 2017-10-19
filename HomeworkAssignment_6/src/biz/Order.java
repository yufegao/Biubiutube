/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz;

import biz.ctlg.AbstractCatalog;

/**
 *
 * @author royn
 */
public class Order extends AbstractCatalog<OrderProduct>{
    private String OrderCode;
    private OrderProduct OrderProduct;
    private int Number;
    private SalesPerson SoldBy;
    private Customer BoughtBy;

   
    
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

    public OrderProduct getOrderProduct() {
        return OrderProduct;
    }

    public void setOrderProduct(OrderProduct OrderProduct) {
        this.OrderProduct = OrderProduct;
    }
    
    
}
