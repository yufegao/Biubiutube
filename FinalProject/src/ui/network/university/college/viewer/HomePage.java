/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.university.college.viewer;

import biz.account.Account;
import biz.video.Video;
import ui.components.ParentUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 *
 * @author hezj
 */
public class HomePage extends JPanel {
    private ParentUI parent;
    private Account account;
    private JSplitPane splitPane;
    private JPanel rightContainer;
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
        splitPane.setEnabled(false);
        splitPane.setDividerLocation(200);
        add(splitPane);

        tree = new LecturerTree(account);
        tagList = new TagList(account);
        JTabbedPane tab = new JTabbedPane();
        tab.addTab("Lecturer Tree", tree);
        tab.addTab("Tag List", tagList);
        JScrollPane leftScroll = new JScrollPane(tab);
        leftScroll.setMaximumSize(new Dimension((int) leftScroll.getMaximumSize().getWidth(), 650));
        splitPane.setLeftComponent(leftScroll);

        tree.addTreeSelectionListener(this::treeNodeSelected);
        tagList.addListSelectionListener(this::tagSelected);

        rightContainer = new JPanel();
        JScrollPane rightScroll = new JScrollPane(rightContainer);
        rightContainer.setBackground(Color.gray);
        rightContainer.setLayout(new BoxLayout(rightContainer, BoxLayout.Y_AXIS));
        splitPane.setRightComponent(rightScroll);

        Stream<Video> videoStream = account.getOrg().getEnterprise().getNetwork().getVideoCatalog().getVideoArrayList().stream()
                .sorted(Comparator.comparingInt((Video v) -> v.getVoteCatalog().getVoteArrayList().size()).reversed()).limit(10);

        populateVideoBoxes(videoStream);
    }

    private void populateVideoBoxes(Stream<Video> videos) {
        videos.forEach(video -> {
            rightContainer.add(new VideoBox(parent, video, account));
            rightContainer.add(Box.createRigidArea(new Dimension(0, 10)));
        });
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
