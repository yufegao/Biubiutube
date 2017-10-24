/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Supplier;

import UserInterface.Components.HasTitle;
import UserInterface.Components.ParentUI;
import UserInterface.Components.TablePopulatable;
import biz.Components.Product;
import biz.Components.ProductCatalog;
import biz.Components.Supplier;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author royn
 */
public class ManageProductJPanel extends javax.swing.JPanel implements HasTitle, TablePopulatable<Product>{
    private Supplier supplier;
    private ParentUI parent;
    
    
    
    /**
     * Creates new form LandingJPanel
     */
    public ManageProductJPanel(ParentUI parent, Supplier supplier) {
        initComponents();
        this.supplier = supplier;
        this.parent = parent;
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDeleteCustomer = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnView2 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product Name", "Product CDKey", "Facotry Price", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 640, -1));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 100, 40));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 430, 100, 40));

        btnDeleteCustomer.setText("Delete");
        btnDeleteCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCustomerActionPerformed(evt);
            }
        });
        add(btnDeleteCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 530, 100, 40));

        btnAdd.setText("Add Product");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 480, 100, 40));

        btnView2.setText("<<Export");
        btnView2.setMaximumSize(new java.awt.Dimension(113, 41));
        btnView2.setMinimumSize(new java.awt.Dimension(113, 41));
        btnView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnView2ActionPerformed(evt);
            }
        });
        add(btnView2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 370, 100, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        this.parent.pushComponent(new CreateProductJPanel(parent, supplier));
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCustomerActionPerformed
        // TODO add your handling code here:
        Product selectedProduct = getSelected();
        if (selectedProduct == null) {
            return;
        }
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Delete selected Order?", "Warning", dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            supplier.getProductCatalog().removeElement(selectedProduct);
        }
        populateTable();
        JOptionPane.showMessageDialog(this, "Removed");
    }//GEN-LAST:event_btnDeleteCustomerActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Product selectedProduct = getSelected();
        if (selectedProduct == null) {
            return;
        }else {
            this.parent.pushComponent(new UpdateProductJPanel(parent,selectedProduct));
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        final String productName = JOptionPane.showInputDialog(this, "Please input the name of Product you want to find");
        if (productName == null){
            return;
        }else{
        ArrayList<Product> productList = supplier.getProductCatalog().findElements(p -> p.getProductName().equals(productName));
        populateTable(productList);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnView2ActionPerformed
        // TODO add your handling code here:
        toCSV();
    }//GEN-LAST:event_btnView2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDeleteCustomer;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProduct;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTitle() {
        return "View my products";
    }

    @Override
    public JTable getTable() {
        return tblProduct;
    }

    @Override
    public Object[] populateRow(Product p) {
        return new Object[] {p, p.getProductNumber(), String.format("%.2f", p.getFactoryPrice()), p.getStock()};
    }

    @Override
    public void populateTable() {
        ProductCatalog pc= supplier.getProductCatalog();
        populateTable(pc.elementArrayList);
    }
}
