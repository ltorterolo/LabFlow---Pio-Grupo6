package org.example.Clases;

public class Dataset {
    private String id;
    public String getId() {
        return id;
    }

    private String name;
    public String getName() {
        return name;
    }

    private int size;
    public int getSize() {
        return size;
    }

    private TipoProblema tipoProblema;
    public TipoProblema getTipoProblema() {
        return tipoProblema;
    }
    public Dataset(String id, String name, int size, TipoProblema tipoProblema){
        this.id=id;
        this.name=name;
        this.size=size;
        this.tipoProblema=tipoProblema;
    }
    
}
