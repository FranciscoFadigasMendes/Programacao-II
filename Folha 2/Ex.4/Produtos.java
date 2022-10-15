package com.mycompany.aplicacao;

public class Produtos {
    
    static String id;
    static String nome;
    static int stock;
    
    public static void acederClasse(){
        System.out.println("ACEDI À CLASSE PRODUTOS");
    }
    

   public static void newProduto(String new_id,String new_nome,int new_stock){
  
        new_id = id;
        new_nome = nome;
        new_stock = stock;
              
    }

    
}
