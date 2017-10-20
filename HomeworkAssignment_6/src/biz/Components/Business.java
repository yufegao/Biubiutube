/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.Components;

import biz.Catalog.Finder;
import java.util.ArrayList;

/**
 * Business Singleton
 * @author hezj
 */
public class Business {
    private static Business business;
    private AccountCatalog accountCatalog;
    private BossCatalog bossCatalog;
    private SalesPersonCatalog salesPersonCatalog;
    private MarketCatalog marketCatalog;
    private SupplierCatalog supplierCatalog;
    private MarketOfferCatalog marketOfferCatalog;
    private OrderDirectory orderDirectory;

    private Business() {
        this.accountCatalog = new AccountCatalog();
        this.bossCatalog = new BossCatalog();
        this.salesPersonCatalog = new SalesPersonCatalog();
        this.marketCatalog = new MarketCatalog();
        this.supplierCatalog = new SupplierCatalog();
        this.marketOfferCatalog = new MarketOfferCatalog();
        this.orderDirectory = new OrderDirectory();
        
        for (int i = 1; i <= 3; i++) {
            Boss b = this.bossCatalog.newElement();
            b.setName(String.format("BossName%s", i));
            b.setUsername(String.format("Boss%d", i));
            b.setPassword(String.format("%d", i));
            this.accountCatalog.addElement(b);
        }
        
        for (int i = 1; i <= 3; i++) {
            SalesPerson s = this.salesPersonCatalog.newElement();
            s.setFirstName(String.format("First%d", i));
            s.setLastName(String.format("Last%d", i));
            s.setUsername(String.format("SalesPerson%d", i));
            s.setPassword(String.format("%s", i));
            this.accountCatalog.addElement(s);
        }
        
        for (int i = 1; i <= 3; i++) {
            Supplier s = this.supplierCatalog.newElement();
            s.setAddress(String.format("Address%s", i));
            s.setName(String.format("SupplierName%s", i));
            s.setUsername(String.format("Supplier%s", i));
            s.setPassword(String.format("%s", i));
            this.accountCatalog.addElement(s);
        }
        
        for (int i = 1; i <= 3; i++) {
            Market m = this.marketCatalog.createElement();
            m.setMarketName(String.format("Market%s", i));
            m.setMarketValue(((double) i) / 2);
            
            for (int j = 1; j <= 5; j++) {
                Customer c = m.newElement();
                c.setName(String.format("Customer%d-%d", i, j));
            }
        }
    }

    public static Business getInstance() {
        if (business == null) {
            business = new Business();
        }
        return business;
    }
    
    public AccountCatalog getAccountCatalog() {
        return accountCatalog;
    }

    public BossCatalog getBossCatalog() {
        return bossCatalog;
    }

    public SalesPersonCatalog getSalesPersonCatalog() {
        return salesPersonCatalog;
    }

    public MarketCatalog getMarketCatalog() {
        return marketCatalog;
    }

    public SupplierCatalog getSupplierCatalog() {
        return supplierCatalog;
    }

    public MarketOfferCatalog getMarketOfferCatalog() {
        return marketOfferCatalog;
    }

    public OrderDirectory getOrderDirectory() {
        return orderDirectory;
    }
    
    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> result = new ArrayList<>();
        for (Market m: marketCatalog.getElementArrayList()) {
            result.addAll(m.getElementArrayList());
        }
        return result;
    }
    
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> result = new ArrayList<>();
        for (Supplier s: supplierCatalog.getElementArrayList()) {
            result.addAll(s.getProductCatalog().getElementArrayList());
        }
        return result;
    }
    
    public ArrayList<Product> findProducts(Finder<Product> finder) {
        ArrayList<Product> result = new ArrayList<>();
        for (Supplier s: supplierCatalog.getElementArrayList()) {
            result.addAll(s.getProductCatalog().findElements(finder));
        }
        return result;
    }
}
