package org.example.Clases;

import org.example.TDAs.ListaEnlazada;


public class DatasetsManager {
    private ListaEnlazada<Dataset> datasetLista;

    public DatasetsManager(){
        datasetLista = new ListaEnlazada<>();
    }

    public void createDataset(int id, String name, int size, TipoProblema problemType) {

        Dataset existente = datasetLista.buscar(d -> d.getId() == id);

        if (existente != null) {
            throw new IllegalArgumentException("Ya existe un dataset con ID: " + id);
        }

        Dataset nuevo = new Dataset(id, name, size, problemType);
        datasetLista.agregar(nuevo);
    }


    public Dataset searchDataset(int id){
        Dataset existente = datasetLista.buscar(d -> d.getId() == id);
        if (existente!= null){
            return existente;
        }
        else{
            throw new IllegalArgumentException("No existe un dataset con ID: " + id);
        }
    }

    public void deleteDataset(int id){
        Dataset dataset = searchDataset(id);
        datasetLista.remover(dataset);
    }

    public void printListAllDatasets(){
        datasetLista.imprimir();
    }
}
