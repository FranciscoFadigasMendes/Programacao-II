package com.mycompany.gestaotransportes;
import java.io.Serializable;
import util.Consola;
import util.Ficheiro;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author Francisco Mendes e Francisco Chen
 */
public class GestaoTransportes implements Serializable {
    
  public static Scanner sc = new Scanner(System.in);
  static ArrayList<Empresa> e = new ArrayList<>();
  static ArrayList<Motorista> m = new ArrayList<>();
  static ArrayList<Veiculo> v = new ArrayList<>();
  static ArrayList<Avaria> a = new ArrayList<>();
  static ArrayList<ServiçoDeTransporte> t = new ArrayList<>();
  
  static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
  
    /**
     * Método que cria o Menu Principal
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        
        loadFiles();
        
        int opc;
     do{
        //LAYOUT DO MENU
        System.out.println("\nBEM-VINDO AO GESTOR DE TRANSPORTES:\n");
        System.out.println("1. Inserir e consultar (através no NIF) todas as empresas registadas");
        System.out.println("2. Inserir, consultar (através no NIF) e alterar dados de motoristas");
        System.out.println("3. Inserir, consultar (através na matrícula) veículos");
        System.out.println("4. Associar veículo a nova empresa");
        System.out.println("5. Registar e consultar avarias");
        System.out.println("6. Registar e consultar (por empresa) serviços de transporte registados");
        System.out.println("7. Outras consultas/estatísticas");
        System.out.println("0. Para terminar o programa e guardar");
        System.out.print("---------------------------------------------------------------------");
               
        opc = Consola.lerInt("\n Indique a sua opção: ", 0, 7);
        System.out.print("\n");
        
            
            switch(opc) {
                case 1:
                    manageEmpresa();
                    break;
                case 2:
                    manageMotorista();
                    break;
                case 3:
                    manageVeículo();
                    break;
                case 4:
                    relocateVeículo();
                    break;
                case 5:
                    manageAvarias();
                    break;
                case 6:
                    manageServiçoDeTransporte();
                    break;
                case 7:
                    outraestatistica();
                    break;
                case 0:
                    saveFiles();
                    break;
                default:
                    break;
                                    }
     }while(opc !=0);
            
    }
    
  //--------------------------------------------------------------------------

    /**
     * Método que cria o Sub-Menu
     */
    public static void outraestatistica(){
        int opc;
        //LAYOUT DO SUB-MENU
        do{
        System.out.println("\nSUB-MENU:\n");   
        System.out.println("1. Listagem de veículos com mais de n quilómetros realizados");
        System.out.println("2. Listagem das 3 empresas com maior valor faturado");
        System.out.println("3. Total de serviços realizados por empresa");
        System.out.println("4. Média de quilómetros realizados por empresa e por tipo de serviço");
        System.out.println("5. Listagem de funcionários (por empresa)");
        System.out.println("6. Histórico de avarias por veículo.");
        System.out.println("7. Voltar ao Menu Principal");
        System.out.print("---------------------------------------------------------------------");
        
        opc = Consola.lerInt("\n Indique a sua opção: ", 0, 7);
            System.out.print("\n");       
 
            switch(opc) {
                case 1:
                    System.out.println("Veículos com quilometragem superior a 'x' ");
                    Listarquilómetros();
                    break;
                case 2:
                    System.out.println("Listagem das 3 empresas com maior valor faturado;");
                    Listartop3();
                    break;
                case 3:
                    System.out.println("Total de serviços realizados por empresa");
                    Total_Serviços_Empresa();
                    break;
                case 4:
                    System.out.println("Média de quilómetros realizados por empresa e por tipo de serviço;");
                    media_km();
                    break;
                case 5:
                    System.out.println("Listar Funcionários por Empresa");
                    list_funcionarios();
                    break;
                case 6:
                    System.out.println("Histórico de avarias por veículo");
                    list_avarias();
                    break;
                default:
                    break;
                }
            }while(opc !=7);
        }
    
  //-------------------------------------------------------------------------
  //--------------------------------------------------------------------------  

    /**
     * Método para Inserir e consultar (através no NIF) todas as empresas registadas
     */
    public static void manageEmpresa(){
        
        System.out.println("\n\n");
        System.out.println("1. Criar Empresa");
        System.out.println("2. Procurar Empresa");
        System.out.println("3. Listar Empresas");
        System.out.println("4. Sair");
        int x=0;
        
        int opc = Consola.lerInt("\n Indique a sua opção: ", 1, 4);
        System.out.print("\n");     

            switch(opc) {
                
                case 1:
                    String e_Nome;
                    do{
                        x=0;
                        e_Nome = Consola.lerString("Escreva o Nome da Empresa: ");
                            if(!e.isEmpty()){
                                for(int i=0;i<e.size();i++){
                                if(e_Nome.compareToIgnoreCase(e.get(i).getNome()) == 0){ x=1;}
                                }
                            }else{x=0;}
                    }while(x!=0);
                    String e_Morada = Consola.lerString("Escreva a Morada da Empresa: ");
                    int e_NIF;
                    do{
                        x=0;
                        e_NIF = Consola.lerInt("Digite o NIF da Empresa: ", 100000000, 1000000000);
                        if(!e.isEmpty()){
                            for(int i=0;i<e.size();i++){
                                if(e_NIF == e.get(i).getNIF()){x=1;}
                            }
                        }else
                            x=0;
                    }while(x!=0);
                    
                    int e_Job_Counter = 0;
                    
                    e.add(new Empresa(e_NIF, e_Nome, e_Morada,e_Job_Counter));
                    //mostra o criado
                    for (int i=0; i<e.size();i++) {
                            e.get(i).mostrarDados();
                            System.out.println(e.size());
                            }
                    break;
                    
                case 2:      
                    int find_NIF = Consola.lerInt("Digite o NIF da Empresa que pretende: ",100000000, 1000000000);
                    int sucesso = 0;
                    
                      for(int i=0;i<e.size();i++)
                        if(find_NIF == e.get(i).getNIF()){
                            e.get(i).mostrarDados();
                            sucesso=1;
                         }
                    if(sucesso == 0)
                        System.out.println("Não há nenhuma Empresa com esse NIF");
                    
                    break;
                    
                case 3:
                    if(e.size()==0){
                        System.out.println("Sem dados");
                        break;
                    }
                    for(int i=0;i<e.size();i++){
                        e.get(i).mostrarDados();
                        System.out.println("//--------------------------------------------------------------------------");
                        System.out.println("\n");
                    }
                    break;
                    
                case 4:
                    
                    break;
                    
                default:
                    break;
        
      }
   }        
    
