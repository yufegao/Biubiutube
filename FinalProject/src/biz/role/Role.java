/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.role;

import biz.account.Account;
import javax.swing.JPanel;
import ui.components.ParentUI;

/**
 *
 * @author 79813
 */
public abstract class Role {
//    public enum RoleType{
//        SysAdmin("SysAdmin"),CensorRole("CensorRole"),ECOLecturer("Lecturer"),ECODepartSupervisor("ECODepartSupervisor"),
//        ECOSupervisor("ECOSupervisor"),ECOAdmin("ECOAdmin"),UniversityViewer("UniversityCollegeViewer"),
//        UniversityLecture("UniversityCollegeLecture"),UniversityDepartmentSupervisor("UniversityDepartmentSupervisor"),
//        UniversitySupervisor("UniversitySupervisor"),UniversityDirector("UniversityDirector"),UniversitySalesManger("UniversitySalesManger"),
//        UniversitySalesPerson("UniversitySalesPerson"),UniversityAdmin("UniversityAdmin"),UniversityAccountManager("UniversityAccountManager"),
//        UniversityAccounting("UniversityAccounting"),AdvertiseProducer("AdvertiseProducer"),AdvertiseDepartmentSupervisor("AdvertiseDepartmentSupervisor"),
//        AdvertiseCompanySupervisor("AdvertiseCompanySupervisor"),AdvertiseAdmin("AdvertiseAdmin"),AdvertiseAccounting("AdvertiseAccounting"),
//        NonProProducer("NonProProducer"),NonProDepartmentSupervisor("NonProDepartmentSupervisor"),NonProCompanySupervisor("NonProCompanySupervisor"),
//        NonProAdmin("NonProAdmin"),AnonymosViewer("AnonymosViewer");
//        private String type;
//        private RoleType(String name){
//            this.type = name;
//        }
//        public String getRoletype(){
//            return type;
//        }
//        @Override
//        public String toString(){
//            return type;
//        }
//    }
    
    public abstract JPanel createWorkArea(ParentUI parent, Account account);
    
    @Override
    public String toString(){
        return this.getClass().getSimpleName().substring(0, this.getClass().getSimpleName().length()-4);
    }
}
