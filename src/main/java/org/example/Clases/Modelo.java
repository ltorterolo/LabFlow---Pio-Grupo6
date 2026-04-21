public class Modelo {
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private String modelType;
    public String getModelType() {
        return modelType;
    }
    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    private String associatedParameters;
    public String getAssociatedParameters() {
        return associatedParameters;
    }
    public void setAssociatedParameters(String associatedParameters) {
        this.associatedParameters = associatedParameters;
    }
}
