/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz;

import biz.ctlg.AbstractCatalog;

/**
 *
 * @author Administrator
 */
public class BusinessCatalog extends AbstractCatalog<Business>{

    @Override
    public Business createElement() {
       return Business.getInstance();
    }
    
}