    //--------------------------------------------------------------------------  

    /**
     * Método para Inserir e consultar (através no NIF) e alterar dados de motoristas
     */
    
    public static void manageMotorista(){
        
        int x=1;
        
        System.out.println("\n\n");
        System.out.println("1. Criar Motorista");
        System.out.println("2. Procurar Motorista");
        System.out.println("3. Listar Motoristas");
        System.out.println("4. Sair");
        
        int opc = Consola.lerInt("\n Indique a sua opção: ", 1, 4);
        System.out.print("\n");       
    
            switch(opc) {
                
                case 1: 
                    String m_Nome = Consola.lerString("Escreva o Nome do Motorista: ");
                    
                    String m_Morada = Consola.lerString("Escreva a Morada do Motorista: ");
                    
                    int m_Telefone = Consola.lerInt("Digite o Telefone do Motorista: ", 910000000, 999999999);
                    
                    int m_NIF = Consola.lerInt("Digite o NIF da Motorista: ", 100000000, 999999999);
                    
                    x=1;
                    String m_Empresa ="Desempregado";
                    do{
                        m_Empresa = Consola.lerString("Digite a Empresa do Motorista que pretende: ");
                        if (e.isEmpty()){
                            System.out.println("Não existem empresas, será enviado ao menu incial!");
                            return;
                        }
                        for(int i=0;i<e.size();i++){
                            e.size();
                            if( m_Empresa.compareToIgnoreCase(e.get(i).getNome()) == 0){ x=0;}
                        }
                        if(x==1){
                            System.out.println("Essa Empresa não existe! Digite Novamente.");
                        }
                        }while(x!=0);
                    
                    String m_Habilitação = "Sem Habilitação";
                    System.out.println("Lista de Habilitações:");
                    System.out.println("0 --> Veículos Ligeiros de Passageiros");
                    System.out.println("1 --> Veículos Ligeiros de Mercadorias");
                    System.out.println("2 --> Veículos Pesados de Mercadorias");
                    System.out.println("3 --> Veículos Pesados de Passageiros");
                    int h = Consola.lerInt("Digite a Habilitação do Condutor: ", 0, 3);
                    if(h==0){m_Habilitação = "Ligeiro de Passageiros";}
                    if(h==1){m_Habilitação = "Ligeiro de Mercadorias";}
                    if(h==2){m_Habilitação = "Pesado de Mercadorias";}
                    if(h==3){m_Habilitação = "Pesado de Passageiros";}
                    
                    
                    int dia = Consola.lerInt("Digite o dia de nascimento: ", 1, 31);  
                    int mes = Consola.lerInt("Digite o mes de nascimento: ", 1, 12);
                    int ano = Consola.lerInt("Digite o ano de nascimento: ", 1900, 2100);
                    
                    String m_Data_1 = dia +"/"+ mes +"/"+ ano; 
                    
                    String m_Data = m_Data_1;
                    
                    String m_Disponibilidade = "Livre";
                    
                    //CRIA OBJETO DO CONSTRUTOR COM OS ATRIBUTOS PEDIDOS ACIMA
                    m.add(new Motorista(m_NIF, m_Nome, m_Morada, m_Telefone,m_Habilitação, m_Empresa, m_Data,m_Disponibilidade));
                    break;
                    
                    
                case 2:
                    
                 int find_NIF = Consola.lerInt("Digite o NIF do Motorista que pretende: ",100000000, 1000000000);
                 int sucesso = 0;
                    
                      for(int i=0;i<m.size();i++)
                        if(find_NIF == m.get(i).getNIF()){
                            m.get(i).mostrarDados();
                            sucesso=1;
                         }
                    if(sucesso == 0)
                        System.out.println("Não há nenhum Motorista com esse NIF");
                    break; 
                    
                case 3:
                    if(m.size()==0){
                        System.out.println("Sem dados");
                        break;
                    }
                    for(int i=0;i<m.size();i++){
                        m.get(i).mostrarDados();
                        System.out.println("//--------------------------------------------------------------------------");
                        System.out.println("\n");
                    }
                    break;
                    
                case 4:
                    break;
                    
                default:
                    break;
        }
    }
    
  //-------------------------------------------------------------------------- 

