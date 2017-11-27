/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.advertisementEnterprise.adminOrganization;
import biz.EcoSystem;
import biz.account.Account;
import biz.enterprises.AdCompanyEnterprise;
import java.util.ArrayList;
import javax.swing.JTable;
import ui.components.HasTitle;
import ui.components.ParentUI;
import ui.components.TablePopulatable;
/**
 *
 * @author 79813
 */
public class ADManageAccounts extends javax.swing.JPanel implements TablePopulatable<Account>,HasTitle{
    private ParentUI parentUI;
    private Account account;
    
    /**
     * Creates new form ManageAccounts
     */
    public ADManageAccounts(ParentUI parentUI, Account account) {
        initComponents();
        this.account = account;
        this.parentUI = parentUI;
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
        tblUser = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Person"
            }
        ));
        jScrollPane1.setViewportView(tblUser);

        jButton1.setText("DELETE");

        jLabel1.setText("All Users:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(jButton1)))
                .addGap(0, 323, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 216, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(229, 229, 229))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUser;
    // End of variables declaration//GEN-END:variables

    @Override
    public JTable getTable() {
        return tblUser;
    }

    @Override
    public Object[] populateRow(Account element) {
        return new Object[]{element,element.getPerson()};
    }

    @Override
    public void populateTable() {
        populateTable(account.getOrg().getAccountCatalog().getAccountArrayList());
    }

    @Override
    public String getTitle() {
        return "Manage Advertisement Accounts";
    }
}
