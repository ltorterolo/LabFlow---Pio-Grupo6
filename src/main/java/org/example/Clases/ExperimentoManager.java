package org.example.Clases;

import java.util.Comparator;
import java.util.Objects;

import org.example.TDAs.*;

public class ExperimentoManager {
    private ListaEnlazada<Experimento> experimentosNoEjecutados;
    private ListaEnlazada<Experimento> experimentosEjecutados;

    public ExperimentoManager(){
        experimentosNoEjecutados = new ListaEnlazada<>();
        experimentosEjecutados = new ListaEnlazada<>();
    }

    public void crearExperimento(String Id, Dataset dataset, Modelo modelo){
        Experimento existente = experimentosNoEjecutados.buscar(e -> Objects.equals(e.getId(), Id));

        if (existente != null) {
            throw new IllegalArgumentException("Ya existe un experimento con ID: " + Id);
        }
        existente = experimentosEjecutados.buscar(e -> Objects.equals(e.getId(), Id));
        if (existente != null) {
            throw new IllegalArgumentException("Ya existe un experimento con ID: " + Id);
        }

        Experimento nuevo = new Experimento(Id, dataset, modelo);
        experimentosNoEjecutados.agregar(nuevo);
    }

    public Experimento searchExperimento(String id){
        Experimento existente = experimentosNoEjecutados.buscar(m -> Objects.equals(m.getId(), id));
        if (existente!= null){
            return existente;
        }
        else{
            existente = experimentosEjecutados.buscar(m -> Objects.equals(m.getId(), id));
            if (existente != null){
                return existente;
            }
            throw new IllegalArgumentException("No existe un experimento con ID: " + id);
        }      
    }

    public Experimento searchExperimentoNoEjecutado(String id){
        Experimento existente = experimentosNoEjecutados.buscar(m -> Objects.equals(m.getId(), id));
        if (existente!= null){
            return existente;
        }
        else{
            throw new IllegalArgumentException("No existe un experimento no ejecutado con ID: " + id);
        }
    }

    public ListaEnlazada<Experimento> listarPorModelo(){
        ListaEnlazada<Experimento> todosLosExperimentos = new ListaEnlazada<>();
        todosLosExperimentos.agregarTodos(experimentosNoEjecutados);
        todosLosExperimentos.agregarTodos(experimentosEjecutados);
        Comparator<Experimento> comp = (Comparator.comparing(e -> e.getModelo().getId()));
        todosLosExperimentos = todosLosExperimentos.ordenar(comp);
        todosLosExperimentos.imprimir();
        return todosLosExperimentos;
    }

    public ListaEnlazada<Experimento> listarPorDataset(){
        ListaEnlazada<Experimento> todosLosExperimentos = new ListaEnlazada<>();
        todosLosExperimentos.agregarTodos(experimentosNoEjecutados);
        todosLosExperimentos.agregarTodos(experimentosEjecutados);
        Comparator<Experimento> comp = (Comparator.comparing(e -> e.getDataset().getId()));
        todosLosExperimentos = todosLosExperimentos.ordenar(comp);
        todosLosExperimentos.imprimir();
        return todosLosExperimentos;
    }

    public ListaEnlazada<Experimento> buscarTodosPorModelo(String modeloId){
        ListaEnlazada<Experimento> resultados = new ListaEnlazada<>();
        Nodo<Experimento> actual = experimentosNoEjecutados.getHead();
        while (actual!=null){
            if(actual.dato.getModelo().getId().equals(modeloId)){
                resultados.agregar(actual.dato);
            }
            actual = actual.siguiente;
        }
        actual = experimentosEjecutados.getHead();
        while (actual!=null){
            if(actual.dato.getModelo().getId().equals(modeloId)){
                resultados.agregar(actual.dato);
            }
            actual = actual.siguiente;
        }
        return resultados;
    }

    public ListaEnlazada<Experimento> buscarTodosPorDataset(String datasetId){
        ListaEnlazada<Experimento> resultados = new ListaEnlazada<>();
        Nodo<Experimento> actual = experimentosNoEjecutados.getHead();
        while (actual!=null){
            if(actual.dato.getDataset().getId().equals(datasetId)){
                resultados.agregar(actual.dato);
            }
            actual = actual.siguiente;
        }
        actual = experimentosEjecutados.getHead();
        while (actual!=null){
            if(actual.dato.getDataset().getId().equals(datasetId)){
                resultados.agregar(actual.dato);
            }
            actual = actual.siguiente;
        }
        return resultados;
    }

    public ListaEnlazada<Experimento> buscarExperimentoEjecutadoPorModelo(String modeloId){
        ListaEnlazada<Experimento> resultados = new ListaEnlazada<>();
        Nodo<Experimento> actual = experimentosEjecutados.getHead();
        while (actual!=null){
            if(actual.dato.getModelo().getId().equals(modeloId)){
                resultados.agregar(actual.dato);
            }
            actual = actual.siguiente;
        }
        return resultados;
    }

    public ListaEnlazada<Experimento> buscarExperimentoEjecutadoPorDataset(String datasetId){
        ListaEnlazada<Experimento> resultados = new ListaEnlazada<>();
        Nodo<Experimento> actual = experimentosEjecutados.getHead();
        while (actual!=null){
            if(actual.dato.getDataset().getId().equals(datasetId)){
                resultados.agregar(actual.dato);
            }
            actual = actual.siguiente;
        }
        return resultados;
    }

    public ListaEnlazada<Experimento> buscarExperimentoNoEjecutadoPorDataset(String datasetId){
        ListaEnlazada<Experimento> resultados = new ListaEnlazada<>();
        Nodo<Experimento> actual = experimentosNoEjecutados.getHead();
        while (actual!=null){
            if(actual.dato.getDataset().getId().equals(datasetId)){
                resultados.agregar(actual.dato);
            }
            actual = actual.siguiente;
        }
        return resultados;
    }

    public ListaEnlazada<Experimento> buscarExperimentoNoEjecutadoPorModelo(String modeloId){
        ListaEnlazada<Experimento> resultados = new ListaEnlazada<>();
        Nodo<Experimento> actual = experimentosNoEjecutados.getHead();
        while (actual!=null){
            if(actual.dato.getModelo().getId().equals(modeloId)){
                resultados.agregar(actual.dato);
            }
            actual = actual.siguiente;
        }
        return resultados;
    }

    public ListaEnlazada<Experimento> getExperimentosEjecutados() {
        return experimentosEjecutados;
    }

    public ListaEnlazada<Experimento> getExperimentosNoEjecutados() {
        return experimentosNoEjecutados;
    }

    public void ejecutarExperimento(String experimentoId){
        Experimento experimento = searchExperimentoNoEjecutado(experimentoId);
        if (experimento.ejecutar()) {
            experimentosEjecutados.agregar(experimento);
            experimentosNoEjecutados.remover(experimento);

        }
        else{
            throw new IllegalArgumentException("No se pudo ejecutar el experimento con ID: " + experimentoId);
        }
    }
}

