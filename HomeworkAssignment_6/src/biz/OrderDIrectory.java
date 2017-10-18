/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz;

import biz.ctlg.AbstractCatalog;

/**
 *
 * @author royn
 */
public class OrderDIrectory extends AbstractCatalog<Order>{    

    @Override
    public Order createElement() {
        return new Order();
    }
    
}
