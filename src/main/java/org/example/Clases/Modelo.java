package org.example.Clases;



public class Modelo {
    private int id;
    private String name;
    private TipoModelo modelType;
    private String associatedParameters;

    public Modelo(int id, String name, TipoModelo modelType, String associatedParameters){
        this.id = id;
        this.name = name;
        this.modelType = modelType;
        this.associatedParameters = associatedParameters;
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

    public String getAssociatedParameters() {
        return associatedParameters;
    }
    public void setAssociatedParameters(String associatedParameters) {
        this.associatedParameters = associatedParameters;
    }
}
