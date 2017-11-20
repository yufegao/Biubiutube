/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.adc;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class AdvertiseAccountingOrganization extends Organization {

    public AdvertiseAccountingOrganization(String name, Enterprise enterprise) {
       super(name,enterprise);
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
