package org.example.Clases;

import org.example.TDAs.ListaEnlazada;
import java.util.Objects;


public class ModeloManager{
    private ListaEnlazada<Modelo> modeloLista;
    
    public ModeloManager(){
        modeloLista = new ListaEnlazada<Modelo>();
    }

    public Modelo createModelo(String id, String name, TipoModelo modelType) {
        Modelo existente = modeloLista.buscar(m -> Objects.equals(m.getId(), id));

        if (existente != null) {
            throw new IllegalArgumentException("Ya existe un modelo con ID: " + id);
        }        

        Modelo nuevo = new Modelo(id, name,modelType);
        modeloLista.agregar(nuevo);
        return nuevo;
    }

    public Modelo searchModelo(String id){
        Modelo existente = modeloLista.buscar(m -> Objects.equals(m.getId(), id));
        if (existente!= null){
            return existente;
        }
        else{
            throw new IllegalArgumentException("No existe un modelo con ID: " + id);
        }        
    }

    public void eliminarModelo(String id){
        Modelo modelo = searchModelo(id);
        modeloLista.remover(modelo);
    }

    public ListaEnlazada<Modelo> getModeloList() {
        return modeloLista;
    }

    public void listarModelos(){
        modeloLista.imprimir();
    }
}
