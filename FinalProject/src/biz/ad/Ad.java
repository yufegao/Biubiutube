package biz.ad;

import biz.account.Account;
import biz.role.producerRole.AdvertisementProducerRole;
import biz.role.producerRole.NoneProfitProducerRole;

public class Ad {
    private Account producer;
    private AdStatus status;
    private AdType type;

    public enum AdStatus {
        Produced("Produced", "Ad is produced, waiting organization supervisor to approve."),
        OSApproved("Organization Supervisor Approved", "Ad is approved by department supervisor, waiting enterprise supervisor to approve."),
        ESApproved("Enterprise Supervisor Approved", "Ad is approved by enterprise supervisor, ready to go.");

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

    Ad(Account account) {
        this.producer = account;
        this.status = AdStatus.Produced;
        if (account.getRole() instanceof NoneProfitProducerRole) {
            this.type = AdType.PSAd;
        } else if (account.getRole() instanceof AdvertisementProducerRole) {
            this.type = AdType.CommercialAd;
        }
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
}
