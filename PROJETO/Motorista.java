package com.mycompany.gestaotransportes;

import java.io.Serializable;
import util.Ficheiro;

/**
 *
 * @author Francisco Mendes e Francisco Chen
 */
public class Motorista implements Serializable {
    
    //ATRIBUTOS
    private int NIF, Telefone;
    private String Nome, Morada, Data, Empresa, Habilitação,Disponibilidade;

    //CONSTRUTOR

    /**
     *
     * @param NIF
     * @param Nome
     * @param Morada
     * @param Telefone
     * @param Habilitação
     * @param Empresa
     * @param Data
     * @param Disponibilidade
     */
    public  Motorista(int NIF, String Nome, String  Morada, int Telefone, String Habilitação, String Empresa, String Data,String Disponibilidade){

        this.NIF = NIF;
        this.Nome = Nome;
        this.Morada = Morada;
        this.Telefone = Telefone;
        this.Habilitação = Habilitação;
        this.Empresa = Empresa;
        this.Data = Data;
        this.Disponibilidade = Disponibilidade;
    }

    /**
     * Método para mostrar os atributos todos de uma vez
     */
    public void mostrarDados(){
        System.out.println("NIF: "+getNIF());
        System.out.println("Nome: "+getNome());
        System.out.println("Morada: "+getMorada());
        System.out.println("Empresa: "+getEmpresa());
        System.out.println("Telefone: "+getTelefone());
        System.out.println("Habilitação: "+getHabilitação());
        System.out.println("Data: "+getData());
        System.out.println("Disponibilidade: "+getDisponibilidade());
    }
    
    
    /**
     * @return NIF
     */
    public int getNIF() {
        return NIF;
    }

    /**
     * @return Telefone
     */
    public int getTelefone() {
        return Telefone;
    }

    /**
     * @return Habilitação
     */
    public String getHabilitação() {
        return Habilitação;
    }

    /**
     * @return Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @return Morada
     */
    public String getMorada() {
        return Morada;
    }

    /**
     * @return Data
     */
    public String getData() {
        return Data;
    }

    /**
     * @return Empresa
     */
    public String getEmpresa() {
        return Empresa;
    }
    
    /**
     * @return Disponibilidade
     */
    public String getDisponibilidade() {
        return Disponibilidade;
    }
    
}
