package org.example.Clases;



public class Dataset {
    private int id;
    private String name;
    private int size;
    private TipoProblema problemType;

    public Dataset(int id, String name, int size, TipoProblema problemType){
        this.id = id;
        this.name = name;
        this.size = size;
        this.problemType = problemType;
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

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public TipoProblema getProblemType() {
        return problemType;
    }
    public void setProblemType(TipoProblema problemType) {
        this.problemType = problemType;
    }
}
