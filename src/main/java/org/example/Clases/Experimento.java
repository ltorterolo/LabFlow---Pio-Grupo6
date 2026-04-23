package org.example.Clases;

import java.util.random.*;

public class Experimento {
    private String identificador; 
    private Dataset dataset;
    private Modelo modelo;
    private Estado estado;

    private int accuracy;
    private int precision;
    private int timeSpent;
    private int eficiencia;


    public Experimento(String identificador, Dataset dataset, Modelo modelo){
        this.identificador = identificador;
        this.dataset = dataset;
        this.modelo = modelo;
        this.estado = Estado.PENDIENTE;
    }

    public String getId(){
        return identificador;
    }
    public void setId(String id){
        this.identificador = id;
    }

    public Dataset getDataset(){
        return dataset;
    }
    public void setDataset(Dataset dataset){
        this.dataset = dataset;
    }

    public Modelo getModelo(){
        return modelo;
    }
    public void setModelo(Modelo modelo){
        this.modelo = modelo;
    }

    public Estado getEstado(){
        return estado;
    }

    public int getAcuraccy(){
        return this.accuracy;
    }

    public int getPrecision(){
        return this.precision;
    }

    public int getTimeSpent(){
        return this.timeSpent;
    }

    public int getEficiencia(){
        return this.eficiencia;
    }

    public int randomInt(int min, int max){
            return (int)(Math.random() * (max - min + 1)) + min;
    }

    public boolean ejecutar(){
        if (estado == Estado.PENDIENTE)
        {
            estado = Estado.EJECUTADO;
            this.accuracy = randomInt(1, 100);
            this.precision = randomInt(1, 100);
            this.timeSpent = randomInt(1, 10);
            this.eficiencia = accuracy*precision/timeSpent;
            ImpresoraHistorial.imprimir("Experimento - ID: " + identificador + ", eficiencia: " + eficiencia);
            return true;
        }
        else{
            throw new IllegalArgumentException("Este experimento ya fue ejecutado");
        }
    }
}
