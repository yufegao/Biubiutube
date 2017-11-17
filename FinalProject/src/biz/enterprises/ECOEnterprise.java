package biz.enterprises;

import biz.nw.Network;
import biz.org.eco.ECOAdminOrganization;
import biz.org.eco.ECOSupervisorOrganization;
import biz.org.eco.ECOVideoProducerOrganizationCatalog;

public class ECOEnterprise extends Enterprise {
    // TODO: org and orgCatalog here
    private ECOVideoProducerOrganizationCatalog ecovpoc;
    private ECOSupervisorOrganization ecoso;
    private ECOAdminOrganization ecoao;
    public ECOEnterprise(String name, Network network) {
        super(name, network);
        this.ecovpoc = new ECOVideoProducerOrganizationCatalog(this);
        
        this.ecoso = new ECOSupervisorOrganization(name + "ECOSupervisorOrganization", this);
        this.ecoao = new ECOAdminOrganization(name + "ECOAdminOrganization", this);
    }

    public ECOVideoProducerOrganizationCatalog getEcovpoc() {
        return ecovpoc;
    }

    public ECOSupervisorOrganization getEcoso() {
        return ecoso;
    }

    public ECOAdminOrganization getEcoao() {
        return ecoao;
    }
    
    
    
}
