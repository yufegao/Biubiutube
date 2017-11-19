package biz.enterprises;

import biz.nw.Network;
import biz.org.unv.*;

public class UniversityEnterprise extends Enterprise {
    private UniverseCollegeOrganizationCatalog collegeCatalog;
    private UniverseSupervisorOrganization supervisorOrganization;
    private UniverseDirectorateOrganization directorateOrganization;
    private UniverseSalesDepartmentOrganization salesDepartmentOrganization;
    private UniverseAdminOrganization adminOrganization;
    private UniverseAccountingOrganization accountingOrganization;

    public UniversityEnterprise(String name, Network network) {
        super(name, network);
        this.collegeCatalog = new UniverseCollegeOrganizationCatalog(this);

        this.supervisorOrganization = new UniverseSupervisorOrganization(name + " Supervisor Department", this);
        this.directorateOrganization = new UniverseDirectorateOrganization(name + " Board", this);
        this.salesDepartmentOrganization = new UniverseSalesDepartmentOrganization(name + " Sales", this);
        this.adminOrganization = new UniverseAdminOrganization(name + " Admin Organization", this);
        this.accountingOrganization = new UniverseAccountingOrganization(name + " Accounting Organization", this);
    }


    public UniverseSupervisorOrganization getSupervisorOrganization() {
        return supervisorOrganization;
    }

    public UniverseAccountingOrganization getAccountingOrganization() {
        return accountingOrganization;
    }

    public UniverseAdminOrganization getAdminOrganization() {

        return adminOrganization;
    }

    public UniverseSalesDepartmentOrganization getSalesDepartmentOrganization() {

        return salesDepartmentOrganization;
    }

    public UniverseDirectorateOrganization getDirectorateOrganization() {

        return directorateOrganization;
    }

    public UniverseCollegeOrganizationCatalog getCollegeCatalog() {

        return collegeCatalog;
    }
}
