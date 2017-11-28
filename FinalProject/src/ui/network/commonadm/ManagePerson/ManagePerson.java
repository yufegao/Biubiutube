/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.commonadm.ManagePerson;

import ui.network.commonadm.ManageOrganization.*;
import biz.account.Account;
import biz.enterprises.AdCompanyEnterprise;
import biz.enterprises.ECOEnterprise;
import biz.enterprises.Enterprise;
import biz.enterprises.NPOEnterprise;
import biz.enterprises.UniversityEnterprise;
import biz.org.Organization;
import biz.org.OrganizationCatalog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import ui.components.HasTitle;
import ui.components.ParentUI;
import ui.components.TablePopulatable;

/**
 *
 * @author hezj
 */
public class ManagePerson extends javax.swing.JPanel implements HasTitle, TablePopulatable<Organization>{
    private ParentUI parent;
    private Account account;
    private Enterprise enterprise;
    private String keyWord;
    private OrganizationCatalog catalog;
    
    /**
     * Creates new form ManageCollege
     */
    public ManagePerson(ParentUI parent, Account account) {
        this.parent = parent;
        this.account = account;
        enterprise = account.getOrg().getEnterprise();
        
        if (enterprise instanceof UniversityEnterprise) {
            keyWord = "College";
            catalog = ((UniversityEnterprise) enterprise).getCollegeCatalog();
        }
        if (enterprise instanceof AdCompanyEnterprise) {
            keyWord = "Ad Producer";
            catalog = ((AdCompanyEnterprise) enterprise).getaPCatalog();
        }
        if (enterprise instanceof ECOEnterprise) {
            keyWord = "Video Producer";
            catalog = ((ECOEnterprise) enterprise).getEcovpoc();
        }
        if (enterprise instanceof NPOEnterprise) {
            keyWord = "PSA Producer";
            catalog = ((NPOEnterprise) enterprise).getNpooc();
        }
        
        initComponents();
        btnAdd.setText("Add " + keyWord);
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
        tbl = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "College", "Number of Person", "Number of Account"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl);

        btnAdd.setText("Add Account");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit Selected");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove Selected");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        parent.pushComponent(new AddOrEditPerson(catalog, keyWord));
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
       Organization org = getSelected();
       if (org == null) {
           return;
       }
       parent.pushComponent(new AddOrEditPerson(catalog, keyWord, org));
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        Organization org = getSelected();
       if (org == null) {
           return;
       }
       if (!org.getPersonCatalog().getPersonList().isEmpty()) {
           String msg = String.format("Cannot remove this %s, there are %d person in it.", keyWord, org.getPersonCatalog().getPersonList().size());
           JOptionPane.showMessageDialog(this, msg, "Warning", JOptionPane.WARNING_MESSAGE);
           return;
       }
       catalog.removeOrganization(org);
       populateTable();
       JOptionPane.showMessageDialog(null, "Success");
    }//GEN-LAST:event_btnRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTitle() {
        return String.format("Manage %s in %s", keyWord, enterprise.getName());
    }

    @Override
    public JTable getTable() {
        return tbl;
    }

    @Override
    public Object[] populateRow(Organization org) {
        return new Object[] {
            org,
            org.getPersonCatalog().getPersonList().size(),
            org.getAccountCatalog().getAccountArrayList().size(),
        };
    }

    @Override
    public void populateTable() {
        populateTable(catalog.getOrganizations());
    }
}
