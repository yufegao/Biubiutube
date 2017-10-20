/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.Components;

/**
 *
 * @author royn
 */
public class OrderProduct {
    private OfferProduct offerProduct;
    private double ActualPrice;
    private int Quantity;

    public double getActualPrice() {
        return ActualPrice;
    }

    public void setActualPrice(double ActualPrice) {
        this.ActualPrice = ActualPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    } 
    
    public double getTotalPrice() {
        return (double) Quantity * ActualPrice;
    }
}
