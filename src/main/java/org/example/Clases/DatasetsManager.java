package org.example.Clases;

import org.example.TDAs.*;

import java.util.Objects;


public class DatasetsManager {
    private ListaEnlazada<Dataset> datasetList;

    public DatasetsManager() {
        this.datasetList = new ListaEnlazada<>();
    }

    public void createDataset(String id, String name, int size, TipoProblema problemType) {

        Dataset existente = datasetList.buscar(d -> Objects.equals(d.getId(), id));
        if (existente != null) {
            throw new IllegalArgumentException("Ya existe un dataset con ID: " + id);
        }

        Dataset nuevo = new Dataset(id, name, size, problemType);
        datasetList.agregar(nuevo);
    }
    
    public Dataset SearchDataset(String id){
        Nodo<Dataset> actual = datasetList.getHead();

        while (actual != null) {
            if (Objects.equals(actual.getDato().getId(), id)){
                return actual.getDato();
            }
            actual = actual.siguiente;
        }
        throw new IllegalArgumentException("No existe un dataset con ID: " + id);
    }

    public void eliminarDataset(String id){
        Dataset dataset = SearchDataset(id);
        datasetList.remover(dataset);
    }

    public ListaEnlazada<Dataset> getDatasetList() {
        return datasetList;
    }

    public void listarDatasets(){
        datasetList.imprimir();
    }
}
