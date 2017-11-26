package biz.enterprises;

import biz.nw.Network;
import biz.org.Organization;

import java.util.ArrayList;

public abstract class Enterprise {
    private Network network;
    private String name;
    

    public Enterprise(String name, Network network) {
        this.network = network;
        this.name = name;
    }

    public Network getNetwork() {
        return network;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract ArrayList<Organization> getOrganizationArrayList();

    @Override
    public String toString() {
        return name;
    }
}
