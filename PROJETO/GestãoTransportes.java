package com.mycompany.gestaotransportes;
import util.Consola;
import java.util.Scanner;
import java.util.ArrayList;

public class GestaoTransportes {
    
  public static Scanner sc = new Scanner(System.in);

  ArrayList<Empresa> e = new ArrayList();
  ArrayList<Motorista> m = new ArrayList();
  
  
    public static void main(String[] args) {
       
        int a = 0;
     
        //LAYOUT DO MENU
        System.out.println("\nBEM-VINDO AO GESTOR DE TRANSPORTES:\n");
        System.out.println("1. Inserir e consultar (através no NIF) todas as empresas registadas");
        System.out.println("2. Inserir, consultar (através no NIF) e alterar dados de motoristas");
        System.out.println("3. Inserir, consultar (através na matrícula) veículos");
        System.out.println("4. Associar veículo a nova empresa");
        System.out.println("5. Registar e consultar avarias");
        System.out.println("6. Registar e consultar (por empresa) serviços de transporte registados");
        System.out.println("7. Outras consultas/estatísticas");
        System.out.print("---------------------------------------------------------------------");
               
        int opc = Consola.lerInt("\n Indique a sua opção: ", 1, 7);
        System.out.print("\n");

            
            switch(opc) {
                case 1:
                    GestaoTransportes b = new GestaoTransportes();
                    b.manageEmpresa();
                    main(args);
                    
                case 2:
                    GestaoTransportes c = new GestaoTransportes();
                    c.manageMotorista();
                    main(args);
                case 3:
                    System.out.println("opc3");
                    main(args);
                case 4:
                    System.out.println("opc4");
                    main(args);
                case 5:
                    System.out.println("opc5");
                    main(args);
                case 6:
                    System.out.println("opc6");
                    main(args);
                case 7:
                    System.out.println("opc7");
                    a = 1;
                    break;
                default:
                    main(args);
                                    }
            
   
  //--------------------------------------------------------------------------
    
    if( a == 1){
        //LAYOUT DO SUB-MENU
        System.out.println("\nSUB-MENU:\n");   
        System.out.println("1. Listagem de veículos com mais de n quilómetros realizados");
        System.out.println("2. Listagem das 3 empresas com maior valor faturado");
        System.out.println("3. Total de serviços realizados por empresa");
        System.out.println("4. Média de quilómetros realizados por empresa e por tipo de serviço");
        System.out.println("5. Listagem de funcionários (por empresa)");
        System.out.println("6. Histórico de avarias por veículo.");
        System.out.println("7. Voltar ao Menu Principal");
        System.out.print("---------------------------------------------------------------------");    
    
       int opc2 = Consola.lerInt("\n Indique a sua opção: ", 1, 7);
        System.out.print("\n");       
    
            switch(opc2) {
                case 1:
                    main(args);
                case 2:
                    main(args);
                case 3:
                    main(args);
                case 4:
                    main(args);
                case 5:
                    main(args);
                case 6:
                    main(args);
                case 7:
                    main(args);           
                default:
                    main(args);
            }
        }     
    }
    
  //--------------------------------------------------------------------------  
    
    public void manageEmpresa(){
        
        System.out.println("\n\n");
        System.out.println("1. Criar Empresa");
        System.out.println("2. Procurar Empresa");
        System.out.println("3. Sair");
        

        int opc = Consola.lerInt("\n Indique a sua opção: ", 1, 3);
        System.out.print("\n");       
    
            switch(opc) {
                
                case 1:
                    //PEDE O NOME
                    String e_Nome = Consola.lerString("Escreva o Nome da Empresa: ");
                    //PEDE A MORADA
                    String e_Morada = Consola.lerString("Escreva a Morada da Empresa: ");
                    //PEDE O NIF
                    int e_NIF = Consola.lerInt("Digite o NIF da Empresa: ", 100000000, 1000000000);
                    //CRIA OBJETO DO CONSTRUTOR COM OS ATRIBUTOS PEDIDOS ACIMA 
                    e.add(new Empresa(e_NIF, e_Nome, e_Morada));
                    
                    //mostra o criado
                    for (int i=0; i<e.size();i++) {
                            System.out.println(e.get(i));
                    }
//                    System.out.println(Empresa.e.NIF);
                            
                    
                            
                    break;
                    
//                case 2:
//                    int find_NIF = Consola.lerInt("Digite o NIF da Empresa que pretende: ",100000000, 1000000000);
//                    for(int i=0;i<e_counter;i++){
//                        if(b == find_NIF){
//                            System.out.println("Nome da Empresa -> " + e[i].getNome());
//                            System.out.println("NIF da Empresa -> " + e[i].getNIF());
//                            System.out.println("Morada da Empresa -> " + e[i].getMorada());
//                            System.out.print("\n"); }
//                        }  
//                    
//                case 3:
//                    break;
                    
                default:
                    break;
        }
    }
    
