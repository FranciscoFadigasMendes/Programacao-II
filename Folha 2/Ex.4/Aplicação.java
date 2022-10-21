package com.mycompany.aplicacao;
import java.util.Scanner;


public class Aplicacao {
    static final int MAX_PRODUTOS = 10;
    static Produtos p[] = new Produtos[MAX_PRODUTOS];
    static int num_prod[];
    static int p_counter = 0;


    public static void main(String[] args) {
        
        //LAYOUT DO MENU
        System.out.println("\nBEM-VINDO AO GESTOR DE PRODUTOS:\n");
        System.out.println("NOTA:Existem "+ p_counter +" produtos\n");
        System.out.print("->Adicionar um Produto (1)");
        System.out.println("\t\t->Eliminar um Produto (2)");
        System.out.print("->Consultar um Produto (3)");
        System.out.println("\t\t->Listar os Produtos (4)");
        System.out.print("->Alterar Nome de um Produto (5)");
        System.out.println("\t->Alterar Stock de um Produto (6)");
        System.out.print("---------------------------------------------------------------------");
        
        Scanner opcao = new Scanner(System.in);
        System.out.print("\n Indique a sua opção: ");
        int opc = opcao.nextInt();
       
   
        System.out.print("\n");
        //----------------------------------------------------------------

            switch(opc) {
                case 1:
                    adicionar_produto();
                    p_counter ++;
                    main(args);
                case 2:
                    eliminar_produto();
                    p_counter --;
                    main(args);
                case 3:
                     consultar_produto();
                     main(args);
                case 4:
                     listar_produto();
                     main(args);
                case 5:
                     alterar_nome_produto();
                     main(args);
                case 6:
                     alterar_stock_produto();
                     main(args);
                 
                default:
                                    }
            
    }    
  //--------------------------------------------------------------------------      
    public static void adicionar_produto(){
        System.out.print("\nFunção: adicionar_produto\n");
        
        
        Scanner answer = new Scanner(System.in);
        System.out.print("Quantos produtos pretende criar? --> ");
        num_prod[0] = answer.nextInt();
            
        for(int i=0;i<num_prod[0];i++){
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
        p[num_prod[0]] = new Produtos(p_id,p_nome,p_stock);
       
        System.out.print("\n\n");
        }
    
        
    }
//--------------------------------------------------------------------------  
    public static void eliminar_produto(){
      System.out.print("\nFunção: eliminar_produto\n");
      
    }
//--------------------------------------------------------------------------  
    public static void consultar_produto(){
      System.out.print("\nFunção: consultar_produto\n"); 
                  

    }
//-------------------------------------------------------------------------- 
     public static void listar_produto(){
      System.out.print("\nFunção: listar_produto\n");
      
      //MOSTRA VALORES GUARDADOS
        for(int i=0;i<p_counter;i++){       
            System.out.println("ID Nº" + (i+1) + "-->"+ p[i].getId());
            System.out.println("Nome Nº" + (i+1) + "-->"+ p[i].getNome());
            System.out.println("Stock Nº" + (i+1) + "-->"+ p[i].getStock());
            System.out.print("\n");
        }
      
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
