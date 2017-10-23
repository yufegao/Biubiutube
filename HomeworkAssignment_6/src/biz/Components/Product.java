
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
    private double FactoryPrice;
    private Supplier supplier;
    private boolean isAvailable = true;
    private int stock = 0;

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Product(Supplier supplier) {
        this.supplier = supplier;
    }
    
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

    public double getFactoryPrice() {
        return FactoryPrice;
    }

    public void setFactoryPrice(double FactoryPrice) {
        this.FactoryPrice = FactoryPrice;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return ProductName;
    }
    
    public double getProductRevenue(){
        double res = 0;

        for (Order order: Business.getInstance().getOrderDirectory().getElementArrayList()) {
            boolean hasProduct = false;
            for (OrderProduct orderProduct: order.getElementArrayList()) {
                if (orderProduct.getOfferProduct().getProduct().equals(this)) {
                    hasProduct = true;
                    break;
                }
            }
            if (hasProduct) {
                res += order.getRevenue();
            }
        }
        return res;
    }
    
}
