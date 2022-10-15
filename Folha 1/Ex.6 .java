package com.mycompany.folha_1;

public class Folha_1 {

    public static void main(String[] args) {
     
        int i=0,contador=0;
        
        System.out.print("Este Programa vai imprimir os primeiros 100 números pares");
        
        do{
            if(i%2 == 0){
                System.out.println("" + i);
                contador++;}
            i++;
            
        }while(contador<=100);
    }
 }
