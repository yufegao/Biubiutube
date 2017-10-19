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
public class Product {
    private String ProductName;
    private String ProductNumber;
    private int FactoryPrice;
    

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getProductNumber() {
        return ProductNumber;
    }

    public void setProductNumber(String ProductNumber) {
        this.ProductNumber = ProductNumber;
    }

    public int getFactoryPrice() {
        return FactoryPrice;
    }

    public void setFactoryPrice(int FactoryPrice) {
        this.FactoryPrice = FactoryPrice;
    }
    
}
