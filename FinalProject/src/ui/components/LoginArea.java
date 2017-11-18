/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import biz.EcoSystem;
import biz.account.Account;

import javax.swing.*;

/**
 * @author hezj
 */
public class LoginArea extends javax.swing.JPanel {
    private ParentUI parent;
    private TopBar topBar;

    /**
     * Creates new form LoginArea
     */
    public LoginArea(ParentUI parent, TopBar topBar) {
        this.parent = parent;
        this.topBar = topBar;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Username");
        add(jLabel1);

        txtUsername.setPreferredSize(new java.awt.Dimension(60, 26));
        add(txtUsername);

        jLabel2.setText("Password");
        add(jLabel2);

        txtPassword.setPreferredSize(new java.awt.Dimension(60, 26));
        add(txtPassword);

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        add(btnLogin);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        Account account;
        try {
            account = EcoSystem.getInstance().login(txtUsername.getText(), new String(txtPassword.getPassword()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        parent.pushComponent(account.getRole().createWorkArea(parent, account));
        txtPassword.setText("");
        txtUsername.setText("");
        topBar.loggedIn();
    }//GEN-LAST:event_btnLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
