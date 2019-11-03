package view.categorie;

import dao.CategorieDAO;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Categorie;
 
/**
 * @author João Salomão
 */
public final class CategorieTable extends JInternalFrame { 
    private JPanel painelFundo;
    private JPanel painelBotoes;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private final ArrayList<Categorie> categories;
    private final DefaultTableModel modelo = new DefaultTableModel();
 
    public CategorieTable(ArrayList<Categorie> categories) {
        this.categories = categories;
        createTable();
        createFrame();
    }
 
    public void createFrame() {
        this.setName("Categorias");
        painelBotoes = new JPanel();
        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        painelFundo.add(BorderLayout.CENTER, barraRolagem);        
        painelBotoes.add(new DeleteCategorieButton(this));
        painelBotoes.add(new EditCategorieButton(this));
        painelBotoes.add(new NewCategorieButton(this));
        painelFundo.add(BorderLayout.SOUTH, painelBotoes);
 
        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 320);
        setVisible(true);
    }
 
    private void createTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("NAME");
        
        tabela.getColumnModel()
            .getColumn(0)
            .setMaxWidth(60);
        tabela.getColumnModel()
            .getColumn(1)
            .setPreferredWidth(120);
        tabela.getColumnModel()
            .getColumn(1)
            .setPreferredWidth(80);
        tabela.getColumnModel()
            .getColumn(1)
            .setPreferredWidth(120);
        this.addRows(modelo);
    }
 
    public void addRows(DefaultTableModel modelo) {
        modelo.setNumRows(0);
        this.categories.forEach((c) -> {
            modelo.addRow(new Object[]{c.getId(), c.getName()});
        });
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
    
    
    public int removeRow() {
        int index = this.tabela.getSelectedRow();
        
        if (index < 0) {
            return -1;
        }
        
        Categorie c = this.categories.get(index);
        boolean result = CategorieDAO.delete(c);
        
        if (!result) {
            return 0;
        }
        
        this.categories.remove(index);
        this.modelo.removeRow(index);
        
        return 1;
    }
    
    public Categorie getSelectedCategorie() {
        int index = this.tabela.getSelectedRow();
        return this.categories.get(index);
    }
}