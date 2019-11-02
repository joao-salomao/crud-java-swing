/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.categorie;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author João Salomão
 */
public class DeleteCategorieButton extends javax.swing.JButton {

    public DeleteCategorieButton(CategorieTable table) {
        super("Deletar");
        this.addActionListener(table);
    }

    private void addActionListener(CategorieTable table) {
        this.addActionListener((ActionEvent e) -> {
            int result = table.removeRow();
            switch (result) {
                case -1:
                    JOptionPane.showMessageDialog(table, "É necesário selecionar uma linha.");
                    break;
                case 0:
                    JOptionPane.showMessageDialog(table, "Essa categoria está vinculada a algum produto. Primeiro desvincule essa categoria de todos os produtos para poder apagar.");
                    break;
                default:
                    JOptionPane.showMessageDialog(table, "A categoria foi deletada com sucesso.");
                    break;
            }
        });
    }
}
