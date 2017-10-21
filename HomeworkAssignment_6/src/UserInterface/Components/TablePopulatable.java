/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Components;

import biz.Catalog.AbstractCatalog;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hezj
 */
public interface TablePopulatable<Element> {
    JTable getTable();

    default void populateTable(Iterable<Element> elements) {
        JTable table = getTable();
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);

        elements.forEach(e -> dtm.addRow(populateRow(e)));
    }

    Object[] populateRow(Element element);

    default Element getSelected() {
        JTable table = getTable();
        int selectedCount = table.getSelectedRowCount();
        if (selectedCount > 1) {
            JOptionPane.showMessageDialog((Component) this, "Please select no more than 1 row.");
            return null;
        }
        if (selectedCount < 1) {
            JOptionPane.showMessageDialog((Component) this, "Please select 1 row.");
            return null;
        }

        return (Element)table.getValueAt(table.getSelectedRow(), 0);
    }

    void populateTable();
    
    default boolean removeSelected(AbstractCatalog<Element> catalog) {
        Element selected = getSelected();
        if (selected == null) {
            return false;
        }
        
        int result = JOptionPane.showConfirmDialog((Component) this, "Confirm delete?", "Warning", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.NO_OPTION) {
            return false;
        }
        
        populateTable();
        
        return catalog.removeElement(selected);
    }
}
