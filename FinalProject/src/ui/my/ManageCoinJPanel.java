package ui.my;

import biz.account.Account;
import biz.enterprises.UniversityEnterprise;
import ui.components.ChildComponent;
import ui.components.HasTitle;
import ui.components.ParentUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ManageCoinJPanel extends JPanel implements HasTitle, ChildComponent {
    private Account account;
    private JTable tblRollUpOrder;
    private JTable tblWalletHistory;
    private ParentUI parent;

    ManageCoinJPanel(ParentUI parent, Account account) {
        this.account = account;
        this.parent = parent;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        JPanel footer = new JPanel();
        add(footer, BorderLayout.PAGE_END);
        footer.setLayout(new GridBagLayout());
        GridBagConstraints footerConstraints = new GridBagConstraints();
        footerConstraints.fill = GridBagConstraints.HORIZONTAL;
        footerConstraints.gridx = 0;
        footerConstraints.gridy = 0;
        footerConstraints.weightx = 1.0;

        JButton btnRollUp = new JButton("Order More Coins >>");
        btnRollUp.addActionListener(e -> parent.pushComponent(new RollUpJPanel(account)));
        footer.add(btnRollUp, footerConstraints);

        JButton btnRedeem = new JButton("Redeem  >>");
        btnRedeem.addActionListener(e -> parent.pushComponent(new RedeemJPanel(parent, account)));
        footerConstraints.gridy = 1;
        footer.add(btnRedeem, footerConstraints);

        JSplitPane splitPane = new JSplitPane();
//        splitPane.setEnabled(false);
        splitPane.setDividerLocation(494);
        add(splitPane);

        tblRollUpOrder = new JTable(new DefaultTableModel(
                new Object[0][4],
                new String[] {
                    "Created At",
                    "Status",
                    "Status Comment",
                    "Updated At"
                }
        ) {
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        });

        JScrollPane rollUpOrderScrollPane = new JScrollPane();
        rollUpOrderScrollPane.setViewportView(tblRollUpOrder);
        rollUpOrderScrollPane.setBorder(BorderFactory.createTitledBorder("Roll Up Orders"));
        splitPane.setLeftComponent(rollUpOrderScrollPane);

//        JPanel rollUpOrderPanel = new JPanel();
//        rollUpOrderPanel.setBorder(BorderFactory.createTitledBorder("Roll Up Orders"));
//        rollUpOrderPanel.setLayout(new BoxLayout(rollUpOrderPanel, BoxLayout.Y_AXIS));
//        rollUpOrderPanel.add(tblRollUpOrder);

        this.tblWalletHistory = new JTable(new DefaultTableModel(
                new Object[0][2],
                new String[] {
                    "Time",
                    "Value",
                }
        ) {
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        });
        JScrollPane WalletHistoryScrollPane = new JScrollPane();
        WalletHistoryScrollPane.setViewportView(tblWalletHistory);
        WalletHistoryScrollPane.setBorder(BorderFactory.createTitledBorder("My Wallet History"));
        splitPane.setRightComponent(WalletHistoryScrollPane);

//        JPanel walletHistoryJPanel = new JPanel();
//        walletHistoryJPanel.setBorder(BorderFactory.createTitledBorder("My Wallet History"));
//        walletHistoryJPanel.setLayout(new BoxLayout(walletHistoryJPanel, BoxLayout.Y_AXIS));
//        walletHistoryJPanel.add(tblRollUpOrder);
//        splitPane.setRightComponent(walletHistoryJPanel);

        populateTables();
    }

    @Override
    public void exposed() {
        populateTables();
    }

    private void populateTables() {
        populateWalletHistoryTable();
        populateRollUpOrderTable();
    }

    private void populateRollUpOrderTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblRollUpOrder.getModel();
        dtm.setRowCount(0);
        UniversityEnterprise university = (UniversityEnterprise) account.getOrg().getEnterprise();
        university.getRollUpOrderCatalog().getRollUpOrderArrayList().forEach(rollUpOrder -> {
            if (rollUpOrder.getViewer().equals(account)) {
                dtm.addRow(new Object[]{
                        rollUpOrder,
                        rollUpOrder.getStatus(),
                        rollUpOrder.getStatus().getComment(),
                        rollUpOrder.getUpdatedAt().getTime()
                });
            }
        });
    }

    private void populateWalletHistoryTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblWalletHistory.getModel();
        dtm.setRowCount(0);
        account.getWallet().getHistoryArrayList().forEach(history -> dtm.addRow(new Object[] {
                history.getCalendar().getTime(),
                String.format("%+d", history.getAmount()),
        }));
    }

    @Override
    public String getTitle() {
        return "Manage Coins";
    }
}
