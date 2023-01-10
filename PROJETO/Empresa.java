package com.mycompany.gestaotransportes;
import java.io.Serializable;
import util.Ficheiro;

/**
 *
 * @author Francisco Mendes e Francisco Chen
 */
public class Empresa implements Serializable {
        
    //ATRIBUTOS
    private int NIF,Job_Counter;
    private String nome,morada;
//    private float fatura;
    
    
    
    //CONSTRUTOR

    /**
     *
     * @param NIF
     * @param nome
     * @param morada
     * @param Job_Counter
     */
    public  Empresa(int NIF, String nome, String  morada, int Job_Counter){
        
        this.NIF = NIF;
        this.nome = nome;
        this.morada = morada;
//        this.fatura = fatura;
        this.Job_Counter = Job_Counter;
    }
    
    /**
     * Método para mostrar os atributos todos de uma vez
     */
    public void mostrarDados(){
        System.out.println("NIF: "+getNIF());
        System.out.println("Nome: "+getNome());
        System.out.println("Morada: "+getMorada());
        System.out.println("Contador de Serviços: "+getJob_Counter());

    }
    

    /**
     * @return the NIF
     */
    public int getNIF() {
        return NIF;
    }

    /**
     * @param NIF the NIF to set
     */
    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the morada
     */
    public String getMorada() {
        return morada;
    }

    /**
     * @param morada the morada to set
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

//    /**
//     * @return the fatura
//     */
//    public float getFatura() {
//        return fatura;
//    }Job_Counter
    
    /**
     * @return Job_Counter
     */
    public int getJob_Counter() {
        return Job_Counter;
    }
    
    /**
     * @param Job_Counter 
     */
    public void Job_Counter(int Job_Counter) {
        this.Job_Counter = Job_Counter;
    }    
    
    
    
   }

