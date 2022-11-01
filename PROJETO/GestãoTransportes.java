package gestãotransportes;
import util.Consola;

public class GestãoTransportes {

 
    public static void main(String[] args) {
        
        //LAYOUT DO MENU
        System.out.println("\nBEM-VINDO AO GESTOR DE TRANSPORTES:\n");
        
        System.out.println("1. Inserir e consultar (através no NIF) todas as empresas registadas");
        System.out.print("2. Inserir, consultar (através no NIF) e alterar dados de motoristas");
        System.out.println("3. Inserir, consultar (através na matrícula) veículos");
        System.out.print("4. Associar veículo a nova empresa");
        System.out.println("5. Registar e consultar avarias");
        System.out.print("6. Registar e consultar (por empresa) serviços de transporte registados");
        System.out.println("7. Outras consultas/estatísticas");
        System.out.print("---------------------------------------------------------------------");
               
        //----------------------------------------------------------------
        
        Scanner opcao = new Scanner(System.in);
        System.out.print("\n Indique a sua opção: ");
        int opc = opcao.nextInt();
       
        System.out.print("\n");


            switch(opc) {
                case 1:
                    
                case 2:
                   
                case 3:
                     
                case 4:
                     
                case 5:
                     
                case 6:
                     
                case 7:
                   
                default:
                    main(args);
                                    }
            
    }    
  //--------------------------------------------------------------------------
    
    if(int a == 1){
        //LAYOUT DO SUB-MENU
        System.out.println("\nSUB-MENU:\n");    
    
        System.out.println("1. Listagem de veículos com mais de n quilómetros realizados");
        System.out.print("2. Listagem das 3 empresas com maior valor faturado");
        System.out.println("3. Total de serviços realizados por empresa");
        System.out.print("4. Média de quilómetros realizados por empresa e por tipo de serviço");
        System.out.println("5. Listagem de funcionários (por empresa)");
        System.out.print("6. Histórico de avarias por veículo.");
        System.out.println("7. Voltar ao Menu Principal");
        System.out.print("---------------------------------------------------------------------");    
    
         Scanner opcao2 = new Scanner(System.in);
        System.out.print("\n Indique a sua opção: ");
        int opc2 = opcao2.nextInt();
       
        System.out.print("\n");       
    
            switch(opc2) {
                case 1:
                    
                case 2:
                   
                case 3:
                     
                case 4:
                     
                case 5:
                     
                case 6:
                     
                case 7:
                    main(args);
                                     
                default:
                    main(args);
                                    }
}          
  //--------------------------------------------------------------------------      
    
    
    
}
