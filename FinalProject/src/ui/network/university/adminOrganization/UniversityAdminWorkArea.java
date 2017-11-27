/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.university.adminOrganization;

import biz.account.Account;
import java.util.ArrayList;
import javax.swing.JButton;
import ui.components.GeneralWorkArea;
import ui.components.ParentUI;

/**
 *
 * @author royn
 */
public class UniversityAdminWorkArea extends GeneralWorkArea{

    public UniversityAdminWorkArea(ParentUI parent, Account account) {
        super(parent, account);
    }

    @Override
    protected ArrayList<JButton> getButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        
        JButton btn1 = new JButton("Manage Account");
        btn1.addActionListener(e -> parent.pushComponent(new ManageAccount(parent, account)));
        
        JButton btn2 = new JButton("Manage Account");
        btn1.addActionListener(e -> parent.pushComponent(new ManagePerson(parent, account)));
        
        buttons.add(btn1);
        buttons.add(btn2);
        
        return buttons;
    }

    @Override
    public String getTitle() {
        return String.format("Admin Person and Account of %s", account.getOrg().getEnterprise());
    }
    
}
