package com.mycompany.folha_1;
import java.util.Scanner;

public class Folha_1 {

    public static void main(String[] args) {
        System.out.println("Isto é uma calculadora!");
        
        Scanner num1 = new Scanner(System.in);
        System.out.print("Digite um número inteiro:");
        int a = num1.nextInt();
        
        Scanner num2 = new Scanner(System.in);
        System.out.print("Digite outro número inteiro:");
        int b = num2.nextInt();
        
        System.out.println("\nTeste:");
        System.out.println("Numero 1= " + a);
        System.out.println("Numero 2= " + b);

        Scanner sinal = new Scanner(System.in);
        System.out.print("Digite o Sinal(+)(-)(*)(/):");
        String c = sinal.nextLine();
        
        int x=0,d;
        do{
           switch(c){
               case "+":
                  d = a + b;
                  System.out.print("Resultado:" + d);
                    break;
               case "-":
                  d = a - b;
                  System.out.print("Resultado:" + d);
                    break;
               case "*":
                  d = a * b;
                  System.out.print("Resultado:" + d);
                    break;
               case "/":
                  d = a / b;
                  System.out.print("Resultado:" + d);
                    break; 
               
               default:
                   x=1;
           }
        }while(x==1);
     
    }
        
 }
