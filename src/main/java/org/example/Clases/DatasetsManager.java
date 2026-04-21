package org.example.Clases;

import org.example.TDAs.ListaEnlazada;


public class DatasetsManager {
    private ListaEnlazada<Dataset> datasetLista;

    public DatasetsManager(){
        datasetLista = new ListaEnlazada<>();
    }

    public void CreateDataset(int id, String name, int size, TipoProblema problemType) {

        Dataset existente = datasetLista.buscar(d -> d.getId() == id);

    if (existente != null) {
        throw new IllegalArgumentException("Ya existe un dataset con ID: " + id);
    }

        Dataset nuevo = new Dataset(id, name, size, problemType);
        datasetLista.agregar(nuevo);
    }


    public Dataset SearchDataset(int id){
        Dataset existente = datasetLista.buscar(d -> d.getId() == id);
        if (existente!= null){
            return existente;
        }
        else{
            throw new IllegalArgumentException("No existe un dataset con ID: " + id);
        }
    }

    public void DeleteDataset(int id){
        Dataset dataset = datasetLista.buscar(d -> d.getId() == id);

        if (dataset == null) {
        throw new IllegalArgumentException("No existe dataset con ID: " + id);
        }

        datasetLista.remover(dataset);
    }

    public void PrintListAllDatasets(){
        datasetLista.imprimir();
    }
}
