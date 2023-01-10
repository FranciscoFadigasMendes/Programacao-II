package com.mycompany.gestaotransportes;
import util.Ficheiro;
import java.io.Serializable;

/**
 *
 * @author Francisco Mendes e Francisco Chen
 */
public class Avaria extends Veiculo implements Serializable {
    
    //ATRIBUTOS
    protected String descrição_danos;
    protected float custo;
    protected long periodo_parado;
    //CONSTRUTOR
     
    /**
     *
     * @param v
     * @param descrição_danos
     * @param custo
     * @param periodo_parado
     */
    public Avaria(Veiculo v,String descrição_danos,float custo,long periodo_parado){         
        super(v.marca,v.modelo,v.matricula,v.AnoRegisto,v.quilometragem,v.cilindrada,v.tipo,v.capacidade,v.empresa,v.avaria,v.Disponibilidade);
        this.descrição_danos = descrição_danos;
        this.custo = custo;
        this.periodo_parado = periodo_parado;
    }
     
    /**
     * Método para mostrar os atributos todos de uma vez
     */
    @Override
    public void mostrarDados(){
        System.out.println("Descrição dos Danos: "+getDescrição_danos()); 
        System.out.println("Custo: "+getCusto()); 
        System.out.println("Período Parado (em dias): "+getPeriodo_parado()); 
    }
        
        
    /**
     * @return descrição_danos
     */
    public String getDescrição_danos() {
        return descrição_danos;
    }
    
    /**
     * @return custo
     */
    public float getCusto() {
        return custo;
    }
    
    /**
     * @return periodo_parado
     */
    public long getPeriodo_parado() {
        return periodo_parado;
    }   
    
}
