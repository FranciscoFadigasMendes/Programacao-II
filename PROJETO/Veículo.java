package com.mycompany.gestaotransportes;
import java.io.Serializable;
import util.Ficheiro;



public class Veiculo implements Serializable {
    
    //ATRIBUTOS
    protected String marca, modelo, matricula, tipo, empresa,avaria,Disponibilidade;
    protected int quilometragem, cilindrada,AnoRegisto,capacidade;
    
    //CONSTRUTOR
        public Veiculo(String marca,String modelo,String matricula,int AnoRegisto,int quilometragem,int cilindrada,String tipo,int capacidade,String empresa,String avaria,String Disponibilidade){
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.AnoRegisto = AnoRegisto;
        this.quilometragem = quilometragem;
        this.cilindrada = cilindrada;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.empresa = empresa;
        this.avaria = avaria;
        this.Disponibilidade = Disponibilidade;
    }
    
    /**
     * Método para mostrar os atributos todos de uma vez
     */
    public void mostrarDados(){
        System.out.println("Marca: "+getMarca());
        System.out.println("Modelo: "+getModelo());
        System.out.println("Matricula: "+getMatricula());
        System.out.println("Ano de Registo: "+getAnoRegisto());
        System.out.println("Quilometragem: "+getQuilometragem());
        System.out.println("Cilindrada: "+getCilindrada());
        System.out.println("Tipo: "+getTipo());
        System.out.println("Capacidade: "+getCapacidade());
        System.out.println("Empresa: "+getEmpresa());
        System.out.println("Avaria: "+getAvaria());
        System.out.println("Disponibilidade: "+getDisponibilidade());
    }

    /**
     * @return marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @return modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @return matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @return empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    

    /**
     * @return quilometragem
     */
    public int getQuilometragem() {
        return quilometragem;
    }


    /**
     * @return cilindrada
     */
    public int getCilindrada() {
        return cilindrada;
    }
    
        /**
     * @return capacidade
     */
    public int getCapacidade() {
        return capacidade;
    }
    
     /**
     * @return anoregisto
     */
    public int getAnoRegisto() {
        return AnoRegisto;
    }
    
    /**
     * @return avaria
     */
    public String getAvaria() {
        return avaria;
    }
    
    /**
     * @param avaria avaria to set
     */
    public void setAvaria(String avaria) {
        this.avaria = avaria;
    }
    
    /**
     * @return Disponibilidade
     */
    public String getDisponibilidade() {
        return Disponibilidade;
    }    
      
    
}
