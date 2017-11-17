package biz.ad;


import biz.account.Account;
import biz.nw.Network;

import java.util.ArrayList;

public class AdCatalog {
    private Network network;
    private ArrayList<Ad> adArrayList;

    public AdCatalog(Network network) {
        this.network = network;
        this.adArrayList = new ArrayList<>();
    }

    public Ad newAd(Account account) {
        Ad ad = new Ad(account);
        this.adArrayList.add(ad);
        return ad;
    }

    public Network getNetwork() {
        return network;
    }

    public ArrayList<Ad> getAdArrayList() {
        return adArrayList;
    }
}
