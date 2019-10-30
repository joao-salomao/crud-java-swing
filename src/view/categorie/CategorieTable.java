package view.categorie;

import dao.CategorieDAO;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Categorie;
 
/**
 * @author João Salomão
 */
public class CategorieTable extends JInternalFrame {
    private CategorieTable  t = this; 
    private JPanel painelFundo;
    private JPanel painelBotoes;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private JButton btInserir;
    private JButton btExcluir;
    private JButton btEditar;
    private ArrayList<Categorie> categories;
    private DefaultTableModel modelo = new DefaultTableModel();
 
    public CategorieTable(ArrayList<Categorie> categories) {
        super("Categorias");
        this.categories = categories;
        criaJTable();
        criaJanela();
    }
 
    public void criaJanela() {
        btInserir = new JButton("Inserir");
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
        btInserir.addActionListener(new BtInserirListener());
        btEditar.addActionListener(new BtEditarListener());
        btExcluir.addActionListener(new BtExcluirListener());
    }
 
    private void criaJTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("NAME");
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
        for (Categorie c : this.categories) {
            modelo.addRow(new Object[]{c.getId(), c.getName()});
        }
    }
    
    public void addRow(Categorie c) {
        this.categories.add(c);
        this.modelo.addRow(new Object[]{c.getId(), c.getName()});
    }
    
    public void updateRow(Categorie c) {
        int index = this.categories.indexOf(c);
        // Update name value
        this.modelo.setValueAt(c.getName(),index, 1);
    }
    
    public void removeRow(Categorie c) {
        int index = this.categories.indexOf(c);
        this.categories.remove(c);
        this.modelo.removeRow(index);
    }
 
    private class BtInserirListener implements ActionListener {
 
        public void actionPerformed(ActionEvent e) {
            new EditCategorie(t);
        }
    }
 
    private class BtEditarListener implements ActionListener {
 
        public void actionPerformed(ActionEvent e) {
            int linhaSelecionada = -1;
            linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada >= 0) {
                Categorie c = categories.get(linhaSelecionada);
                new EditCategorie(t, c);
                System.out.println("aqiuiiiiii");
            } else {
                JOptionPane.showMessageDialog(null, 
                "É necesário selecionar uma linha.");
            }
        }
    }
 
    private class BtExcluirListener implements ActionListener {
 
        public void actionPerformed(ActionEvent e) {
            int linhaSelecionada = -1;
            linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada >= 0) {
                Categorie c = categories.get(linhaSelecionada);
                boolean result = CategorieDAO.delete(c);
                if (result) {
                    categories.remove(linhaSelecionada);
                    modelo.removeRow(linhaSelecionada);
                    JOptionPane.showMessageDialog(null, "Categorie deletada com sucesso");
                } else {
                    String message = message = "Essa categoria está vinculada a algum produto. Primeiro desvincule essa categoria de todos os produtos para poder apagar.";
                    JOptionPane.showMessageDialog(null, message);
                }
            } else {
                JOptionPane.showMessageDialog(null, 
                "É necesário selecionar uma linha.");
            }
        }
    }
}