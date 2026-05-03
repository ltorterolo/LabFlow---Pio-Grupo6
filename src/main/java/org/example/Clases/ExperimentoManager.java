package org.example.Clases;

import java.util.Comparator;
import java.util.Objects;

import org.example.TDAs.*;

public class ExperimentoManager {
    private ListaEnlazada<Experimento> experimentoLista;

    public ExperimentoManager(){
        experimentoLista = new ListaEnlazada<Experimento>();
    }

    public void crearExperimento(String Id, Dataset dataset, Modelo modelo){
        Experimento existente = experimentoLista.buscar(e -> Objects.equals(e.getId(), Id));
        
        if (existente != null) {
            throw new IllegalArgumentException("Ya existe un experimento con ID: " + Id);
        }  
        
        Experimento nuevo = new Experimento(Id, dataset, modelo);
        experimentoLista.agregar(nuevo);
    }

    public Experimento searchExperimento(String id){
        Experimento existente = experimentoLista.buscar(m -> Objects.equals(m.getId(), id));
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

    public ListaEnlazada<Experimento> buscarExperimentoEjecutadoPorModelo(String modeloId){
        ListaEnlazada<Experimento> resultados = new ListaEnlazada<>();
        Nodo<Experimento> actual = experimentoLista.getHead();
        while (actual!=null){
            if(actual.dato.getModelo().getId().equals(modeloId) && actual.dato.getEstado() == Estado.EJECUTADO){
                resultados.agregar(actual.dato);
            }
            actual = actual.siguiente;
        }
        return resultados;
    }

    public ListaEnlazada<Experimento> buscarExperimentoEjecutadoPorDataset(String datasetId){
        ListaEnlazada<Experimento> resultados = new ListaEnlazada<>();
        Nodo<Experimento> actual = experimentoLista.getHead();
        while (actual!=null){
            if(actual.dato.getDataset().getId().equals(datasetId) && actual.dato.getEstado() == Estado.EJECUTADO){
                resultados.agregar(actual.dato);
            }
            actual = actual.siguiente;
        }
        return resultados;
    }
}

