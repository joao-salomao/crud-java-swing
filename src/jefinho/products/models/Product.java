/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jefinho.products.models;

/**
 *
 * @author João Salomão
 */
public class Product {
    private int id;
    private String code;
    private String description;
    private double price;
    private boolean state;
    
    public Product(int id, String code, String description, double price, boolean state) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.price = price;
        this.state = state;
    }
    
    public Product(String code, String description, double price, boolean state) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.price = price;
        this.state = state;
    }
    
    public Product(int id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }
    
    public Product(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getState() {
        return state;
    }
    
    public String getStateString() {
        return this.state ? "Ativo" : "Desativado";
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
