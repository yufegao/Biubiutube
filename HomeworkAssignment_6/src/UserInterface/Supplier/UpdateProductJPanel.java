/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Supplier;

import biz.Components.Product;

/**
 *
 * @author royn
 */
public class UpdateProductJPanel extends javax.swing.JPanel {
    private Product product;

    /**
     * Creates new form CreateProduct
     */
    public UpdateProductJPanel(Product product) {
        initComponents();
        this.product = product;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtProductNumber = new javax.swing.JTextField();
        txtFactoryPrice = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Factory Price");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 110, 30));

        jLabel4.setText("Product Number");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 120, 30));

        jLabel6.setText("Name");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 70, 30));
        add(txtProductNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 170, -1));
        add(txtFactoryPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 170, -1));
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 170, -1));

        btnSave.setText("Save");
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 170, 50));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtFactoryPrice;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtProductNumber;
    // End of variables declaration//GEN-END:variables
}