/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.account;

import biz.enterprises.Enterprise;
import biz.orders.OrderCatalog;
import biz.org.Organization;
import biz.role.Role;

/**
 *
 * @author 79813
 */
public class Account {

    private OrderCatalog orderCatalog;
    private int money;
    private Enterprise enterprise;
    private Organization org;
    private String username;
    private String password;
    private boolean isActive;

    private Role role;

    public Account(Organization organization) {
        this.org = organization;
    }

    public OrderCatalog getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(OrderCatalog orderCatalog) {
        this.orderCatalog = orderCatalog;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    
    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Organization getOrg() {
        return org;
    }

    public void setOrg(Organization org) {
        this.org = org;
    }
    
    public Role getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(HashHelper.generateHash(password));
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
