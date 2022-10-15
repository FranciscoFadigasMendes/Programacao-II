package com.mycompany.mavenproject1;
import java.util.Scanner;

public class Mavenproject1 {

    public static void main(String[] args) {
       float[] notas = new float[5];  //cria array
        
        ler_notas(notas);
        calcula_media(notas);
        nota_sup_inf(notas);
        nota_pos_neg(notas);
    }

//------------------Funções de Apoio--------------------------------------------------    
    
   static void ler_notas(float[] notas) {
        int i,a;
        
        System.out.println("\n----------SISTEMA LEU FUNÇÃO 'ler_notas'---------");
        
            for(i=0;i<5;i++){  //for coloca todo o array a começar em '0'
                notas[i] = 0;
            }
            
            System.out.print("\n");
            i=0;
            a=0;
            System.out.println("NOTA: Para parar de Insirir notas digite '-1'\n");
            do{       //pede as notas e limita os valores entre 0 a 20
                
                do{ 
                    if(a == 1){
                    Scanner nota = new Scanner(System.in);
                    System.out.print("      Reinsira a Nota do Aluno " + (i+1) + " : ");
                    notas[i] = nota.nextFloat();
                    
                    if(notas[i]<0.0 || notas[i]>20.0){
                      System.out.print("   ERRO: Valor não Aceite (0-20,0 valores)\n");
                      a = 1;
                        }
                    }
                    if(a == 0){
                    Scanner nota = new Scanner(System.in);
                    System.out.print("Insira a Nota do Aluno " + (i+1) + " : ");
                    notas[i] = nota.nextFloat();
                    
                    if(notas[i]<0.0 || notas[i]>20.0){
                        if(notas[i]== -1)
                            break;
                      System.out.print("   ERRO: Valor não Aceite (0-20,0 valores)\n");
                      a = 1;
                    }
                  }
                    if(notas[i] == -1)
                        break;
                }while(notas[i]<0.0 || notas[i]>20.0);
                    
                if(notas[i] == -1){
                    notas[i] = 0;
                    break;}
                a=0;
                i++;
                System.out.print("\n");
            }while(i<5 || notas[i]== -1); 
            
            System.out.println("Lista das Notas:\n");
            for(i=0;i<5;i++){ 
                System.out.println("Nota do Aluno " + (i+1) + ": " + notas[i]) ;
            } 
    }
//---------------------------------------------------------------------------------------    
    
    static void calcula_media(float notas[]) {  
        int i,a;
        float soma,media;
        System.out.println("\n----------SISTEMA LEU FUNÇÃO 'calcula_media'---------");
         
        soma = 0;
        a = 0;
        for(i=0;i<5;i++){
            if(notas[i]>0) a++;
            soma += notas[i];}
        
        media = soma / a ;
        System.out.println("A média é : " + media);
        }
    
   //---------------------------------------------------------------------------------------    
    
    static void nota_sup_inf(float notas[]) {  
       int i;
       float nota_sup = 0;
       float nota_inf = 0;
       System.out.println("\n----------SISTEMA LEU FUNÇÃO 'nota_sup_inf'---------");
       
       for(i=0;i<5;i++){
          if(notas[i+1]>notas[i])notas[i] = nota_sup;
          else  
            if(notas[i+1]<notas[i])notas[i] = nota_inf;
                else
                    break;}
       
       System.out.println("A nota superior é : " + nota_sup);
       System.out.println("A nota inferior é : " + nota_inf);
    }
  //---------------------------------------------------------------------------------------    
    
    static void nota_pos_neg(float notas[]) {  
        int i;

        System.out.println("\n----------SISTEMA LEU FUNÇÃO 'nota_pos_neg'---------");
        
        for(i=0;i<5;i++){
          if(notas[i]>0) System.out.println("Aluno "+ i + " -> Nota Positiva :" + notas[i]);
          if(notas[i]<0) System.out.println("Aluno "+ i + " -> Nota Negativa :" + notas[i]);
          if(notas[i] == 0) System.out.println("Aluno "+ i + " -> Nota Nula : " + notas[i]);}
    }  
}   
