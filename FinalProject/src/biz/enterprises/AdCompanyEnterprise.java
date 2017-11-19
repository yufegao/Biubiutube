package biz.enterprises;

import biz.nw.Network;
import biz.org.adc.AdevertiseAccountingOrganization;
import biz.org.adc.AdvertiseAdminOrganization;
import biz.org.adc.AdvertiseProduceOrganization;
import biz.org.adc.AdvertiseProduceOrganizationCatalog;
import biz.org.adc.AdvertiseSupervisorOrganization;

public class AdCompanyEnterprise extends Enterprise {

    private AdevertiseAccountingOrganization aAccount;
    private AdvertiseAdminOrganization aAdmin;
    private AdvertiseProduceOrganizationCatalog aPCatalog;
    private AdvertiseSupervisorOrganization aSupervisor;
    public AdCompanyEnterprise(String name, Network network) {
        super(name, network);
        this.aPCatalog = new AdvertiseProduceOrganizationCatalog(this);
        
        this.aAccount = new AdevertiseAccountingOrganization(name + "AdvertiseAccountingOrganization", this);
        this.aAdmin = new AdvertiseAdminOrganization(name, this);
        this.aSupervisor = new AdvertiseSupervisorOrganization(name, this);
    }

    public AdevertiseAccountingOrganization getaAccount() {
        return aAccount;
    }

    public AdvertiseAdminOrganization getaAdmin() {
        return aAdmin;
    }

    public AdvertiseProduceOrganizationCatalog getaPCatalog() {
        return aPCatalog;
    }

    public AdvertiseSupervisorOrganization getaSupervisor() {
        return aSupervisor;
    }
    
}
