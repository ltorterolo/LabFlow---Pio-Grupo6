package org.example.Clases;

import java.util.Comparator;

import org.example.TDAs.*;

public class ExperimentoManager {
    private ListaEnlazada<Experimento> experimentoLista;

    public ExperimentoManager(){
        experimentoLista = new ListaEnlazada<Experimento>();
    }

    public void crearExperimento(String Id, Dataset dataset, Modelo modelo){
        Experimento existente = experimentoLista.buscar(e -> e.getId() == Id);
        
        if (existente != null) {
            throw new IllegalArgumentException("Ya existe un experimento con ID: " + Id);
        }  
        
        Experimento nuevo = new Experimento(Id, dataset, modelo);
        experimentoLista.agregar(nuevo);
    }

    public Experimento searchExperimento(String id){
        Experimento existente = experimentoLista.buscar(m -> m.getId() == id);
        if (existente!= null){
            return existente;
        }
        else{
            throw new IllegalArgumentException("No existe un experimento con ID: " + id);
        }      
    }

    public void listarPorModelo(){
        Comparator<Experimento> comp = ((e1, e2) -> e1.getModelo().getId().compareTo(e2.getModelo().getId()));
        experimentoLista = experimentoLista.ordenar(comp);
        experimentoLista.imprimir();
    }

    public void listarPorDataset(){
        Comparator<Experimento> comp = ((e1, e2) -> e1.getDataset().getId().compareTo(e2.getDataset().getId()));
        experimentoLista = experimentoLista.ordenar(comp);
        experimentoLista.imprimir();
    }
}
