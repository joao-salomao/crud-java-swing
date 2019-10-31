/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.product;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.ProductDAO;
import models.Product;

/**
 *
 * @author João Salomão
 */
public class ListTable extends javax.swing.JInternalFrame {
    private JPanel painelFundo;
    private JPanel painelBotoes;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private NewProductButton btInserir;
    private DeleteProductButton btExcluir;
    private EditProductButton btEditar;
    private final DefaultTableModel modelo = new DefaultTableModel();
    private  ArrayList<Product> products;
    
    
    public void criaJanela() {
        btInserir = new NewProductButton(this);
        btExcluir = new DeleteProductButton(this);
        btEditar = new EditProductButton(this);
        painelBotoes = new JPanel();
        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        painelFundo.add(BorderLayout.CENTER, barraRolagem);
        painelBotoes.add(btInserir);
        painelBotoes.add(btEditar);
        painelBotoes.add(btExcluir);
        painelFundo.add(BorderLayout.SOUTH, painelBotoes);
 
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 320);
        setVisible(true);
    }
 
    private void criaJTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("NOME");
        modelo.addColumn("PREÇO");
        modelo.addColumn("CATEGORIA");
        modelo.addColumn("ESTADO");
        tabela.getColumnModel().getColumn(0)
        .setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1)
        .setPreferredWidth(120);
        tabela.getColumnModel().getColumn(1)
        .setPreferredWidth(80);
        tabela.getColumnModel().getColumn(1)
        .setPreferredWidth(120);
        pesquisar(modelo);
    }
 
    public void pesquisar(DefaultTableModel modelo) {
        modelo.setNumRows(0);
        this.products.forEach((p) -> {
            this.modelo.addRow(new Object[]{p.getId(), p.getCode(),p.getDescription(), 
                p.getPrice(), p.getCategorie().getName() ,p.getStateString()});
        });
    }
    
    public ArrayList<Product> getProducts() {
        return this.products;
    }
    
    public JTable getTable() {
        return this.tabela;
    }
 
    public void addProduct(Product p) {
        this.modelo.addRow(new Object[]{p.getId(), p.getCode(),p.getDescription()
                , p.getPrice(), p.getCategorie().getName() ,p.getStateString()});
    }
    
    public void updateRow(Product p, int index) {
        // Update code value
        this.modelo.setValueAt(p.getCode(),index, 1);
        // Update description value
        this.modelo.setValueAt(p.getDescription(),index, 2);
        // Update price
        this.modelo.setValueAt(p.getPrice(),index, 3);
        // Update Categorie
        this.modelo.setValueAt(p.getCategorie().getName(),index, 4);
        // Update state
        this.modelo.setValueAt(p.getStateString(),index, 5);
    }
    
    public void removeProduct(int index) {
        this.modelo.removeRow(index);
    }
    
    /**
     * Creates new form ListTable
     */
    public ListTable(ArrayList<Product> products) {
        //initComponents();
        this.products = products;
        this.criaJTable();
        this.criaJanela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
