package com.mycompany.aplicacao;

public class Aplicacao {

    public static void main(String[] args) {
        
        Produtos.acederClasse();
        
        Produtos p1 = new Produtos();
        p1.newProduto("A01","Bola",34);
        
        System.out.println(p1.id);
        System.out.println(p1.nome);
        System.out.println(p1.stock);

           
    }
}
