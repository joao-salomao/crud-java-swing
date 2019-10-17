/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import jefinho.products.dao.ProductDAO;
import jefinho.products.models.Product;

/**
 *
 * @author João Salomão
 */
public class DeleteProductButton extends javax.swing.JButton {
    private final ListTable listTable;
    public DeleteProductButton(ListTable listTable) {
        super("Deletar");
        this.listTable = listTable;
        this.addActionListener(new DeleteListener());
    }
    
    private class DeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Delete listener");
            int linhaSelecionada = -1;
            linhaSelecionada = listTable.getTable().getSelectedRow();
            if (linhaSelecionada >= 0) {
                Product p = listTable.getProducts().get(linhaSelecionada);
                
                boolean result = ProductDAO.delete(p);
                if (result) {
                    listTable.removeProduct(linhaSelecionada);
                    JOptionPane.showMessageDialog(listTable, "O produto foi deletado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(listTable, "Algo deu errado, tente novamente.");
                }
                
            } else {
                JOptionPane.showMessageDialog(null, 
                "É necesário selecionar uma linha.");
            }
        }
    }
}
