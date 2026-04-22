package org.example.Clases;

public class Experimento {
    private int id;
    private Dataset dataset;
    private Modelo modelo;
    private Estado estado;
    
    public Experimento(int id, Dataset dataset, Modelo modelo, Estado estado){
        this.id = id;
        this.dataset = dataset;
        this.modelo = modelo;
        this.estado = estado;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
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
    public void setDataset(Estado estado){
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Experimento experimento = (Experimento) o;
        return id == experimento.id;
    }
    
    @Override
    public String toString() {
        return "ID: " + id +" | DatasetId: " + dataset.getId() +" | ModeloId: " + modelo.getId() +" | Estado: " + estado;
    }    
}
