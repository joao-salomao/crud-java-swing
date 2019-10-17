/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.product;

/**
 *
 * @author João Salomão
 */

// Classe gato
public class Gato {
    // Atributo privado, só pode ser acessado pela classe Gato.
    private String nome;
    
    // Atributo público que pode ser acessado por qualquer classe.
    public String cor;
    
    // Atributo público e estático, ou seja, pode ser acessado por qualquer
    // classe e é igual para todas as instâncias da classe gato.
    public static int quantidadeDePatas = 4;
    
    // Método construtor, recebe dois parâmetros, o nome e a cor da instância.
    public Gato(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
    }
    
    // Método/Ação da classe gato: Miar
    public void miar() {
        System.out.println("Miua Miua Miua!");
    }
    
    // Outro método/ação da classe que mostra o valor do atríbuto nome.
    public void mostrarNome() {
        System.out.println(this.nome);
    }
}
