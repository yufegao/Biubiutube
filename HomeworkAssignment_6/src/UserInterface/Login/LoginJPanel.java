/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Login;

/**
 *
 * @author royn
 */
public class LoginJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginJPanel
     */
    public LoginJPanel() {
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
        jLabel2 = new javax.swing.JLabel();
        txtAccount = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogIn = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Account");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 80, 30));

        jLabel2.setText("Password");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 80, 30));
        add(txtAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 200, -1));
        add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 200, -1));

        btnLogIn.setText("Log in");
        add(btnLogIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 180, 40));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtAccount;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
