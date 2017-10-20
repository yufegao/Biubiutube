/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.Components;

/**
 *
 * @author hezj
 */
public class BusinessConfigure {
    public static void configure() {
        Business business = Business.getInstance();
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
    }
}
