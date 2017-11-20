package biz.ad;

import biz.account.Account;
import biz.role.producerRole.AdvertisementProducerRole;
import biz.role.producerRole.NoneProfitProducerRole;

public class Ad {
    private Account producer;
    private AdStatus status;
    private AdType type;
    private String description;
    private String url;

    public enum AdStatus {
        Produced("Produced", "Ad is produced, waiting organization supervisor to approve."),
        ESApproved("Enterprise Supervisor Approved", "Ad is approved by enterprise supervisor, waiting university supervisor to approve."),
        NSApproved("Network Supervisor Approved", "Ad is approved by network supervisor, ready to go."),
        Banned("Banned", "Advertisement is banned according to censorship");

        private String name;
        private String description;

        AdStatus(String name, String description) {
            this.name = name;
            this.description = description;
        }
    }

    public enum AdType {
        CommercialAd("Commercial Advertisement"),
        PSAd("Public Service Advertisement");

        private String name;

        AdType(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    Ad(Account account) {
        this.producer = account;
        this.status = AdStatus.Produced;
        if (account.getRole() instanceof NoneProfitProducerRole) {
            this.type = AdType.PSAd;
        } else if (account.getRole() instanceof AdvertisementProducerRole) {
            this.type = AdType.CommercialAd;
        }
        this.description = "";
    }

    public AdStatus getStatus() {
        return status;
    }

    public void setStatus(AdStatus status) {
        this.status = status;
    }

    public Account getProducer() {
        return producer;
    }

    public AdType getType() {
        return type;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
