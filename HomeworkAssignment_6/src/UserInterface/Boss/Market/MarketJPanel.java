/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Boss.Market;

import UserInterface.Components.HasTitle;
import UserInterface.Components.ParentUI;
import UserInterface.Components.TablePopulatable;
import biz.Components.Business;
import biz.Components.Market;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Administrator
 */
public class MarketJPanel extends javax.swing.JPanel implements TablePopulatable<Market>, HasTitle {
    private ParentUI parent;
    /**
     * Creates new form MarketJPanel
     */
    public MarketJPanel(ParentUI parent) {
        initComponents();
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
        marketTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        viewMarketOffer = new javax.swing.JButton();
        create = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        marketTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Market Name"
            }
        ));
        jScrollPane1.setViewportView(marketTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 330, 240));

        jLabel1.setText("All Markets");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 120, -1));

        viewMarketOffer.setText("View MarketOffer");
        viewMarketOffer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewMarketOfferActionPerformed(evt);
            }
        });
        add(viewMarketOffer, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, 150, -1));

        create.setText("Create ");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 150, -1));

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 150, -1));

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 150, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void viewMarketOfferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewMarketOfferActionPerformed
        // TODO add your handling code here:
        Market selected = getSelected();
        if(selected == null){
            return;
        }
        MarketOfferJPanel moj = new MarketOfferJPanel(parent,selected);
        parent.pushComponent(moj);
    }//GEN-LAST:event_viewMarketOfferActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        Market selected = getSelected();
        if(selected == null){
            return;
        }
        UpdateMarketJPanel um = new UpdateMarketJPanel(parent,selected);
        parent.pushComponent(um);
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        Market select = getSelected();
        if(select == null){
            return;
        }
        if(select.getElementArrayList().size() > 0){
            JOptionPane.showMessageDialog(null,"Cannot delete market with so many customers!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Business.getInstance().getMarketCatalog().removeElement(select);
    }//GEN-LAST:event_deleteActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        // TODO add your handling code here:
        CreateMarketJPanel cmj = new CreateMarketJPanel(parent);
        parent.pushComponent(cmj);
        
    }//GEN-LAST:event_createActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton create;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable marketTable;
    private javax.swing.JButton update;
    private javax.swing.JButton viewMarketOffer;
    // End of variables declaration//GEN-END:variables

    @Override
    public JTable getTable() {
        return marketTable;
    }

    @Override
    public Object[] populateRow(Market element) {
        return new Object[] {element};
    }

    @Override
    public void populateTable() {
        populateTable(Business.getInstance().getMarketCatalog().getElementArrayList());
    }

    @Override
    public String getTitle() {
        return "Market List";
    }
}
