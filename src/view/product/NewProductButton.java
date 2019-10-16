/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import jefinho.products.models.Product;

/**
 *
 * @author João Salomão
 */
public class NewProductButton extends javax.swing.JButton {
    private ListTable listTable;
    
    public NewProductButton(ListTable listTable) {
        super("Novo produto");
        this.listTable = listTable;
        this.addActionListener(new InsertListener(this.listTable));
    }
    
    private class InsertListener implements ActionListener {
        private ListTable listTable;

        public InsertListener(ListTable listTable) {
            this.listTable = listTable;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Insert listener");
            new EditFrame(listTable.getProducts(), -1, listTable);

        }
    }
}
