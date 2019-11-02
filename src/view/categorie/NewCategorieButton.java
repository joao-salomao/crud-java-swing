/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.categorie;

import java.awt.event.ActionEvent;

/**
 *
 * @author João Salomão
 */
public class NewCategorieButton extends javax.swing.JButton {

    public NewCategorieButton(CategorieTable table) {
        super("Cadastrar");
        this.addActionListener(table);
    }

    private void addActionListener(CategorieTable table) {
        this.addActionListener((ActionEvent e) -> {
            new EditCategorie(table);
        });
    }
}
