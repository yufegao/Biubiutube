package biz.ad;


import biz.account.Account;
import biz.nw.Network;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

public class AdCatalog {
    private Network network;
    private ArrayList<Ad> adArrayList;
    private Random ranrom;

    public AdCatalog(Network network) {
        this.network = network;
        this.adArrayList = new ArrayList<>();
        ranrom = new Random();
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

    public Stream<Ad> getStream(Ad.AdType type) {
        return adArrayList.stream().filter(ad -> ad.getType().equals(type));
    }

    // TODO: probability
    public Ad randomAd(Ad.AdType type) {
        long c = getStream(type).count();
        if (c == 0) {
            return null;
        }
        int i = ranrom.nextInt((int) c);
        return getStream(type).skip(i).findFirst().orElse(null);
    }

    public Ad randomAd() {
        return adArrayList.get(ranrom.nextInt(adArrayList.size()));
    }
}
