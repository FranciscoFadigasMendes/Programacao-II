package com.mycompany.gestaotransportes;
import java.io.Serializable;
import util.Ficheiro;

/**
 *
 * @author Francisco Mendes e Francisco Chen
 */
public class ServiçoDeTransporte implements Serializable {

 
    //ATRIBUTOS
    private String LocalOrigem, LocalDestino, DataInicio, DataFim, TipoTransporte,VeiculoAssociado,MotoristaAssociado,EmpresaAssociada; 
    private int Distância,Lotação;
    private float Preço_Quilómetro;
     
     //CONSTRUTOR

    /**
     *
     * @param LocalOrigem
     * @param LocalDestino
     * @param Distância
     * @param DataInicio
     * @param DataFim
     * @param TipoTransporte
     * @param Preço_Quilómetro
     * @param Lotação
     * @param VeiculoAssociado
     * @param MotoristaAssociado
     * @param EmpresaAssociada
     */
    public  ServiçoDeTransporte(String LocalOrigem,String LocalDestino, int Distância, String DataInicio, String DataFim, String TipoTransporte, float Preço_Quilómetro,int Lotação,String VeiculoAssociado,String MotoristaAssociado,String EmpresaAssociada){

        this.LocalOrigem = LocalOrigem;
        this.LocalDestino = LocalDestino;
        this.Distância = Distância;
        this.DataInicio = DataInicio;
        this.DataFim = DataFim;
        this.TipoTransporte = TipoTransporte;
        this.Preço_Quilómetro = Preço_Quilómetro;
        this.Lotação = Lotação; 
        this.VeiculoAssociado = VeiculoAssociado;
        this.MotoristaAssociado = MotoristaAssociado;
        this.EmpresaAssociada = EmpresaAssociada;
    }
    
    /**
     * Método para mostrar os atributos todos de uma vez
     */
    public void mostrarDados(){
        System.out.println("Local de Origem: "+getLocalOrigem());
        System.out.println("Local de Destino: "+getLocalDestino());
        System.out.println("Distância: "+getDistância());
        System.out.println("Data de Inicio: "+getDataInicio());
        System.out.println("Data de Fim: "+getDataFim());
        System.out.println("Tipo de Transporte: "+getTipoTransporte());
        System.out.println("Preço por Quilómetro: "+getPreço_Quilómetro());
        System.out.println("Lotação: "+getLotação());
        System.out.println("Veiculo Associado: "+getVeiculoAssociado());
        System.out.println("Motorista Associado: "+getMotoristaAssociado());
        System.out.println("Empresa Associada: "+getEmpresaAssociada());
    }
    
/**
     * @return LocalOrigem
     */
    public String getLocalOrigem() {
        return LocalOrigem;
    }

    /**
     * @return LocalDestino
     */
    public String getLocalDestino() {
        return LocalDestino;
    }

    /**
     * @return Distância
     */
    public int getDistância() {
        return Distância;
    }

    /**
     * @return DataInicio
     */
    public String getDataInicio() {
        return DataInicio;
    }

    /**
     * @return DataFim
     */
    public String getDataFim() {
        return DataFim;
    }

    /**
     * @return TipoTransporte
     */
    public String getTipoTransporte() {
        return TipoTransporte;
    }


    /**
     * @return Preço_Quilómetro
     */
    public float getPreço_Quilómetro() {
        return Preço_Quilómetro;
    }
    
        /**
     * @return Lotação
     */
    public int getLotação() {
        return Lotação;
    }
    
     /**
     * @return Veiculo Associado
     */
    public String getVeiculoAssociado() {
        return VeiculoAssociado;
    }
    
     /**
     * @return Motorista Associado
     */
    public String getMotoristaAssociado() {
        return MotoristaAssociado;
    }

    /**
     * @return the EmpresaAssociada
     */
    public String getEmpresaAssociada() {
        return EmpresaAssociada;
    }
    
 
}    
    
 
