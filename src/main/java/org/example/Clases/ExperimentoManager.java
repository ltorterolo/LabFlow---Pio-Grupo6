package org.example.Clases;

<<<<<<< HEAD
public class ExperimentoManager {

=======
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

    public void crearExperimento(int expId,int datasetId,int modeloId){
        Experimento existente = experimentoLista.buscar(e -> e.getId() == expId);
        Dataset dataset = DatasetsManager.getInstance().buscarDataset(datasetId);
        Modelo modelo = ModeloManager.getInstance().buscarModelo(modeloId);

        if (existente != null) {
            throw new IllegalArgumentException("Ya existe un experimento con ID: " + expId);
        }  
        
        Experimento nuevo = new Experimento(expId, dataset, modelo);
        experimentoLista.agregar(nuevo);
    }
>>>>>>> e558b6ddeebad3aa7914f8b225d205228bde631c
}
