/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.university.supervisorOrganization;

import biz.account.Account;
import java.util.ArrayList;
import javax.swing.JButton;
import ui.components.GeneralWorkArea;
import ui.components.ParentUI;
import ui.network.university.college.departmentSupervisor.CensorVideos;

/**
 *
 * @author hezj
 */
public class UniversitySupervisorWorkArea extends GeneralWorkArea {

    public UniversitySupervisorWorkArea(ParentUI parent, Account account) {
        super(parent, account);
    }

    @Override
    protected ArrayList<JButton> getButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        
        JButton button;
        button = new JButton(String.format("Censor Video Uploaded in %s", account.getOrg().getEnterprise()));
        button.addActionListener(e -> parent.pushComponent(new CensorVideos(parent, account)));
        buttons.add(button);
        
        button = new JButton(String.format("Manage Signup Request in %s", account.getOrg().getEnterprise()));
        button.addActionListener(e -> parent.pushComponent(new ManageSignup(parent, account)));
        buttons.add(button);
        
        return buttons;
    }

    @Override
    public String getTitle() {
        return String.format("%s Supervisor Work Area", account.getOrg().getEnterprise());
    }
    
}
