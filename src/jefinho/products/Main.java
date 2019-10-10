/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jefinho.products;

import java.util.ArrayList;
import java.util.Scanner;
import jefinho.products.dao.ProductDAO;
import jefinho.products.models.Product;
import view.product.Edit;
import view.product.List;

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
        List a = new List(list);
        a.setVisible(true);
    }
    
}
