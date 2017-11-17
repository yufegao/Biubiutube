package biz.org.eco;

import biz.enterprises.Enterprise;
import biz.org.OrganizationCatalog;

public class ECOOrganizationCatalog extends OrganizationCatalog<ECOCollegeOrganization> {

    public ECOOrganizationCatalog(Enterprise enterprise) {
        super(enterprise);
    }

    @Override
    public ECOCollegeOrganization newOrganization(String name) {
        ECOCollegeOrganization ecoco = new ECOCollegeOrganization(name, enterprise);
        this.organizations.add(ecoco);
        return ecoco;
    }
}
