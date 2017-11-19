package biz.enterprises;

import biz.nw.Network;
import biz.org.npo.NPOOrganizationCatalog;
import biz.org.npo.NonProAdminOrganization;
import biz.org.npo.NonProSupervisorOrganization;

public class NPOEnterprise extends Enterprise {

    private NonProAdminOrganization npoa;
    private NPOOrganizationCatalog npooc;
    private NonProSupervisorOrganization nposo;
    public NPOEnterprise(String name, Network network) {
        super(name, network);
        this.npooc = new NPOOrganizationCatalog(this);
        
        this.nposo = new NonProSupervisorOrganization(name + "NonProSupervisorOrganization", this);
        this.npoa = new NonProAdminOrganization(name + "NonProAdminOrganization", this);
    }

    public NonProAdminOrganization getNpoa() {
        return npoa;
    }

    public NPOOrganizationCatalog getNpooc() {
        return npooc;
    }

    public NonProSupervisorOrganization getNposo() {
        return nposo;
    }
    
}