    //--------------------------------------------------------------------------  
    
    public void manageMotorista(){
        
        System.out.println("\n\n");
        System.out.println("1. Criar Motorista");
        System.out.println("2. Procurar Motorista");
        System.out.println("3. Sair");
        
        int opc = Consola.lerInt("\n Indique a sua opção: ", 1, 3);
        System.out.print("\n");       
    
            switch(opc) {
                
                case 1:
                    //PEDE O NOME
                    String m_Nome = Consola.lerString("Escreva o Nome do Motorista: ");
                    //PEDE A MORADA
                    String m_Morada = Consola.lerString("Escreva a Morada do Mototrista: ");
                    //PEDE O Telefone
                    int m_Telefone = Consola.lerInt("Digite o Telefone do Mototrista: ", 910000000, 969999999);
                    //PEDE O NIF
                    int m_NIF = Consola.lerInt("Digite o NIF da Mototrista: ", 100000000, 999999999);
                    //PEDE A Empresa
                    int x=1;
                    String m_Empresa ="Desempregado";
                    do{
                        m_Empresa = Consola.lerString("Digite a Empresa do Motorista que pretende: ");
                        for(int i=0;i<e_counter;i++){
                            if( m_Empresa.compareToIgnoreCase(e[i].getNome()) == 0){
                                x=1;
                            }
                        }
                        }while(x==0);
                    //PEDE A Habilitação
                    String m_Habilitação = Consola.lerString("Digite a Habilitação do Condutor: ");
                    //PEDE A Data
                    int dia = Consola.lerInt("Digite o dia de nascimento: ", 1, 31);
                    int mes = Consola.lerInt("Digite o mes de nascimento: ", 1, 12);
                    int ano = Consola.lerInt("Digite o ano de nascimento: ", 1900, 2100);
                    
                    String m_Data = "" + dia +"/"+ mes +"/"+ ano;
                    
                    //CRIA OBJETO DO CONSTRUTOR COM OS ATRIBUTOS PEDIDOS ACIMA
                     m.add(new Motorista(m_NIF, m_Nome, m_Morada, m_Telefone,m_Habilitação, m_Empresa, m_Data));
                    break;
                case 2:
//                    int find_NIF = Consola.lerInt("Digite o NIF do Motorista que pretende: ",100000000, 1000000000);
//                    for(int i=0;i<m_counter;i++){
//                        if(m[i].getNIF() == find_NIF){
//                            System.out.println("Nome do Motorista -> " + m[i].getNome());
//                            System.out.println("NIF do Motorista -> " + m[i].getNIF());
//                            System.out.println("Morada do Motorista -> " + m[i].getMorada());
//                            System.out.println("Telefone do Motorista -> " + m[i].getTelefone());
//                            System.out.println("Empresa do Motorista -> " + m[i].getEmpresa());
//                            System.out.println("Data de nascimento do Motorista -> " + m[i].getData());
//                            System.out.println("Habilitação do Motorista -> " + m[i].getHabilitação());
//                            System.out.print("\n"); }
                    break;
                        }  
                    
                case 3:
                    break;
                    
                default:
                    break;
        }
    }
  //--------------------------------------------------------------------------    
}