    /**
     * Método para Inserir e consultar (através da matrícula) veículos
     */
    public static void manageVeículo(){
        System.out.println("\n\n");
        System.out.println("1. Criar Veículo");
        System.out.println("2. Procurar Veículo");
        System.out.println("3. Listar Veículo");
        System.out.println("4. Sair");
        
        int opc = Consola.lerInt("\n Indique a sua opção: ", 1, 4);
        int opc1 = 0;
        System.out.print("\n");

            switch(opc) {
                case 1:
                    String v_marca = Consola.lerString("Digite a marca do veículo: ");
                    
                    String v_modelo = Consola.lerString("Digite o modelo do carro: ");
                    
                    int v_AnoRegisto = Consola.lerInt("Digite o ano de registo do veículo: ", 1923, 2100);
                    
                    String v_matricula = "00-00-00";
                        if(v_AnoRegisto>=1923 && v_AnoRegisto<=1992){
                            System.out.println("Dado o ano do veículo, digite a matrícula no formato: AB-01-23");
                                String c1 = Consola.lerString("(2 Letras Maiusculas - AB): ");
                                String c2 = Consola.lerString("(2 Números): ");
                                String c3 = Consola.lerString("(2 Números): ");
                            v_matricula = c1+"-"+c2+"-"+c3;
                        }
                        if(v_AnoRegisto>1992 && v_AnoRegisto<=2005){
                            System.out.println("Dado o ano do veículo, digite a matrícula no formato: 01-23-AB");
                                String c1 = Consola.lerString("(2 Números): ");
                                String c2 = Consola.lerString("(2 Números): ");
                                String c3 = Consola.lerString("(2 Letras Maiusculas - AB): ");
                            v_matricula = c1+"-"+c2+"-"+c3;   
                        }
                        if(v_AnoRegisto>2005 && v_AnoRegisto<=2020){
                            System.out.println("Dado o ano do veículo digite a matrícula no formato: 01-AB-23");
                                String c1 = Consola.lerString("2 Números :");
                                String c2 = Consola.lerString("(2 Letras Maiusculas - AB): ");
                                String c3 = Consola.lerString("2 Números :");
                            v_matricula = c1+"-"+c2+"-"+c3;
                        }
                        if( v_AnoRegisto>2020 ){
                            System.out.println("Dado o ano do veículo digite a matrícula no formato: AB-01-CD");
                                String c1 = Consola.lerString("(2 Letras Maiusculas - AB): ");
                                String c2 = Consola.lerString("2 Números :");
                                String c3 = Consola.lerString("(2 Letras Maiusculas - AB): ");
                            v_matricula = c1+"-"+c2+"-"+c3;
                        }
                        System.out.println(""+v_matricula);
                    int v_quilometragem = 0; //vamos assumir todos os carros como novos
                    
                    int v_cilindrada = Consola.lerInt("Digite a cilindrada do veículo(em cc's):",500, 10000);
                    
                    String v_tipo = "Por Definir";
                    System.out.println("Digite o tipo de veículo: ");
                        opc = Consola.lerInt("1-Ligeiro / 2- Pesado: ",1,2);
                            if(opc == 1){
                                opc1 = Consola.lerInt("1-Mercadorias / 2- Passageiros: ",1,2); 
                                    if(opc1 == 1){v_tipo = "Ligeiro de Mercadorias";}
                                    if(opc1 == 2){v_tipo = "Ligeiro de Passageiros";}
                            }
                            
                            if(opc == 2){
                                opc1 = Consola.lerInt("1-Mercadorias / 2- Passageiros: ",1,2); 
                                    if(opc1 == 1){v_tipo = "Pesado de Mercadorias";}
                                    if(opc1 == 2){v_tipo = "Pesado de Passageiros";}
                            }
                        
                    int v_capacidade = 0;
                        if(opc==1 && opc1==1){v_capacidade = Consola.lerInt("Capacidade (Kg) :", 0, 50000);}
                        if(opc==1 && opc1==2){v_capacidade = Consola.lerInt("Capacidade (Pessoas) :", 0, 100);}
                        if(opc==2 && opc1==1){v_capacidade = Consola.lerInt("Capacidade (Kg) :", 0, 50000);}
                        if(opc==2 && opc1==2){v_capacidade = Consola.lerInt("Capacidade (Pessoas) :", 0, 100);}
                    
                    String v_empresa ="Sem Empresa Associada";
                    int a=1;
                    do{
                    int b = Consola.lerInt("Pretende associar já a uma empresa? Pode fazê-lo mais tarde! (Não - '0' Sim - '1'): ", 0, 1);
                      if(b == 1){
                        int x=1;
                        do{
                            String temp = Consola.lerString("Digite a Empresa associada ao seu veículo: ");
                            for(int i=0;i<e.size();i++){
                                System.out.println("\nTEMP: " + temp +" ---- "+ e.get(i).getNome()); //------------APAGAR---------------------
                                if(temp.compareToIgnoreCase(e.get(i).getNome()) == 0){
                                    v_empresa = temp;
                                    System.out.println("A empressa associada é :"+ v_empresa);
                                    x=0;
                                }
                            }
                            if(x!=0)
                                System.out.println("Essa Empresa não existe! Adicione mais tarde!.");
                            
                        }while(x!=0);
                        a=0;
                      }
                      if(b == 0)
                          a=0;
                    }while(a!=0);
                    
                    String v_avaria = "Operacional";
                    String v_Disponibilidade = "Livre";
                 
                    //CRIA OBJETO DO CONSTRUTOR COM OS ATRIBUTOS PEDIDOS ACIMA
                    v.add(new Veiculo(v_marca, v_modelo, v_matricula,v_AnoRegisto,v_quilometragem,v_cilindrada,v_tipo,v_capacidade,v_empresa,v_avaria,v_Disponibilidade));
                    break;
                    

                case 2:
                    
                    System.out.println("Digite a matricula do veículo que pretende caracter a caracter (XX-XX-XX): ");
                    int sucesso=10,ans=2;
                    String find_matricula = "";
                    String c1 = null,c2 = null,c3 = null;
                    
                        ans = Consola.lerInt("Insira o tipo do dois primeiros caracteres (0-Letra/1-Numero) : ", 0, 1);
                            if(ans == 0){c1 = Consola.lerString("2 Letras Maiusculas : ");}
                            if(ans == 1){c1 = Consola.lerString("2 Numeros : ");}
                        ans = Consola.lerInt("Insira o tipo do terceiro e quarto caracteres (0-Letra/1-Numero) : ", 0, 1);
                            if(ans == 0){c2 = Consola.lerString("2 Letra Maiusculas : ");}
                            if(ans == 1){c2 = Consola.lerString("2 Numero : ");}
                        ans = Consola.lerInt("Insira o tipo do quinto e sexto caracteres (0-Letra/1-Numero) : ", 0, 1);
                            if(ans == 0){c3 = Consola.lerString("2 Letra Maiusculas : ");}
                            if(ans == 1){c3 = Consola.lerString("2 Numeros : ");}
                    
                    find_matricula = c1+"-"+c2+"-"+c3;
                      
                      for(int i=0;i<v.size();i++)
                        if(find_matricula.compareToIgnoreCase(v.get(i).getMatricula()) == 0){
                            System.out.println("\n");
                            v.get(i).mostrarDados();
                            System.out.println("\n");
                            sucesso=1;
                         }
                    if(sucesso == 0)
                        System.out.println("Não há nenhuma matrícula igual à pedida!");
                    break;
                case 3:
                    if(v.size()==0){
                        System.out.println("Sem dados");
                        break;
                    }
                    for(int i=0;i<v.size();i++){
                        v.get(i).mostrarDados();
                        System.out.println("//--------------------------------------------------------------------------");
                        System.out.println("\n");
                    }
                    break;
                    
                case 4:
                    break;
                    
                default:
                    break;
            }
    }
    
