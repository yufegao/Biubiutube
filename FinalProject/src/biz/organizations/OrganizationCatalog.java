/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.organizations;

import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class OrganizationCatalog {
    private ArrayList<Organization> organizations;

    public OrganizationCatalog() {
        organizations = new ArrayList<>();
    }
    
    public ArrayList<Organization> getOrganizations() {
        return organizations;
    }

    public Organization createAndAddOrganization(){
        Organization organization = null;
        
        return organization;
    }
    
}
