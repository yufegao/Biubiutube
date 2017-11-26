/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.university.accountingOrganization;

import biz.account.Account;
import java.util.ArrayList;
import javax.swing.JButton;
import ui.components.GeneralWorkArea;
import ui.components.ParentUI;

/**
 *
 * @author royn
 */
public class UniversityAccountingWorkArea extends GeneralWorkArea{

    public UniversityAccountingWorkArea(ParentUI parent, Account account) {
        super(parent, account);
    }
    
    @Override
    protected ArrayList<JButton> getButtons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTitle() {
        return String.format("%s Accounting Summary", account.getOrg().getEnterprise().getNetwork());
    }
    
}
