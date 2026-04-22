package org.example.Clases;



public class Dataset {
    private int id;
    private String nombre;
    private int size;
    private TipoProblema tipoProblema;

    public Dataset(int id, String nombre, int size, TipoProblema tipoProblema){
        this.id = id;
        this.nombre = nombre;
        this.size = size;
        this.tipoProblema = tipoProblema;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public TipoProblema getTipoProblema() {
        return tipoProblema;
    }
    public void setTipoProblema(TipoProblema tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dataset dataset = (Dataset) o;
        return id == dataset.id;
    }    

    @Override
    public String toString() {
        return "ID: " + id +" | Nombre: " + nombre +" | Tamaño: " + size +" | Tipo: " + tipoProblema;
    }
}
