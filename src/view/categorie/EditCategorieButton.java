/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.categorie;

import java.awt.event.ActionEvent;
import models.Categorie;

/**
 *
 * @author João Salomão
 */
public class EditCategorieButton extends javax.swing.JButton {

    public EditCategorieButton(CategorieTable table) {
        super("Editar");
        this.addActionListener(table);
    }

    private void addActionListener(CategorieTable table) {
        this.addActionListener((ActionEvent e) -> {
            Categorie categorie = table.getSelectedCategorie();
            new EditCategorie(table, categorie);
        });
    }
}
