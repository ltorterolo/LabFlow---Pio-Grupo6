package org.example.Clases;
import org.example.TDAs.ListaEnlazada;


public class ModeloManager{
    private ListaEnlazada<Modelo> modeloLista;
    
    public ModeloManager(){
        modeloLista = new ListaEnlazada<Modelo>();
    }

    public void createModel(String id, String name, TipoModelo modelType) {
        Modelo existente = modeloLista.buscar(m -> m.getId() == id);

        if (existente != null) {
            throw new IllegalArgumentException("Ya existe un modelo con ID: " + id);
        }        

        Modelo nuevo = new Modelo(id, name, modelType);
        modeloLista.agregar(nuevo);
    }

    public Modelo searchModel(String id){
        Modelo existente = modeloLista.buscar(m -> m.getId() == id);
        if (existente!= null){
            return existente;
        }
        else{
            throw new IllegalArgumentException("No existe un modelo con ID: " + id);
        }        
    }

    public void addAssociatedParameter(String associatedParameter, String id) {
        Modelo modelo = searchModel(id);
        modelo.agregarParametro(associatedParameter);
    }


    public void deleteModel(String id){
        Modelo modelo = searchModel(id);
        modeloLista.remover(modelo);
    }

    public void printListAllModels(){
        modeloLista.imprimir();
    }
}
