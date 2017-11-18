/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.unv;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.producerRole.CollegeLecturerRole;
import biz.role.supervisorRole.UniversityDepartmentSupervisorRole;

import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class UniverseCollegeOrganization extends Organization {
    private ArrayList<Role> supportedRoles;

    private CollegeLecturerRole collegeLecturerRole;
    private UniversityDepartmentSupervisorRole universityDepartmentSupervisorRole;

    public UniverseCollegeOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
        supportedRoles = new ArrayList<>();
        collegeLecturerRole = new CollegeLecturerRole();
        universityDepartmentSupervisorRole = new UniversityDepartmentSupervisorRole();

        supportedRoles.add(collegeLecturerRole);
        supportedRoles.add(universityDepartmentSupervisorRole);
    }

    public CollegeLecturerRole getCollegeLecturerRole() {
        return collegeLecturerRole;
    }

    public UniversityDepartmentSupervisorRole getUniversityDepartmentSupervisorRole() {
        return universityDepartmentSupervisorRole;
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
        return supportedRoles;
    }
    
}
