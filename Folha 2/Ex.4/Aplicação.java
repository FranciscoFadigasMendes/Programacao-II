package com.mycompany.aplicacao;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {

        Produtos.acederClasse(); //teste de que acede à classe
        
        Produtos p1 = new Produtos(); 
        
        /*
        
        DUVIDAS
            
        1- PORQUE E QUE NA LINHA 1O SE POE ASSIM E NÃO --> ...= new newProduto();
        
        2- PORQUE É QUE NAO GUARDA VALORES ABAIXO
        
        */
        
        Scanner p1_id = new Scanner(System.in);//cria o objeto scanner
        System.out.print("Insira o ID do Produto:  ");
        String p1_1 = p1_id.nextLine(); // lê o input do user
        
        p1_1 = p1.id;
        
        Scanner p1_nome = new Scanner(System.in);//cria o objeto scanner
        System.out.print("Insira o NOME do Produto:  ");
        String p1_2 = p1_nome.nextLine(); // lê o input do user
        
        p1_2 = p1.nome;
        
        Scanner p1_stock = new Scanner(System.in);//cria o objeto scanner
        System.out.print("Insira o Stock do Produto:  ");
        int p1_3 = p1_stock.nextInt(); // lê o input do user
        
        p1_3 = p1.stock;
        
     
        System.out.println("-----------");
        System.out.println("ID : " + p1.id);
        System.out.println("NOME : " + p1.nome);
        System.out.println("STOCK : " + p1.stock);
        System.out.println("\n");


           
    }
}
