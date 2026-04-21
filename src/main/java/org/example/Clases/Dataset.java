package org.example.Clases;



public class Dataset {
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

    private int size;
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    private String problemType;
    public String getProblemType() {
        return problemType;
    }
    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }
}
