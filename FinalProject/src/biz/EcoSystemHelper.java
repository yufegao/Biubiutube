package biz;

import biz.account.Account;
import biz.nw.Network;
import biz.org.unv.UniverseCollegeOrganization;
import biz.person.Person;

public class EcoSystemHelper {
    public static EcoSystem configure() {
        EcoSystem system = EcoSystem.getInstance();
        Network nw = system.newNetwork("NEU");
        UniverseCollegeOrganization coe = nw.getUniversity().getCollegeCatalog().newOrganization("COE");

        Person person;
        Account account;

        person = system.getSystemPersonCatalog().newPerson("Andy", "Zhao");
        try {
            system.getSystemAccountCatalog().newAccount("admin", "admin", system.getSystemAdminRole(), person);
        } catch (Exception ignored) {}

        person = coe.getPersonCatalog().newPerson("Bruce", "Qian");
        try {
            coe.getAccountCatalog().newAccount("mls", "mls", coe.getCollegeLecturerRole(), person);
            coe.getAccountCatalog().newAccount("mlsa", "mlsa", coe.getUniversityDepartmentSupervisorRole(), person);
        } catch (Exception ignored) {}

        person = coe.getPersonCatalog().newPerson("Cathy", "Sun");
        try {
            coe.getAccountCatalog().newAccount("sls", "sls", coe.getCollegeLecturerRole(), person);
        } catch (Exception ignored) {}

        return system;
    }
}
