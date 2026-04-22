package org.example.Clases;
import org.example.TDAs.ListaEnlazada;


public class Modelo {
    private int id;
    private String name;
    private TipoModelo modelType;
    private ListaEnlazada<String> associatedParameters;

    public Modelo(int id, String name, TipoModelo modelType ){
        this.id = id;
        this.name = name;
        this.modelType = modelType;
        this.associatedParameters = new ListaEnlazada<String>();
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public TipoModelo getModelType() {
        return modelType;
    }
    public void setModelType(TipoModelo modelType) {
        this.modelType = modelType;
    }

    public ListaEnlazada<String> getAssociatedParameters() {
        return associatedParameters;
    }
    public void addAssociatedParameter(String associatedParameter) {
        this.associatedParameters.agregar(associatedParameter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Modelo modelo = (Modelo) o;
        return id == modelo.id;
    }    

    @Override
    public String toString() {
        return "ID: " + id +" | Nombre: " + name +" | Tipo: " + modelType +" | Parametros: " + associatedParameters;
    }

}