  //--------------------------------------------------------------------------
     
    /**
     * Método para Associar um véiculo a uma Nova Empresa
     */
    public static void relocateVeículo(){
         
         System.out.println("Digite a matricula do veículo que pretende caracter a caracter (XX-XX-XX): ");
                    int sucesso=0,ans,x=1,i=0;
                    String find_matricula;
                    String c1 = null,c2 = null,c3 = null;
                    
                        ans = Consola.lerInt("Insira o tipo do dois primeiros caracteres (0-Letra/1-Numero) : ", 0, 1);
                            if(ans == 0){c1 = Consola.lerString("2 Letras Maiusculas : ");}
                            if(ans == 1){c1 = Consola.lerString("2 Numeros : ");}
                        ans = Consola.lerInt("Insira o tipo do terceiro e quarto caracteres (0-Letra/1-Numero) : ", 0, 1);
                            if(ans == 0){c2 = Consola.lerString("2 Letras Maiusculas : ");}
                            if(ans == 1){c2 = Consola.lerString("2 Numeros : ");}
                        ans = Consola.lerInt("Insira o tipo do quinto e sexto caracteres (0-Letra/1-Numero) : ", 0, 1);
                            if(ans == 0){c3 = Consola.lerString("2 Letras Maiusculas : ");}
                            if(ans == 1){c3 = Consola.lerString("2 Numeros : ");}
                    
                    find_matricula = c1+"-"+c2+"-"+c3;
                    
                    
                      for(i=0;i<v.size();i++){
                        if(find_matricula.compareToIgnoreCase(v.get(i).getMatricula()) == 0){
                            v.get(i).mostrarDados();
                            System.out.println("\n");
                            String temp = Consola.lerString("Digite o nome da Empresa: "); 
                      
                             for(int a=0;a<e.size();a++){
                                if(temp.compareToIgnoreCase(e.get(a).getNome()) == 0)
                                   v.get(a).setEmpresa(temp);
                                   
                                if(x==0){
                                    System.out.println("A empressa associada vai passar a ser a :"+ e.get(a).getNome());
                                }
                            if(x!=0)
                                System.out.println("Essa Empresa não existe! Adicione mais tarde!.");
                            }
                            sucesso=1;
                         }
                      }
                    if(sucesso == 0)
                        System.out.println("Não há nenhuma matrícula igual à pedida!");
     }
     
  //--------------------------------------------------------------------------      

    /**
     * Método para Registar e Consultar Avarias
     * @throws ParseException
     */
     
