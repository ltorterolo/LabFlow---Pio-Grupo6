package org.example.Clases;

import org.example.TDAs.*;


public class DatasetsManager {
    private ListaEnlazada<Dataset> datasetList = new ListaEnlazada<Dataset>();

    public void createDataset(String id, String name, int size, TipoProblema problemType) {

        Dataset existente = datasetList.buscar(d -> d.getId() == id);
        if (existente != null) {
            throw new IllegalArgumentException("Ya existe un dataset con ID: " + id);
        }

        Dataset nuevo = new Dataset(id, name, size, problemType);
        datasetList.agregar(nuevo);
    }
    
    public Dataset SearchDataset(String id){
        Nodo<Dataset> actual = datasetList.getHead();
        while (actual != null) {
            if (actual.getDato().getId() == id){
                return actual.getDato();
            }
        }
        System.out.println("No se encontró un dataset con Id = " + id);
        return null;
    }

    public void eliminarDataset(String id){
        Dataset dataset = SearchDataset(id);
        datasetList.remover(dataset);
    }

    public void listarDatasets(){
        datasetList.imprimir();
    }
}
