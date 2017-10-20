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
    }

    public static Business getInstance() {
        if (business == null) {
            business = new Business();
        }
        return business;
    }
    
    public static Business configureBusiness() {
        Business business = getInstance();
        Boss b1 = business.getBossCatalog().newElement();
        b1.setUsername("Boss1");
        b1.setPassword("1");
        
        Supplier s1 = business.getSupplierCatalog().newElement();
        
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