      public static void manageAvarias() throws ParseException{
          int sucesso=0,ans=2;
        
        System.out.println("\n\n");
        System.out.println("1. Registar Avaria");
        System.out.println("2. Consultar Avaria");
        System.out.println("3. Listar Avaria");
        System.out.println("4. Sair");
        
        int opc = Consola.lerInt("\n Indique a sua opção: ", 1, 4);
        System.out.print("\n");

            switch(opc) {
                case 1:
                    if(v.isEmpty()){
                        return;
                    }
                     do{
                         System.out.println("Digite a matricula do veículo que pretende caracter a caracter (XX-XX-XX): ");
                         String find_matricula = "";
                         String c1 = null,c2 = null,c3 = null;
                    
                        ans = Consola.lerInt("Insira o tipo do dois primeiros caracteres (0-Letra/1-Numero) : ", 0, 1);
                            if(ans == 0){c1 = Consola.lerString("2 Letras Maiusculas : ");}
                            if(ans == 1){c1 = Consola.lerString("2 Numeros : ");}
                        ans = Consola.lerInt("Insira o tipo do terceiro e quarto caracteres (0-Letra/1-Numero) : ", 0, 1);
                            if(ans == 0){c2 = Consola.lerString("2 Letras Maiusculas : ");}
                            if(ans == 1){c2 = Consola.lerString("2 Numeros : ");}
                        ans = Consola.lerInt("Insira o tipo do quinto e sexto caracteres (0-Letra/1-Numero) : ", 0, 1);
                            if(ans == 0){c3 = Consola.lerString("2 Letras Maiusculas : ");}
                            if(ans == 1){c3 = Consola.lerString("2 Numeros : ");}
                    
                    find_matricula = c1+"-"+c2+"-"+c3;
                    
                      for(int i=0;i<v.size();i++)
                        if(find_matricula.compareToIgnoreCase(v.get(i).getMatricula()) == 0){
                            System.out.println("\n");
                            v.get(i).mostrarDados();
                            sucesso=1;
                            ans=i;
                            v.get(i).avaria = "Avariado";
                        }
                            if(sucesso == 0)
                                System.out.println("Não há nenhuma matrícula igual à pedida!");
          }while(sucesso==0);
                     
          String v_descrição_danos = Consola.lerString("Descreva os danos do veiculo: ");
          float v_custo = Consola.lerFloat("Custo previsto (em euros): ", 0, 10000);
          
          int dia = Consola.lerInt("Digite o dia da avaria: ", 1, 31);
          int mes = Consola.lerInt("Digite o mes da avaria: ", 1, 12);
          int ano = Consola.lerInt("Digite o ano da avaria: ", 1900, 2100);
          
          String m_Data_1 = "" + dia +"/"+ mes +"/"+ ano;
          Date m_Data = dateFormat.parse(m_Data_1);
          
          dia = Consola.lerInt("Digite o dia em que vai estar operacional: ", 1, 31);
          mes = Consola.lerInt("Digite o mes em que vai estar operacional: ", 1, 12);
          ano = Consola.lerInt("Digite o ano em que vai estar operacional: ", 1900, 2100);
          
          String m_Data1_1 = "" + dia +"/"+ mes +"/"+ ano;
          
          Date m_Data1 = dateFormat.parse(m_Data1_1);
          long time_difference = Math.abs(m_Data1.getTime() - m_Data.getTime());
          long v_periodo_parado = TimeUnit.DAYS.convert(time_difference, TimeUnit.MILLISECONDS);
          System.out.println("Dias Parado = "+v_periodo_parado);
          
          a.add(new Avaria(v.get(ans), v_descrição_danos, v_custo, v_periodo_parado));
          
          break;
                    

            case 2:
                do{
                         System.out.println("Digite a matricula do veículo que pretende caracter a caracter (XX-XX-XX): ");
                         String find_matricula = "";
                         String c1 = null,c2 = null,c3 = null;
                    
                        ans = Consola.lerInt("Insira o tipo do dois primeiros caracteres (0-Letra/1-Numero) ", 0, 1);
                            if(ans == 0){c1 = Consola.lerString("2 Letras Maiusculas : ");}
                            if(ans == 1){c1 = Consola.lerString("2 Numeros : ");}
                        ans = Consola.lerInt("Insira o tipo do terceiro e quarto caracteres (0-Letra/1-Numero) : ", 0, 1);
                            if(ans == 0){c2 = Consola.lerString("2 Letras Maiusculas : ");}
                            if(ans == 1){c2 = Consola.lerString("2 Numeros : ");}
                        ans = Consola.lerInt("Insira o tipo do quinto e sexto caracteres (0-Letra/1-Numero) : ", 0, 1);
                            if(ans == 0){c3 = Consola.lerString("2 Letras Maiusculas : ");}
                            if(ans == 1){c3 = Consola.lerString("2 Numeros : ");}
                    
                        find_matricula = c1+"-"+c2+"-"+c3;
                    
                    
                      for(int i=0;i<a.size();i++){
                        if(find_matricula.compareToIgnoreCase(a.get(i).getMatricula()) == 0){
                            a.get(i).mostrarDados();
                            sucesso=1;
                         }
                      }
                             if(sucesso == 0)
                                System.out.println("Não há nenhuma matrícula igual à pedida!");
                         }while(sucesso==0);

                break;
            
            case 3:
                if(a.size()==0){
                        System.out.println("Sem dados");
                        break;
                    }
                    for(int i=0;i<a.size();i++){
                        a.get(i).mostrarDados();
                        System.out.println("//--------------------------------------------------------------------------");
                        System.out.println("\n");
                    }
                    break;
                    
            
            case 4:
                break;
            default:
                break;    
      }
}
     
//-------------------------------------------------------------------------- 

    /**
     * Método para Registar e Consultar (por Empresa) serviços de transporte registados
     */
      
