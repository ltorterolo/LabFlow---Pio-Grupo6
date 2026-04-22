package org.example.Clases;

import javax.lang.model.util.SimpleAnnotationValueVisitorPreview;

import org.example.TDAs.ListaEnlazada;

public class ExperimentoManager {
    private static ExperimentoManager instancia;
    private ListaEnlazada<Experimento> experimentoLista;

    private ExperimentoManager(){
        experimentoLista = new ListaEnlazada<Experimento>();
    }

    public static ExperimentoManager getInstance(){
        if (instancia == null) {
            instancia = new ExperimentoManager();
        }
        return instancia;
    }

    public void crearExperimento(String Id, Dataset dataset, Modelo modelo){
        Experimento existente = experimentoLista.buscar(e -> e.getId() == Id);
        
        if (existente != null) {
            throw new IllegalArgumentException("Ya existe un experimento con ID: " + Id);
        }  
        
        Experimento nuevo = new Experimento(Id, dataset, modelo, Estado.pendiente);
        experimentoLista.agregar(nuevo);
    }
}
