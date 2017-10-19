/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz;

/**
 *
 * @author Administrator
 */
public class OfferProduct {
//    private Product product; TODO
    private static int offerId = 0;
    private int highestPrice;
    private int targetPrice;
    private int lowestPrice;
    private int id;

    public OfferProduct() {
        offerId++;
        id = offerId;
    }

    

    public int getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(int highestPrice) {
        this.highestPrice = highestPrice;
    }

    public int getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(int targetPrice) {
        this.targetPrice = targetPrice;
    }

    public int getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(int lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public int getId() {
        return id;
    }
    
    
}