     public static void manageServiçoDeTransporte(){
         
        System.out.println("\n\n");
        System.out.println("1. Registar Serviço de Transporte");
        System.out.println("2. Consultar Serviço de Transporte");
        System.out.println("3. Listar Serviço de Transporte");
        System.out.println("4. Sair");
        
        int opc = Consola.lerInt("\n Indique a sua opção: ", 1, 4);
        String t_VeiculoAssociado = "Sem Veículo Associado";
        int sucesso=0,ans=2,b=0,i=0,k=0,P=5,r=0;
        String t_TipoTransporte = "";
        
        switch(opc) {
                case 1:
                    
                    String t_LocalOrigem = Consola.lerString("Local de Origem: ");
                    
                    String t_LocalDestino = Consola.lerString("Local de Destino: ");
                    
                    int t_Distância = Consola.lerInt("Distância (em KM): ", 0, 1000000);
                    
                    int dia_i = Consola.lerInt("Digite o dia de Inicio: ", 1, 31);
                    int mes_i = Consola.lerInt("Digite o mes de Inicio: ", 1, 12); 
                    int ano_i = Consola.lerInt("Digite o ano de Inicio: ", 1900, 2100);   
                    String t_DataInicio = "" + dia_i +"/"+ mes_i +"/"+ ano_i;
                    
                    int dia_f = Consola.lerInt("Digite o dia de Fim: ", 1, 31);
                    int mes_f = Consola.lerInt("Digite o mes de Fim: ", 1, 12); 
                    int ano_f = Consola.lerInt("Digite o ano de Fim: ", 1900, 2100);   
                    String t_DataFim = "" + dia_f +"/"+ mes_f +"/"+ ano_f;
                    
                    do{
                        if(v.size()==0){
                        System.out.println("Sem dados");
                        break;
                    }
                    for(i=0;i<v.size();i++){
                        v.get(i).mostrarDados();
                        System.out.println("//--------------------------------------------------------------------------");
                        System.out.println("\n");
                    }
                         System.out.println("Digite a matricula do veículo que pretende caracter a caracter (XX-XX-XX): ");
                         String find_matricula = "";
                         String c1 = null,c2 = null,c3 = null;
                    
                        ans = Consola.lerInt("Insira o tipo do dois primeiros caracteres (0-Letra/1-Numero) ", 0, 1);
                            if(ans == 0){c1 = Consola.lerString("2 Letras Maiusculas : ");}
                            if(ans == 1){c1 = Consola.lerString("2 Numeros : ");}
                        ans = Consola.lerInt("Insira o tipo do terceiro e quarto caracteres (0-Letra/1-Numero) : ", 0, 1);
                            if(ans == 0){c2 = Consola.lerString("2 Letras Maiusculas : ");}
                            if(ans == 1){c2 = Consola.lerString("2 Numeros : ");}
                        ans = Consola.lerInt("Insira o tipo do quinto e sexto caracteres (0-Letra/1-Numero) : ", 0, 1);
                            if(ans == 0){c3 = Consola.lerString("2 Letras Maiusculas : ");}
                            if(ans == 1){c3 = Consola.lerString("2 Numeros : ");}
                    
                    find_matricula = c1+"-"+c2+"-"+c3;

                    
                      for(i=0;i<v.size();i++){
                        if(find_matricula.compareToIgnoreCase(v.get(i).getMatricula()) == 0){
                            System.out.println("\nVeículo: \n");
                            v.get(i).mostrarDados();
                            t_VeiculoAssociado = v.get(i).getMatricula();
                            sucesso=1;
                            b=i;
                            v.get(b).Disponibilidade = v.get(i).marca+" "+v.get(i).modelo+"-->Ocupado até-->"+t_DataFim;
                            v.get(b).quilometragem += t_Distância;
                            t_TipoTransporte = v.get(b).tipo;
                            System.out.println(v.get(b).tipo);
                         }
                      }
                             if(sucesso == 0)
                                System.out.println("Não há nenhuma matrícula igual à pedida!");
                         }while(sucesso==0);
            
                    float t_Preço_Quilómetro = Consola.lerInt("Preço por Quilómetro (em euros):", 0,1000000);
                    
                    int t_Lotacao = 0;
                    String s = "";
                    String s1 ="Ligeiro de Mercadorias",s2="Pesado de Mercadorias",s3="Pesado de Passageiros",s4="Ligeiro de Passageiros";
                        do{
                        P=1;
                        if(v.get(b).tipo.compareToIgnoreCase(s1) == 0){
                            t_Lotacao = Consola.lerInt("Lotação (Kg) :", 0, 50000);
                            s=s1;}
                        if(v.get(b).tipo.compareToIgnoreCase(s4) == 0){
                            t_Lotacao = Consola.lerInt("Lotação (Pessoas) :", 0, 100);
                            s=s4;}    
                        if(v.get(b).tipo.compareToIgnoreCase(s2) == 0){
                            t_Lotacao = Consola.lerInt("Lotação (Kg) :", 0, 50000);
                            s=s2;}
                        if(v.get(b).tipo.compareToIgnoreCase(s3) == 0){
                            t_Lotacao = Consola.lerInt("Lotação (Pessoas) :", 0, 100);
                            s=s3;}
                        if(t_Lotacao <= v.get(b).capacidade){b=22;}
                        }while(b!=22);
                        
                        System.out.println("Valor de S: "+s);
                        
                    String t_MotoristaAssociado = "";
                    String Disponibilidade = "Livre";
                    do{
                    for(i=0;i<m.size();i++){
                        System.out.println("\n");
                        m.get(i).mostrarDados();
                        System.out.println("\n");
                        }
                        String MotoristaAssociado = Consola.lerString("Escreva o Nome do Motorista que quer associar: ");
                        for(k=0;k<m.size();k++){
                            if(MotoristaAssociado.compareToIgnoreCase(m.get(k).getNome()) == 0 && s.compareToIgnoreCase(m.get(k).getHabilitação())== 0 && Disponibilidade.compareToIgnoreCase(m.get(k).getDisponibilidade())==0){
                                t_MotoristaAssociado = m.get(k).getNome();
                                P=0;
                            }
                        }
                        if(P!=0){
                            System.out.println("Não há motoristas disponiveis com essa Habilitação");
                            r = Consola.lerInt("Pretende  cancelar a criação deste Serviço? Sim - 1 / Não - 0 : ", 0, 1);
                        }
                        if(r == 1)
                            break;
                    }while(P!=0);
                     
                    
                    String t_EmpresaAssociada = ""; 
                    if(r == 0){   
                    do{
                        sucesso=0;
                        
                        if(e.size()==0){
                        System.out.println("Sem dados");
                        break;
                        }
                        for(i=0;i<e.size();i++){
                        e.get(i).mostrarDados();
                        System.out.println("//--------------------------------------------------------------------------");
                        System.out.println("\n");
                    }
                        String EmpresaAssociada = Consola.lerString("Escreva a Empresa que quer associar: ");
                                for(i=0;i<e.size();i++){
                                    if(EmpresaAssociada.compareToIgnoreCase(e.get(i).getNome()) == 0){ 
                                        t_EmpresaAssociada = EmpresaAssociada;
                                        sucesso=1;}
                                    }
                                
                                if(e.isEmpty()){
                                    System.out.println("Não Existem Empresas");
                                    return;}
                                
                    }while(sucesso!=1);
                    
                    if(sucesso==1){
                    t.add(new ServiçoDeTransporte(t_LocalOrigem,t_LocalDestino,t_Distância,t_DataInicio,t_DataFim,t_TipoTransporte,t_Preço_Quilómetro,t_Lotacao,t_VeiculoAssociado,t_MotoristaAssociado,t_EmpresaAssociada));
                    break;
                    }
                    }
                    break;

                    
                case 2:
                    sucesso = 0;
                    t_EmpresaAssociada = Consola.lerString("Digite o nome da Empresa para os serviços que oferece: ");
                    for(i=0;i<t.size();i++){
                        if(t_EmpresaAssociada.compareToIgnoreCase(t.get(i).getEmpresaAssociada()) == 0){
                            System.out.println("\n");
                            t.get(i).mostrarDados();
                            sucesso=1;}
                         }
                    if(sucesso == 0)
                        System.out.println("Não há nenhuma Empresa igual à pedida!");
                    break;
                
                case 3:
                    if(t.size()==0){
                        System.out.println("Sem dados");
                        break;
                    }
                    for(i=0;i<t.size();i++){
                        t.get(i).mostrarDados();
                        System.out.println("//--------------------------------------------------------------------------");
                        System.out.println("\n");
                    }
                    break;
                    
                case 4:
                    break;
                default:
                    break;   
            } 
   }
     
