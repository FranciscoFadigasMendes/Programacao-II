package com.mycompany.aplicacao;
import java.util.Scanner;

public class Aplicacao {
Produtos p[];

    public static void main(String[] args) {
        int product_counter = 0,ans = 1;
        
        //LAYOUT DO MENU
        System.out.println("\nBEM-VINDO AO GESTOR DE PRODUTOS:\n");
        System.out.print("->Adicionar um Produto (1)");
        System.out.println("\t\t->Consultar um Produto (2)");
        System.out.print("->Listar os Produtos (3)");
        System.out.println("\t\t->Alterar Nome de um Produto (4)");
        System.out.println("->Alterar Stock de um Produto (5)");
        System.out.print("---------------------------------------------------------------------");
        Scanner opcao = new Scanner(System.in);
        System.out.print("\n Indique a sua opção: ");
        char opc = opcao.next().charAt(0);
        System.out.print("\n");
        //----------------------------------------------------------------

        do{
            switch(opc) {
                case '1':
                    adicionar_produto(product_counter);
                    break;
                case '2':
                     consultar_produto();
                    break;
                case '3':
                     listar_produto(product_counter,p[]);
                    break;
                case '4':
                     alterar_nome_produto();
                    break;
                case '5':
                     alterar_stock_produto();
                    break;
                 
                default:
                        ans = 0;}
            }while(ans == 0);
   
    }    
  //--------------------------------------------------------------------------      
    public static void adicionar_produto(int product_counter){
        System.out.print("\nFunção: adicionar_produto\n");
        
        Scanner answer = new Scanner(System.in);
        System.out.print("Quantos produtos pretende criar? --> ");
        int a = answer.nextInt();
        
        p[] = new Produtos[a];
        
        for(int i=0;i<a;i++){
        //PEDE O ID
        Scanner p_1 = new Scanner(System.in);
        System.out.print("Insira o ID do Produto " + (i+1) + ":");
        String p_id = p_1.nextLine(); 
        
        //PEDE O NOME
        Scanner p_2 = new Scanner(System.in);
        System.out.print("Insira o NOME do Produto " + (i+1) + ":");
        String p_nome = p_2.nextLine(); 

        //PEDE O STOCK
        Scanner p_3 = new Scanner(System.in);
        System.out.print("Insira o Stock do Produto " + (i+1) + ":");
        int p_stock = p_3.nextInt(); 
        
        //CRIA OBJETO DO CONSTRUTOR COM OS ATRIBUTOS PEDIDOS ACIMA 
        p[i] = new Produtos(p_id,p_nome,p_stock);
        
        product_counter++;
        System.out.print("\n\n");
        }
        
    }
//--------------------------------------------------------------------------  
    public static void eliminar_produto(){
      System.out.print("\nFunção: eliminar_produto\n");
      
    }
//--------------------------------------------------------------------------  
    public static void consultar_produto(int product_counter){
      System.out.print("\nFunção: consultar_produto\n"); 
                  
      //MOSTRA VALORES GUARDADOS
        for(int i=0;i<product_counter;i++){       
            System.out.println("ID Nº" + (i+1) + "-->"+ p[i].getId());
            System.out.println("Nome Nº" + (i+1) + "-->"+ p[i].getNome());
            System.out.println("Stock Nº" + (i+1) + "-->"+ p[i].getStock());
            System.out.print("\n");
        }
    }
//-------------------------------------------------------------------------- 
     public static void listar_produto(){
      System.out.print("\nFunção: listar_produto\n");

      
    }
//-------------------------------------------------------------------------- 
    public static void alterar_nome_produto(){
      System.out.print("\nFunção: alterar_nome_produto\n");

    }
//--------------------------------------------------------------------------
    public static void alterar_stock_produto(){
      System.out.print("\nFunção: alterar_stock_produto\n");
      
    }
//--------------------------------------------------------------------------
}
