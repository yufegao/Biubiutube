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
    private String OrderNumber;
//    private SalesPerson SoldBy;  TODO
//    private Customer BoughtBy;

   
    
    @Override
    public OrderProduct createElement() {
        return new OrderProduct();
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String OrderNumber) {
        this.OrderNumber = OrderNumber;
    }
}
