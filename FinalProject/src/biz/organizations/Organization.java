/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.organizations;

import biz.account.AccountCatalog;
import biz.person.PersonCatalog;
import biz.role.Role;
import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public abstract class Organization {
    private String name;
    private PersonCatalog personCatalog;
    private AccountCatalog accountCatalog;
    
    public enum organizationType{
        ECOCollege("ECOCollege"),ECOSupervisor("ECOSupervisor"),ECOAdmin("ECOAdmin"),
        UniverseCollege("UniverseCollege"),UniverseSupervisor("UniverseSupervisor"),
        UniverseDirectorate("UniverseDirectorate"),UniverseSalesDepartment("UniverseSalesDepartment"),
        UniverseAdmin("UniverseAdmin"),UniverseAccounting("UniverseAccounting"),
        AdvertiseProduce("AdvertiseProduce"),AdvertiseSupervisor("AdvertiseSupervisor"),
        AdvertiseAdmin("AdvertiseAdmin"),AdevertiseAccounting("AdevertiseAccounting"),
        NonProPSA("NonProPSA"),NonProSupervisor("NonProSupervisor"),NonProAdmin("NonProAdmin");
        private String typeName;
        private organizationType(String type){
            this.typeName = type;
        }
        public String getTypeName(){
            return typeName;
        }
    }
    
    public Organization(String name){
        this.name = name;
        personCatalog = new PersonCatalog();
        accountCatalog = new AccountCatalog();
    }
    
    public abstract ArrayList<Role> getRole();

    public String getName() {
        return name;
    }

    public PersonCatalog getPersonCatalog() {
        return personCatalog;
    }

    public AccountCatalog getAccountCatalog() {
        return accountCatalog;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
