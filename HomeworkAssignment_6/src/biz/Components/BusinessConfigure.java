/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.Components;

import java.util.Random;

/**
 *
 * @author hezj
 */
public class BusinessConfigure {
    public static void configure() {
        Business business = Business.getInstance();
        
        Random rand = new Random();

        for (int i = 1; i <= 3; i++) {
            Boss b = business.getBossCatalog().newElement();
            b.setName(String.format("BossName%s", i));
            b.setUsername(String.format("Boss%d", i));
            b.setPassword(String.format("%d", i));
            business.getAccountCatalog().addElement(b);
        }

        for (int i = 1; i <= 3; i++) {
            SalesPerson s = business.getSalesPersonCatalog().newElement();
            s.setFirstName(String.format("First%d", i));
            s.setLastName(String.format("Last%d", i));
            s.setUsername(String.format("SalesPerson%d", i));
            s.setPassword(String.format("%s", i));
            business.getAccountCatalog().addElement(s);
        }

        for (int i = 1; i <= 3; i++) {
            Supplier s = business.getSupplierCatalog().newElement();
            s.setAddress(String.format("Address%s", i));
            s.setName(String.format("SupplierName%s", i));
            s.setUsername(String.format("Supplier%s", i));
            s.setPassword(String.format("%s", i));
            business.getAccountCatalog().addElement(s);
                        
            for (int j = 1; j <= 10; j++) {
                Product p = s.getProductCatalog().newElement();
                p.setProductName(String.format("Product%d", j));
                p.setProductNumber(String.format("Number%d", j));
                p.setFactoryPrice(rand.nextDouble() * 1000);
                p.setStock(rand.nextInt(100));
          }
        }

        for (int i = 1; i <= 3; i++) {
            Market m = business.getMarketCatalog().newElement();
            m.setMarketName(String.format("Market%s", i));
            m.setMarketValue(((double) i) / 2);

            for (int j = 1; j <= 5; j++) {
                Customer c = m.newElement();
                c.setName(String.format("Customer%d-%d", i, j));
            }
        }

        
        for (SalesPerson salesPerson: Business.getInstance().getSalesPersonCatalog().getElementArrayList()){
            for (Customer customer: Business.getInstance().getAllCustomers()){
                int numOfOrders = rand.nextInt(5);
                for (int i = 0; i < numOfOrders; i++) {
                    Order order = Business.getInstance().getOrderDirectory().newElement();
                    order.setBoughtBy(customer);
                    order.setSoldBy(salesPerson);
                    order.setStatus("Placed");
                    for (Product product: Business.getInstance().getAllProducts()) {
                        if (rand.nextDouble() < 0.01) {  // 1% chance to purchase this product
                            MarketOffer marketOffer = Business.getInstance().getMarketOfferCatalog().findElement(mo -> mo.getMarket().equals(customer.getMarket()));
                            OfferProduct offerProduct = marketOffer.findElement(op -> op.getProduct().equals(product));
                            OrderProduct orderProduct = order.newElement();
                            orderProduct.setOfferProduct(offerProduct);
                            orderProduct.setQuantity(rand.nextInt(10) + 1); // 1 ~ 10
                            double orderRate = rand.nextDouble() * (3.0 - 0.8) + 0.8;
                            orderProduct.setActualPrice(orderRate * offerProduct.getTargetPrice());  // FIXME: NPE here
                        }
                    }
                    if (order.getElementArrayList().size() == 0) {
                        Business.getInstance().getOrderDirectory().removeElement(order);
                    }
                }
            }
        }
    }
}
