/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.Components;

import biz.Catalog.AbstractCatalog;

/**
 *
 * @author royn
 */
public class ProductCatalog extends AbstractCatalog<Product>{

    @Override
    public Product createElement() {
        return new Product();
    }
    
}
