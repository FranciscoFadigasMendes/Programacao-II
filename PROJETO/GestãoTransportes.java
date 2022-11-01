package gestãotransportes;
import util.Consola;

public class GestãoTransportes {

 
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
                    System.out.println("opc1");
                    main(args);
                case 2:
                    System.out.println("opc2");
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
    
    
}
