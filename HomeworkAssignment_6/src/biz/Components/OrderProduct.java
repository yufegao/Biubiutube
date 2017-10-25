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

    public OfferProduct getOfferProduct() {
        return offerProduct;
    }

    public void setOfferProduct(OfferProduct offerProduct) {
        this.offerProduct = offerProduct;
    }
    
    public double getReward() {
        return (this.getActualPrice() - this.getOfferProduct().getProduct().getFactoryPrice()) * this.getQuantity() *0.05;
    }
    
    public double getRevenue() {
        return (this.getActualPrice() -  this.getOfferProduct().getProduct().getFactoryPrice()) * this.getQuantity();
    }
    
    public double getGap() {
        return (this.getActualPrice() - this.getOfferProduct().getTargetPrice()) * this.getQuantity();
    }
    
    @Override
    public String toString() {
        return offerProduct.getProduct().toString();
    }
}