  //-------------------------------------------------------------------------- 

    /**
     * Método que faz a listagem de veículos com mais de "x" quilómetros realizados. 
     * Sendo o valor de "x" solicitado ao utilizador
     */
    public static void Listarquilómetros(){
        int n = Consola.lerInt("Digite a Quilómetragem : ", 0, 999999999);
        for(int i=0;i<v.size();i++){
            if(v.get(i).getQuilometragem()>=n){
                System.out.println("Veículo nº"+ i +": "+v.get(i).marca+" "+v.get(i).modelo+"--> Km's = "+v.get(i).getQuilometragem());
            }
        }
    }
    
  //-------------------------------------------------------------------------- 

    /**
     * Método que faz a Listagem das 3 empresas com o maior valor faturado
     */
    public static void Listartop3(){

        float profit[][] = new float[e.size()][t.size()];
        float profit_empresa[] = new float[e.size()];
        float profit_empresa1[] = new float[e.size()];
        int i=0,a=0;
        
        for(i=0;i<e.size();i++){
            for(a=0;a<t.size();a++){
                if(e.get(i).getNome().compareToIgnoreCase(t.get(a).getEmpresaAssociada()) == 0){
                    System.out.println(t.get(a).getEmpresaAssociada());
                    t.get(a).getPreço_Quilómetro();
                    t.get(a).getDistância();
                    profit[i][a] = t.get(a).getPreço_Quilómetro()*t.get(a).getDistância();
                }
            }

            for(a=0;a<t.size();a++){
                profit_empresa[i] += profit[i][a];
                profit_empresa1[i] = profit_empresa[i];
                System.out.println(profit_empresa[i]);
                }
            System.out.println("Total da Empresa "+e.get(i).getNome()+" : " + profit_empresa[i]+" euros");
        }
        
        
       
        Arrays.sort(profit_empresa);
        for(i=profit_empresa.length -1 ;i > profit_empresa.length -4;i--){
            for(a=0;a<e.size();a++){
                if(profit_empresa[i] == profit_empresa1[a]){
                    System.out.println(profit_empresa.length-i+"º-"+e.get(a).getNome()+": "+profit_empresa[i]);
                }
            }
        }
    }
    
  //-------------------------------------------------------------------------- 

    /**
     * Método que mostra o Total de Serviçoes Realizados por Empresa 
     * (incluindo o valor total de quilómetros realizados e valor de faturação por empresa)
     */
    public static void Total_Serviços_Empresa(){
        
        int quilometragem = 0,total = 0;
        float profit[][] = new float[e.size()][t.size()];
        float profit_empresa[] = new float[e.size()];

        for(int i=0;i<e.size();i++){
            total = 0;
            for(int d=0;d<t.size();d++){
                if(e.get(i).getNome().compareToIgnoreCase(t.get(d).getEmpresaAssociada()) == 0){
                    total ++;
                }
            }
            System.out.println("\nTotal de serviços realizados pela Empresa '"+e.get(i).getNome()+"' :" + total);
            
            for(int c=0;c<v.size();c++){
              if(e.get(i).getNome().compareToIgnoreCase(v.get(c).getEmpresa()) == 0){    
                quilometragem += v.get(c).getQuilometragem();
              }
            }        
            System.out.println("Total de kms realizados pela Empresa '"+e.get(i).getNome()+"' :"+quilometragem);
            
            for(int a=0;a<t.size();a++){
                if(e.get(i).getNome().compareToIgnoreCase(t.get(a).getEmpresaAssociada()) == 0){
                    profit[i][a] = t.get(a).getDistância()*t.get(a).getPreço_Quilómetro();
                }
            }
            for(int b=0;b<e.size();b++){
                profit_empresa[i] += profit[i][b];
            }
            
            System.out.println("Total faturado pela Empresa '"+e.get(i).getNome()+"':" + profit_empresa[i]); 
        }   
    }
    
//-------------------------------------------------------------------------- 

