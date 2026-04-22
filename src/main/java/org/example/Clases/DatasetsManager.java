package org.example.Clases;

import org.example.TDAs.ListaEnlazada;


public class DatasetsManager {
    private static DatasetsManager instancia;
    private ListaEnlazada<Dataset> datasetLista;

    private DatasetsManager(){
        datasetLista = new ListaEnlazada<Dataset>();
    }

    public static DatasetsManager getInstance(){
        if (instancia == null) {
            instancia = new DatasetsManager();
        }
        return instancia;
    }

    public void crearDataset(int id, String name, int size, TipoProblema problemType) {

        Dataset existente = datasetLista.buscar(d -> d.getId() == id);

        if (existente != null) {
            throw new IllegalArgumentException("Ya existe un dataset con ID: " + id);
        }

        Dataset nuevo = new Dataset(id, name, size, problemType);
        datasetLista.agregar(nuevo);
    }


    public Dataset buscarDataset(int id){
        Dataset existente = datasetLista.buscar(d -> d.getId() == id);
        if (existente!= null){
            return existente;
        }
        else{
            throw new IllegalArgumentException("No existe un dataset con ID: " + id);
        }
    }

    public void eliminarDataset(int id){
        Dataset dataset = buscarDataset(id);
        datasetLista.remover(dataset);
    }

    public void listarDatasets(){
        datasetLista.imprimir();
    }
}
