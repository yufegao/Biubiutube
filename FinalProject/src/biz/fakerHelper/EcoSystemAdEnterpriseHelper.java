/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.fakerHelper;

import biz.account.Account;
import biz.enterprises.AdCompanyEnterprise;
import static biz.fakerHelper.EcoSystemCommonHelper.fakeAccount;
import static biz.fakerHelper.EcoSystemCommonHelper.fakePerson;
import biz.nw.Network;
import biz.person.Person;
import com.github.javafaker.Faker;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author royn
 */
public class EcoSystemAdEnterpriseHelper {

    private static Faker faker = new Faker();
    private static String[] videoURLs = new String[]{
        "https://www.youtube.com/embed/K9vFWA1rnWc",
        "https://www.youtube.com/embed/R59TevgzN3k"
    };
    private static String[] picPaths = new String[]{ // TODO: more pic path
        "https://i.imgur.com/ijtKGes.png"
    };

    public static AdCompanyEnterprise fakeAdEnterprise(Network nw) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String companyName = "C";
        int num = faker.random().nextInt(2) + 2;
        for (int i = 0; i < num; i++) {
            companyName += s.charAt(faker.random().nextInt(s.length()));
        }
        AdCompanyEnterprise adcompany = nw.getAdCompanyCatalog().newEnterprise(companyName);

        Person p = null;
        Account a = null;

        // 1. supervisor
        num = faker.random().nextInt(3) + 1; // 1 ~ 4 supervisor
        for (int i = 0; i < num; i++) {
            p = fakePerson(adcompany.getaSupervisor().getPersonCatalog());
            fakeAccount(adcompany.getaSupervisor().getAccountCatalog(), p, adcompany.getaSupervisor().getAdCompanySupervisorRole());
        }
        // 2. admin
        Person admin = adcompany.getaAdmin().getPersonCatalog().newPerson("Manager", "Wang");
        try {
            Account adminaccount = adcompany.getaAdmin().getAccountCatalog().newAccount("adadmin", "adadmin", adcompany.getaAdmin().getAdmin(), admin);
            
        } catch (Exception ex) {
            Logger.getLogger(EcoSystemAdEnterpriseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adcompany;
    }
}
