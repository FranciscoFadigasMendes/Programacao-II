package com.mycompany.aplicacao;

public class Produtos {
    
    //ATRIBUTOS
    private String id;
    private String nome;
    private int stock;
    
    //CONSTRUTOR
   public  Produtos(String id, String nome, int stock){
  
        this.id = id;
        this.nome = nome;
        this.stock = stock;
    }
   

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    
}
