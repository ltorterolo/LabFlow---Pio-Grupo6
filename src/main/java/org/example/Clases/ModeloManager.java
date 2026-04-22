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

    public void crearModelo(int id, String name, TipoModelo modelType) {
        Modelo existente = modeloLista.buscar(m -> m.getId() == id);

        if (existente != null) {
            throw new IllegalArgumentException("Ya existe un modelo con ID: " + id);
        }        

        Modelo nuevo = new Modelo(id, name,modelType);
        modeloLista.agregar(nuevo);
    }

    public Modelo buscarModelo(int id){
        Modelo existente = modeloLista.buscar(m -> m.getId() == id);
        if (existente!= null){
            return existente;
        }
        else{
            throw new IllegalArgumentException("No existe un modelo con ID: " + id);
        }        
    }

    public void agregarParametrosAsociados(String associatedParameter, int id) {
        Modelo modelo = buscarModelo(id);
        modelo.addParametrosAsociados(associatedParameter);
    }


    public void eliminarModelo(int id){
        Modelo modelo = buscarModelo(id);
        modeloLista.remover(modelo);
    }

    public void listarModelos(){
        modeloLista.imprimir();
    }
}
