package org.example.Clases;


public class Experimento {
    String identificador; 
    Dataset dataset;
    Modelo modelo;
    Estado estado;

    public Experimento(String identificador, Dataset dataset, Modelo modelo, Estado estado){
        this.identificador = identificador;
        this.dataset = dataset;
        this.modelo = modelo;
        this.estado = estado;
    }

    public String getId(){
        return identificador;
    }

    public Dataset getDataset(){
        return dataset;
    }

    public Modelo getModelo(){
        return modelo;
    }

    public Estado getEstado(){
        return estado;
    }

    public Estado changeEstado(){
        if (estado == Estado.ejecutado)
        {
            estado = Estado.pendiente;
            
        }
        else{
            estado = Estado.ejecutado;
        }       
        return estado;
    }
}
