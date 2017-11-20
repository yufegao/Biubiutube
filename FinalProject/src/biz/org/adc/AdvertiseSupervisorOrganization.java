/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.adc;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.supervisorRole.ADCompanySupervisorRole;
import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class AdvertiseSupervisorOrganization extends Organization {
    private ArrayList<Role> supportedRoles;
    
    private ADCompanySupervisorRole adCompanySupervisorRole;

    public AdvertiseSupervisorOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
        supportedRoles = new ArrayList<>();
        adCompanySupervisorRole = new ADCompanySupervisorRole();
        
        supportedRoles.add(adCompanySupervisorRole);
    }

    public ADCompanySupervisorRole getAdCompanySupervisorRole() {
        return adCompanySupervisorRole;
    }
    
    @Override
    public ArrayList<Role> getSupportedRoles() {
        return supportedRoles;
    }
    
}
