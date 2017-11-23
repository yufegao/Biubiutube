package biz.enterprises;

import biz.nw.Network;
import biz.org.Organization;
import biz.org.adc.AdvertiseAccountingOrganization;
import biz.org.adc.AdvertiseAdminOrganization;
import biz.org.adc.AdvertiseProduceOrganization;
import biz.org.adc.AdvertiseProduceOrganizationCatalog;
import biz.org.adc.AdvertiseSupervisorOrganization;
import java.util.ArrayList;

public class AdCompanyEnterprise extends Enterprise {

    private AdvertiseAccountingOrganization aAccount;
    private AdvertiseAdminOrganization aAdmin;
    private AdvertiseProduceOrganizationCatalog aPCatalog;
    private AdvertiseSupervisorOrganization aSupervisor;
    private ArrayList<Organization> organizations;
    public AdCompanyEnterprise(String name, Network network) {
        super(name, network);
        this.aPCatalog = new AdvertiseProduceOrganizationCatalog(this);
        
        this.aAccount = new AdvertiseAccountingOrganization(name + "AdvertiseAccountingOrganization", this);
        this.aAdmin = new AdvertiseAdminOrganization(name + "AdvertiseAdminOrganization", this);
        this.aSupervisor = new AdvertiseSupervisorOrganization(name + "AdvertiseSupervisorOrganization", this);
        this.organizations = new ArrayList<>();
        organizations.add(aAdmin);
        organizations.add(aSupervisor);
        organizations.add(aAccount);
        for(Organization o : aPCatalog.getOrganizations()){
            organizations.add(o);
        }
        
    }

    public AdvertiseAccountingOrganization getaAccount() {
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

    public ArrayList<Organization> getOrganizations() {
        return organizations;
    }
    
    
}
