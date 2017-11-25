/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.adc;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.producerRole.AdvertisementProducerRole;
import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class AdvertiseProduceOrganization extends Organization {

    public AdvertiseProduceOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AdvertisementProducerRole());
        return roles;
        //TODO maybe wrong;
    }
    
}
