package com.mycompany.gestaotransportes;



/**
 *
 * @author franc
 */

    public class Empresa {
        
    //ATRIBUTOS
    private int NIF;
    private String nome;
    private String  morada;
    
    
    
    //CONSTRUTOR
    public  Empresa(int NIF, String nome, String  morada){
        
        this.NIF = NIF;
        this.nome = nome;
        this.morada = morada;
    }
    public void mostrarDados(){
        System.out.println("NIF: "+getNIF());
        System.out.println("Nome: "+getNome());
        System.out.println("Morada: "+getMorada());
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
    
   }
