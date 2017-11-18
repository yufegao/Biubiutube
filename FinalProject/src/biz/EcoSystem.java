/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz;

import biz.enterprises.Enterprise;
import biz.nw.Network;
import biz.org.Organization;
import biz.role.Role;
import biz.role.Role.RoleType;
import biz.role.adminRole.SystemAdminRole;
import biz.role.customerServiceRole.CensorRole;
import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class EcoSystem {

    private static EcoSystem system;
    private ArrayList<Network> networks;
    
    private EcoSystem(){
        networks = new ArrayList<>();
    }
    
    public static EcoSystem geEcoSystem(){
        if(system == null){
            system = new EcoSystem();
        }
        return system;
    }
    
    public Network createAndAddNetwork(String name){
        Network network = new Network(name);
        networks.add(network);
        return network;
    }
    
    public ArrayList<Role> getSupportedRole(RoleType type){
        ArrayList<Role> roleList = new ArrayList<>();
        if(type.getRoletype().equals(RoleType.SysAdmin.getRoletype())){
            roleList.add(new SystemAdminRole());
        }else if(type.getRoletype().equals(RoleType.CensorRole.getRoletype())){
            roleList.add(new CensorRole());
        }
        return roleList;
    }
}
