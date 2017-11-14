/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.role;

import javax.swing.JPanel;
import ui.ParentUI;

/**
 *
 * @author 79813
 */
public abstract class Role {
    public enum RoleType{
        
    }
    
    public abstract JPanel createWorkArea(ParentUI parent, Account account);
}
