/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.Components;

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

    private Business() {
        this.accountCatalog = new AccountCatalog();
        this.bossCatalog = new BossCatalog();
        this.salesPersonCatalog = new SalesPersonCatalog();
        this.marketCatalog = new MarketCatalog();
        this.supplierCatalog = new SupplierCatalog();
        this.marketOfferCatalog = new MarketOfferCatalog();
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
}
