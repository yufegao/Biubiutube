package ui.network.university.accountingOrganization;

import biz.account.Account;
import biz.enterprises.UniversityEnterprise;
import biz.fnc.RollUpOrder;
import ui.components.HasTitle;
import ui.components.TablePopulatable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.stream.Stream;

public class ManageRollUpOrder extends JPanel implements TablePopulatable<RollUpOrder>, HasTitle {
    private Account account;
    private JTable tbl;

    public ManageRollUpOrder(Account account) {
        this.account = account;
        initComponents();
        populateTable();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JSplitPane splitPane = new JSplitPane();
        add(splitPane);
        splitPane.setEnabled(false);
        splitPane.setDividerLocation(800);

        tbl = new JTable(new DefaultTableModel(
                new Object[0][],
                new String[] {
                        "Created At",
                        "Username",
                        "College",
                        "Amount",
                        "Payment Info"
                }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        JScrollPane leftScroll = new JScrollPane();
        leftScroll.setViewportView(tbl);
        splitPane.setLeftComponent(leftScroll);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        splitPane.setRightComponent(rightPanel);

        JButton btnApprove = new JButton("Approve Selected");
        btnApprove.addActionListener(e -> {
            RollUpOrder order = getSelected();
            if (order == null) {
                return;
            }
            try {
                order.approve();
            } catch (Exception ignored) {
                JOptionPane.showMessageDialog(this, "Cannot Approve.", "Warning", JOptionPane.WARNING_MESSAGE);
                populateTable();
                return;
            }
            JOptionPane.showMessageDialog(this, "Approved");
            populateTable();
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_START;
        c.weightx = 1.0;
        c.insets = new Insets(0, 0, 0, 12);
        c.gridx = 0;
        c.gridy = 0;
        rightPanel.add(btnApprove, c);

        JButton btnCancel = new JButton("Cancel Selected");
        btnCancel.addActionListener(e -> {
            RollUpOrder order = getSelected();
            if (order == null) {
                return;
            }
            try {
                order.cancel();
            } catch (Exception ignored) {
                JOptionPane.showMessageDialog(this, "Cannot Approve.", "Warning", JOptionPane.WARNING_MESSAGE);
                populateTable();
                return;
            }
            JOptionPane.showMessageDialog(this, "Approved");
            populateTable();
        });
        c.gridy = 1;
        rightPanel.add(btnCancel, c);

        c.weighty = 1.0;
        rightPanel.add(new JPanel(), c);
    }

    @Override
    public JTable getTable() {
        return tbl;
    }

    @Override
    public Object[] populateRow(RollUpOrder rollUpOrder) {
        return new Object[] {
                rollUpOrder,
                rollUpOrder.getViewer(),
                rollUpOrder.getViewer().getOrg(),
                rollUpOrder.getAmount(),
                rollUpOrder.getPayment()
        };
    }

    @Override
    public void populateTable() {
        UniversityEnterprise university = (UniversityEnterprise) account.getOrg().getEnterprise();
        Stream<RollUpOrder> stream = university.getRollUpOrderCatalog().getRollUpOrderArrayList().stream()
                .filter(rollUpOrder -> rollUpOrder.getStatus().equals(RollUpOrder.Status.Submitted));
        populateTable(stream);
    }

    @Override
    public String getTitle() {
        return "Approve Or Cancel Order";
    }
}
