/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.account;

import biz.enterprises.Enterprise;
import biz.orders.OrderCatalog;
import biz.role.Role.RoleType;

/**
 *
 * @author 79813
 */
public abstract class Account {
    private OrderCatalog orderCatalog;
    private int money;
    private RoleType roleType;
    private Enterprise enterprise;
    
    
}
