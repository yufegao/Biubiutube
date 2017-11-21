/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.university.college.viewer;

import biz.account.Account;
import ui.components.ParentUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 *
 * @author hezj
 */
public class HomePage extends JPanel {
    private ParentUI parent;
    private Account account;
    private JSplitPane splitPane;
    private JScrollPane left;
    private JPanel right;
    private LecturerTree tree;
    private TagList tagList;

    public HomePage(ParentUI parent, Account account) {
        this.parent = parent;
        this.account = account;
        initComponents();
    }

    private void initComponents() {
        setSize(1000, 700);
        setBackground(new Color(255, 255, 255));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        splitPane = new JSplitPane();
        add(splitPane);

        right = new JPanel();

        tree = new LecturerTree(account);
        tagList = new TagList(account);
        JTabbedPane tab = new JTabbedPane();
        tab.addTab("Lecturer Tree", tree);
        tab.addTab("Tag List", tagList);
        left = new JScrollPane(tab);
        splitPane.setLeftComponent(left);
        splitPane.setDividerLocation(200);

        tree.addTreeSelectionListener(this::treeNodeSelected);
        tagList.addListSelectionListener(this::tagSelected);
    }

    private void treeNodeSelected(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node == null) {
            return;
        }
        if (node.getUserObject() instanceof Account) {
            Account lecturer = (Account) node.getUserObject();
            System.out.println(lecturer);
        }
    }

    private void tagSelected(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            return;
        }
        TagList.TagWithNumber tn = tagList.getSelectedValue();
        if (tn != null) {
            System.out.println(tn);
        }
    }
}
