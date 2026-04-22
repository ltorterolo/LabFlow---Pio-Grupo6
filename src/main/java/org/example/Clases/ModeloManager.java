package org.example.Clases;
import org.example.TDAs.ListaEnlazada;


public class ModeloManager{
    private static ModeloManager instancia;
    private ListaEnlazada<Modelo> modeloLista;
    
    private ModeloManager(){
        modeloLista = new ListaEnlazada<Modelo>();
    }

    public static ModeloManager getInstance(){
        if (instancia == null) {
            instancia = new ModeloManager();
        }
        return instancia;
    }    

    public void createModel(int id, String name, TipoModelo modelType) {
        Modelo existente = modeloLista.buscar(m -> m.getId() == id);

        if (existente != null) {
            throw new IllegalArgumentException("Ya existe un modelo con ID: " + id);
        }        

        Modelo nuevo = new Modelo(id, name,modelType);
        modeloLista.agregar(nuevo);
    }

    public Modelo searchModel(int id){
        Modelo existente = modeloLista.buscar(m -> m.getId() == id);
        if (existente!= null){
            return existente;
        }
        else{
            throw new IllegalArgumentException("No existe un modelo con ID: " + id);
        }        
    }

    public void addAssociatedParameter(String associatedParameter, int id) {
        Modelo modelo = searchModel(id);
        modelo.addAssociatedParameter(associatedParameter);
    }


    public void deleteModel(int id){
        Modelo modelo = searchModel(id);
        modeloLista.remover(modelo);
    }

    public void printListAllModels(){
        modeloLista.imprimir();
    }
}