    /**
     * Método que faz a média de km's realizados por empresa e tipo de serviço
     */
    public static void media_km(){

        float media_km[][] = new float[e.size()][4];
        float media_km_empresa = 0;
        int L = 0;
        
        for(int i=0;i<e.size();i++){
            L = 0;
            System.out.println("\nEmpresa -> "+ e.get(i).getNome() +":");
            
            for(int a=0;a<t.size();a++){
                if(e.get(i).getNome().compareToIgnoreCase(t.get(a).getEmpresaAssociada()) == 0 && v.get(i).getTipo().compareToIgnoreCase("Ligeiro de Mercadorias") == 0){
                     media_km[i][1] += t.get(a).getDistância();
                     L++;
                }
                
                if(e.get(i).getNome().compareToIgnoreCase(t.get(a).getEmpresaAssociada()) == 0 && v.get(i).getTipo().compareToIgnoreCase("Ligeiro de Passageiros") == 0){
                     media_km[i][2] += t.get(a).getDistância();
                     L++;
                }
                
                if(e.get(i).getNome().compareToIgnoreCase(t.get(a).getEmpresaAssociada()) == 0 && v.get(i).getTipo().compareToIgnoreCase("Pesado de Mercadorias") == 0){
                     media_km[i][3] += t.get(a).getDistância();
                     L++;
                }
                
                if(e.get(i).getNome().compareToIgnoreCase(t.get(a).getEmpresaAssociada()) == 0 && v.get(i).getTipo().compareToIgnoreCase("Pesado de Passageiros") == 0){
                     media_km[i][4] += t.get(a).getDistância();
                     L++;
                }
            }
            
            if(v.get(i).getTipo().compareToIgnoreCase("Ligeiro de Mercadorias") == 0){
            media_km_empresa =  media_km[i][1] / L;
            System.out.println("\nLigeiro de Mercadorias:");
            System.out.println("\nEmpresa -> "+ e.get(i).getNome() +" - Media de Km's :"+ media_km_empresa);
            }
            
            if(v.get(i).getTipo().compareToIgnoreCase("Ligeiro de Passageiros") == 0){
            media_km_empresa =  media_km[i][2] / L;
            System.out.println("\nLigeiro de Passageiros:");
            System.out.println("\nEmpresa -> "+ e.get(i).getNome() +" - Media de Km's :"+ media_km_empresa);
            }
            
            if(v.get(i).getTipo().compareToIgnoreCase("Pesado de Mercadorias") == 0){
            media_km_empresa =  media_km[i][3] / L;
            System.out.println("\nPesado de Mercadorias:");
            System.out.println("\nEmpresa -> "+ e.get(i).getNome() +" - Media de Km's :"+ media_km_empresa);
            }
            
            if(v.get(i).getTipo().compareToIgnoreCase("Pesado de Passageiros") == 0){
            media_km_empresa =  media_km[i][4] / L;
            System.out.println("\nPesado de Passageiros:");
            System.out.println("\nEmpresa -> "+ e.get(i).getNome() +" - Media de Km's :"+ media_km_empresa);
            }
            
        }
    }
    
//-------------------------------------------------------------------------- 

    /**
     * Método que faz a listagem de funcionários (por Empresa)
     */
    public static void list_funcionarios(){  
        
        for(int i=0;i<e.size();i++){
            System.out.println("\n\nEmpresa -> "+ e.get(i).getNome() +" --Lista de Funcionários :");
                for(int a=0;a<m.size();a++){
                    if(e.get(i).getNome().compareToIgnoreCase(m.get(a).getEmpresa()) == 0){ 
                        System.out.println("\n-->Nome: "+m.get(a).getNome());
                    }
                }
            }
    }
 //-------------------------------------------------------------------------- 

    /**
     * Método que mostra o Histórico de Avarias por Veículo
     */
    public static void list_avarias(){
        int counter = 0;
        
        //Histórico de avarias por veículo.
        for(int i=0;i<v.size();i++){            
            if(v.get(i).getAvaria().compareToIgnoreCase("Operacional") != 0)
                counter++; 
        System.out.println("\nVeículo "+ v.get(i).getMarca()+" "+v.get(i).getModelo() +" - Nº de Avarias: "+counter);
        }
    }   
    
  //-------------------------------------------------------------------------- 
  //-------------------------------------------------------------------------- 

    /**
     * Método que carrega os ficheiros da última sessão
     */
    public static void loadFiles(){
        System.out.println("\n\n");
        System.out.println("Pretende Importar os Ficheiros com Dados anteriores?");
        System.out.println("1-Sim");
        System.out.println("0-Não");
        
        int opc = Consola.lerInt("Resposta: ",0, 1);
                   
        if(opc==0){
            e = new ArrayList<>();
            m = new ArrayList<>();
            v = new ArrayList<>();
            a = new ArrayList<>();
            t = new ArrayList<>();
        }
           
        if(opc==1) {
            e = Ficheiro.lerArrayListFicheiro("listEmpresa.bin");  
            
                if(e == null){
                    e = new ArrayList<>();
                    System.out.println("\nNão Há Info A Herdar De Ficheiros Passados");
                }
                
                System.out.println("\nFicheiros de Empresa Lidos");
                
            m = Ficheiro.lerArrayListFicheiro("listMotorista.bin");
            
                 if(m == null){
                    m = new ArrayList<>();
                    System.out.println("Não há info a herdar de ficheiros passados");
                }
                 
                System.out.println("\nFicheiros de Motoristas Lidos");
             
            v = Ficheiro.lerArrayListFicheiro("listVeiculos.bin");
            
                 if(v == null){
                    v = new ArrayList<>();
                    System.out.println("Não há info a herdar de ficheiros passados");
                }
                 
                System.out.println("\nFicheiros de Veículos Lidos");
            
            a = Ficheiro.lerArrayListFicheiro("listAvarias.bin");
            
                 if(a == null){
                    a = new ArrayList<>();
                    System.out.println("Não há info a herdar de ficheiros passados");
                }
                 
                System.out.println("\nFicheiros de Avarias Lidos");
           
        
            t = Ficheiro.lerArrayListFicheiro("listAvarias.bin");
            
                 if(t == null){
                    t = new ArrayList<>();
                    System.out.println("Não há info a herdar de ficheiros passados");
                }
                 
                System.out.println("\nFicheiros de Serviço de Transporte Lidos");
            }
     }

    /**
     * Método que grava as informações todas da sessão atual e encerra o programa
     */
    public static void saveFiles(){
        System.out.println("O programa vai encerrar...");
        Ficheiro.gravarArrayListFicheiro(e, "listEmpresa.bin" );
        Ficheiro.gravarArrayListFicheiro(m, "listMotorista.bin");
        Ficheiro.gravarArrayListFicheiro(v, "listVeiculos.bin");
        Ficheiro.gravarArrayListFicheiro(a, "listAvarias.bin");
        Ficheiro.gravarArrayListFicheiro(t, "listServiçosTransporte.bin");
        System.out.println("Ficheiros Guardados!");
   }
    
//--------------------------------------------------------------------------
}
