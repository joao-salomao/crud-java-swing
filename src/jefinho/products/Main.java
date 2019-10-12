/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jefinho.products;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import jefinho.products.dao.ProductDAO;
import jefinho.products.models.Product;
import view.product.ListPanel;

/**
 *
 * @author João Salomão
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Product> list = new ArrayList<>();
        list = ProductDAO.index();
        list.forEach(p -> {
            System.out.println(p.getDescription());
        });
        
        ListPanel listPanel = new ListPanel(list);
        
        JScrollPane scroller = new JScrollPane(listPanel);
        
        JFrame frame = new JFrame("Jefinho Produtos");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(listPanel);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }
    
}
