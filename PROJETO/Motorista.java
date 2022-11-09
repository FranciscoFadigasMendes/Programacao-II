package com.mycompany.gestaotransportes;

public class Motorista {
    
    //ATRIBUTOS
    private int NIF, Telefone;
    private String Nome, Morada, Data, Empresa, Habilitação;

    //CONSTRUTOR
    public  Motorista(int NIF, String Nome, String  Morada, int Telefone, String Habilitação, String Empresa, String Data){

        this.NIF = NIF;
        this.Nome = Nome;
        this.Morada = Morada;
        this.Telefone = Telefone;
        this.Habilitação = Habilitação;
        this.Empresa = Empresa;
        this.Data = Data;
    }

    /**
     * @return the NIF
     */
    public int getNIF() {
        return NIF;
    }

    /**
     * @return the Telefone
     */
    public int getTelefone() {
        return Telefone;
    }

    /**
     * @return the Habilitação
     */
    public String getHabilitação() {
        return Habilitação;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @return the Morada
     */
    public String getMorada() {
        return Morada;
    }

    /**
     * @return the Data
     */
    public String getData() {
        return Data;
    }

    /**
     * @return the Empresa
     */
    public String getEmpresa() {
        return Empresa;
    }
    
}
