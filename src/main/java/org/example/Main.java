package org.example;

import org.example.Clases.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ExperimentoManager experimentos = new ExperimentoManager();
        DatasetsManager datasets = new DatasetsManager();
        ModeloManager modelos = new ModeloManager();
        
        datasets.CreateDataset("123", "Dataset1", 13, TipoProblema.CLASIFICACION);
        modelos.createModel("abc", "Modelo Básico", TipoModelo.RED_NEURONAL);
        
        Modelo m1 = modelos.searchModel("abc");
        Dataset d1 = datasets.SearchDataset("123");

        experimentos.crearExperimento("abc-123", d1, m1);
        Experimento e1 = experimentos.searchExperimento("abc-123");
        e1.ejecutar();

    }
}


    
