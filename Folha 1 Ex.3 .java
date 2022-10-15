package com.mycompany.folha_1;

import java.util.Scanner;  //importa a class ccanner

public class Folha_1 {
    
    public static void main(String[] args) {
       
        Scanner resposta1 = new Scanner(System.in);//cria o objeto scanner
        System.out.print("Digite um número:");
        double a = resposta1.nextDouble(); // lê o input do user
        
        
        Scanner resposta2 = new Scanner(System.in);//cria o objeto scanner
        System.out.print("Digite outro número:");
        double b = resposta2.nextDouble();// lê o input do user
        
        System.out.println("Número 1 = " + a);         
        System.out.println("Número 2 = " + b);  
        
        double soma = a + b;
        System.out.println("Soma dos dois números = " + soma); 
        
        if(a-(int)a < 0.5)
            a = (int)a;
        
        if(a-(int)a >= 0.5)
            a = (int)a + 1;
        
        if(b-(int)b < 0.5)
            b = (int)b;
        
        if(b-(int)b >= 0.5)
            b = (int)b + 1;
        
        System.out.println("Numero 1 Arredondado a Inteiro = " + a);
        System.out.println("Numero 2 Arredondado a Inteiro = " + b);
    }
}
