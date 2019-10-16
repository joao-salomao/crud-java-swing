/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.product;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import jefinho.products.dao.ProductDAO;
import jefinho.products.models.Product;

/**
 *
 * @author João Salomão
 */
public class MainFrame {
    public MainFrame() {
        ArrayList<Product> list = ProductDAO.index();
        
        ListPanel listPanel = new ListPanel(list);

        JFrame frame = new JFrame("Produtos");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(listPanel);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }
}
