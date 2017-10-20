/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Market;

import UserInterface.Components.HasTitle;
import UserInterface.Components.ParentUI;
import biz.Components.Business;
import biz.Components.Market;
import biz.Components.MarketOffer;
import biz.Components.OfferProduct;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class UpdateOfferProductJPanel extends javax.swing.JPanel implements HasTitle{
    private ParentUI parent;
    private OfferProduct offerProduct;
    /**
     * Creates new form UpdateMarketJPanel
     */
    public UpdateOfferProductJPanel(ParentUI pa, OfferProduct op) {
        initComponents();
        this.parent = pa;
        this.offerProduct = op;
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lowestTF = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        targetTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        highestTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lowestTF.setText(" ");
        add(lowestTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 170, -1));

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, -1));

        jLabel3.setText("Lowset Price");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, 20));

        targetTF.setText(" ");
        add(targetTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 170, -1));

        jLabel4.setText("Target Price");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, -1, 20));

        highestTF.setText(" ");
        add(highestTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 170, -1));

        jLabel5.setText("Highest Price");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        double low,target,highest;
        try{
            low = Double.parseDouble(lowestTF.getText());
            target = Double.parseDouble(targetTF.getText());
            highest = Double.parseDouble(highestTF.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please input data correctly");
            return;
        }
        offerProduct.setTargetPrice(target);
        offerProduct.setHighestPrice(highest);
        offerProduct.setLowestPrice(low);
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField highestTF;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField lowestTF;
    private javax.swing.JTextField targetTF;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTitle() {
        return "UpdateMarket";
    }
}