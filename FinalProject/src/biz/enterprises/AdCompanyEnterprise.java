package biz.enterprises;

import biz.nw.Network;
import biz.org.adc.AdevertiseAccountingOrganization;
import biz.org.adc.AdvertiseAdminOrganization;
import biz.org.adc.AdvertiseProduceOrganization;
import biz.org.adc.AdvertiseProduceOrganizationCatalog;
import biz.org.adc.AdvertiseSupervisorOrganization;

public class AdCompanyEnterprise extends Enterprise {
    // TODO: org and orgCatalog here
    private AdevertiseAccountingOrganization aAccount;
    private AdvertiseAdminOrganization aAdmin;
    private AdvertiseProduceOrganization aProduce;
    private AdvertiseProduceOrganizationCatalog aPCatalog;
    private AdvertiseSupervisorOrganization aSupervisor;
    public AdCompanyEnterprise(String name, Network network) {
        super(name, network);
    }
}
