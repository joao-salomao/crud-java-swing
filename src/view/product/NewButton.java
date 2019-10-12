/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.product;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import jefinho.products.models.Product;

/**
 *
 * @author João Salomão
 */
public class NewButton extends javax.swing.JButton {
    
    public NewButton(ArrayList<Product> list) {
        this.setText("Novo produto");
    }
    
    public void actionPerformed(ActionEvent e) {
        System.out.println("ME CLICOU");
    }
}
