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
public class MarketOfferDirectory extends AbstractCatalog<MarketOffer> {

    @Override
    public MarketOffer createElement() {
        return new MarketOffer();
    }
    
}
