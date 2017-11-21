package ui.network.university.college.viewer;

import biz.account.Account;
import biz.nw.Network;
import biz.org.unv.UniverseCollegeOrganization;
import biz.role.producerRole.CollegeLecturerRole;

import javax.swing.*;
import javax.swing.tree.*;

public class LecturerTree extends JTree {

    public LecturerTree(Account account) {
        super();
        Network network = account.getOrg().getEnterprise().getNetwork();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(network.toString());

        DefaultMutableTreeNode universityVideosNode = new DefaultMutableTreeNode("University Videos");
        root.add(universityVideosNode);
        for (UniverseCollegeOrganization college: network.getUniversity().getCollegeCatalog().getOrganizations()) {
            String nodeName = college.getName();
            if (account.getOrg().equals(college)) {
                nodeName += " (My College)";
            }
            DefaultMutableTreeNode collegeNode = new DefaultMutableTreeNode(nodeName);
            universityVideosNode.add(collegeNode);
            CollegeLecturerRole role = college.getCollegeLecturerRole();
            for (Object lecturer: college.getAccountCatalog().getAccountArrayList().stream().filter(a -> a.getRole().equals(role)).toArray()) {
                collegeNode.add(new DefaultMutableTreeNode(lecturer));
            }
        }

        DefaultMutableTreeNode ECOVideoNode = new DefaultMutableTreeNode("EC Videos");
        root.add(ECOVideoNode);

        DefaultTreeModel model = new DefaultTreeModel(root);
        setModel(model);
        getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        ((DefaultTreeCellRenderer) cellRenderer).setLeafIcon(null);  // TODO: use a profile pic thumbnail
    }
}
