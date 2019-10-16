/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.product;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jefinho.products.dao.ProductDAO;
import jefinho.products.models.Product;

/**
 *
 * @author João Salomão
 */
public class ListTable extends javax.swing.JFrame {
    private JPanel painelFundo;
    private JPanel painelBotoes;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private NewProductButton btInserir;
    private JButton btExcluir;
    private JButton btEditar;
    private DefaultTableModel modelo = new DefaultTableModel();
    private  ArrayList<Product> products;
    
    
    public void criaJanela() {
        btInserir = new NewProductButton(this);
        btExcluir = new JButton("Excluir");
        btEditar = new JButton("Editar");
        painelBotoes = new JPanel();
        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        painelFundo.add(BorderLayout.CENTER, barraRolagem);
        painelBotoes.add(btInserir);
        painelBotoes.add(btEditar);
        painelBotoes.add(btExcluir);
        painelFundo.add(BorderLayout.SOUTH, painelBotoes);
 
        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 320);
        setVisible(true);
        btInserir.addActionListener(new BtInserirListener(this));
        btEditar.addActionListener(new BtEditarListener());
        btExcluir.addActionListener(new BtExcluirListener());
    }
 
    private void criaJTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("Id");
        modelo.addColumn("Code");
        modelo.addColumn("Description");
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
            modelo.addRow(new Object[]{p.getId(), p.getCode(),p.getDescription()});
        });
    }
    
    public ArrayList<Product> getProducts() {
        return this.products;
    }
    
 
    public void addProduct(Product p) {
        this.modelo.addRow(new Object[]{p.getId(), p.getCode(),p.getDescription()});
    }
    
    private class BtInserirListener implements ActionListener {
        private ListTable listTable;
        
        public BtInserirListener(ListTable listTable) {
            this.listTable = listTable;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Insert listener");
            new EditFrame(listTable.getProducts(), -1, listTable);
            
//            InserirContato ic = new InserirContato(modelo);
//            ic.setVisible(true);
        }
    }
 
    private class BtEditarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Edit listener");
//            int linhaSelecionada = -1;
//            linhaSelecionada = tabela.getSelectedRow();
//            if (linhaSelecionada >= 0) {
//                int idContato = (int) tabela
//                .getValueAt(linhaSelecionada, 0);
//                AtualizarContato ic = 
//                new AtualizarContato(modelo, idContato, linhaSelecionada);
//                ic.setVisible(true);
//            } else {
//                JOptionPane.showMessageDialog(null, 
//                "É necesário selecionar uma linha.");
//            }
        }
    }
 
    private class BtExcluirListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Delete listener");
//            int linhaSelecionada = -1;
//            linhaSelecionada = tabela.getSelectedRow();
//            if (linhaSelecionada >= 0) {
//                int idContato = (int) 
//                tabela.getValueAt(linhaSelecionada, 0);
//                ContatoDao dao = new ContatoDao();
//                dao.remover(idContato);
//                modelo.removeRow(linhaSelecionada);
//            } else {
//                JOptionPane.showMessageDialog(null, 
//                "É necesário selecionar uma linha.");
//            }
        }
    }
    /**
     * Creates new form ListTable
     */
    public ListTable() {
        //initComponents();
        this.products = ProductDAO.index();
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
