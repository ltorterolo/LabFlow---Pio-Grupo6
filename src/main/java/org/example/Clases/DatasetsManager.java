package org.example.Clases;

import org.example.TDAs.*;

public class DatasetsManager {
    
    private ListaEnlazada<Dataset> datasetList = new ListaEnlazada<Dataset>();

    public boolean CreateDataset(String id, String name, int size, TipoProblema tipoProblema) {
        Nodo<Dataset> actual = datasetList.getHead();
        while (actual != null){
            if (actual.getDato().getId() == id){
            throw new IllegalArgumentException("Ya existe un dataset con ID: " + id);
            }
        }
        datasetList.agregar(new Dataset(id, name, size, tipoProblema));
        return true;
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

    public boolean DeleteDataset(String id){
        Dataset actual = SearchDataset(id);
        if (actual != null){
            datasetList.remover(actual);
            return true;
        }
        return false;
    }

    public boolean PrintListAllDatasets(){
        datasetList.imprimir();
        return true;
    }
}
