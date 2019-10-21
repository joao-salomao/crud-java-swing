/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.Product;

/**
 *
 * @author João Salomão
 */
public class EditProductButton extends javax.swing.JButton {
    private ListTable listTable;
    
    public EditProductButton(ListTable listTable) {
        super("Editar");
        this.listTable = listTable;
        this.addActionListener(new EditListener());
    }
    
    private class EditListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Edit listener");
            int linhaSelecionada = -1;
            linhaSelecionada = listTable.getTable().getSelectedRow();
            
            if (linhaSelecionada >= 0) {
                Product p = listTable.getProducts().get(linhaSelecionada);
                new EditFrame(listTable.getProducts(), linhaSelecionada, listTable);
            } else {
                JOptionPane.showMessageDialog(listTable, "É necesário selecionar uma linha.");
            }
        }
    }
}
