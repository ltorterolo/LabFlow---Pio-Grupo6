package org.example.Clases;
import javax.lang.model.util.SimpleAnnotationValueVisitorPreview;

import org.example.TDAs.ListaEnlazada;


public class ModeloManager{
    private ListaEnlazada<Modelo> modeloLista;
    
    public ModeloManager(){
        modeloLista = new ListaEnlazada<Modelo>();
    }

    public void createModelo(String id, String name, TipoModelo modelType) {
        Modelo existente = modeloLista.buscar(m -> m.getId() == id);

        if (existente != null) {
            throw new IllegalArgumentException("Ya existe un modelo con ID: " + id);
        }        

        Modelo nuevo = new Modelo(id, name,modelType);
        modeloLista.agregar(nuevo);
    }

    public Modelo searchModelo(String id){
        Modelo existente = modeloLista.buscar(m -> m.getId() == id);
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

    public void listarModelos(){
        modeloLista.imprimir();
    }
}
