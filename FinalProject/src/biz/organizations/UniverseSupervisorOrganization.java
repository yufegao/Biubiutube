/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.organizations;

import biz.role.Role;
import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class UniverseSupervisorOrganization extends Organization{

    public UniverseSupervisorOrganization() {
        super(organizationType.UniverseSupervisor.getTypeName());
    }

    @Override
    public ArrayList<Role> getRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
