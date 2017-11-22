/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.adc;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.adminRole.AdvertisingAdminRole;
import biz.role.producerRole.AdvertisementProducerRole;
import biz.role.supervisorRole.ADCompanySupervisorRole;
import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class AdvertiseAdminOrganization extends Organization {
    private AdvertisementProducerRole producer;
    private ADCompanySupervisorRole supervisor;
    private AdvertisingAdminRole admin;
    private ArrayList<Role> roles;
    public AdvertiseAdminOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
        producer = new AdvertisementProducerRole();
        supervisor = new ADCompanySupervisorRole();
        admin = new AdvertisingAdminRole();
        roles = new ArrayList<>();
        
        roles.add(admin);
        roles.add(supervisor);
        roles.add(producer);
        
        
    }

    public AdvertisementProducerRole getProducer() {
        return producer;
    }

    public ADCompanySupervisorRole getSupervisor() {
        return supervisor;
    }

    public AdvertisingAdminRole getAdmin() {
        return admin;
    }
    
    

    @Override
    public ArrayList<Role> getSupportedRoles() {
        return roles;
    }
    
}
