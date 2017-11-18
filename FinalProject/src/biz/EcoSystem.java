/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz;

import biz.nw.Network;
import biz.role.Role;
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
    private ArrayList<Role> roleList;
        private EcoSystem(){
        networks = new ArrayList<>();
        roleList = new ArrayList<>();
    }
    
    public static EcoSystem getInstance(){
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
    
    public ArrayList<Role> getSupportedAdminRole(){
        
        roleList.add(new SystemAdminRole());       
        return roleList;
    }
    public ArrayList<Role> getSupportedCensorRole(){
        roleList.add(new CensorRole());
        return roleList;
    }
}
