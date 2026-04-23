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
        Dataset existente = datasetList.buscar(m -> m.getId() == id);
        if (existente!= null){
            return existente;
        }
        else{
            throw new IllegalArgumentException("No existe un dataset con ID: " + id);
        }      
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
