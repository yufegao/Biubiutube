/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Supplier;

import UserInterface.Components.HasTitle;
import UserInterface.Components.ParentUI;
import biz.Components.Product;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author royn
 */
public class UpdateProductJPanel extends javax.swing.JPanel implements HasTitle{
    private Product product;
    private ButtonGroup as_bg;
    private ParentUI parent;

    /**
     * Creates new form CreateProduct
     */
    public UpdateProductJPanel(ParentUI parent, Product product) {
        initComponents();
        this.product = product;
        this.parent = parent;
        this.as_bg = new ButtonGroup();
        as_bg.add(rbTrue);
        as_bg.add(rbFalse);
        
        refreshComponents();
    }
    
    public void refreshComponents(){
        txtName.setText(product.getProductName());
        txtProductNumber.setText(product.getProductNumber());
        txtFactoryPrice.setText(String.valueOf(product.getFactoryPrice()));
        txtStock.setText(String.valueOf(product.getStock()));
        
        boolean Status = product.isIsAvailable();
        if(Status == true){
            rbTrue.setSelected(true);
        }else{
            rbFalse.setSelected(true);
        }
        
        
        txtName.setEnabled(true);
        txtProductNumber.setEnabled(true);
        txtFactoryPrice.setEnabled(true);
        txtStock.setEnabled(true);
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
        jLabel1 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        rbTrue = new javax.swing.JRadioButton();
        rbFalse = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Factory Price");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 110, 30));

        jLabel4.setText("Product CDKey");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 120, 30));

        jLabel6.setText("Name");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 70, 30));
        add(txtProductNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 170, -1));
        add(txtFactoryPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 170, -1));
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 170, -1));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 170, 50));

        jLabel1.setText("Stock");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 70, -1));
        add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 170, -1));

        rbTrue.setText("Available");
        add(rbTrue, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, -1, -1));

        rbFalse.setText("Unavailable");
        add(rbFalse, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, -1, -1));

        jLabel2.setText("Status");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();
        String productNumber = txtProductNumber.getText();
     
        int factoryPrice;
        try{
            factoryPrice = Integer.parseInt(txtFactoryPrice.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter valid Price!");
            return;
        }
        
        int stock;
        try{
            stock = Integer.parseInt(txtStock.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter valid Price!");
            return;
        }
        
        boolean Status = true;
        if(rbTrue.isSelected() == true){
            Status = true;
        }
        else{
            Status = false;
        }
        
        product.setProductName(name);
        product.setProductNumber(productNumber);
        product.setFactoryPrice(factoryPrice);
        product.setStock(stock);
        product.setIsAvailable(Status);
        
        txtName.setEnabled(false);
        txtProductNumber.setEnabled(false);
        txtFactoryPrice.setEnabled(false);
        
        JOptionPane.showMessageDialog(null, "Product update successfully!");
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton rbFalse;
    private javax.swing.JRadioButton rbTrue;
    private javax.swing.JTextField txtFactoryPrice;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtProductNumber;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTitle() {
        return "Update Your Product";
    }
}
