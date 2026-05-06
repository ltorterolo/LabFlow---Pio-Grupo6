package org.example.Clases;

import java.util.Scanner;

import org.example.TDAs.ListaEnlazada;

public class Consola {
        private ExperimentoManager experimentoManager;
        private DatasetsManager datasetsManager;
        private ModeloManager modeloManager;
        private Scanner scanner;

    public Consola(){
        this.experimentoManager = new ExperimentoManager();
        this.datasetsManager = new DatasetsManager();
        this.modeloManager = new ModeloManager();
        this.scanner = new Scanner(System.in);
    };
    public Consola(ExperimentoManager experimentoManager, DatasetsManager datasetsManager, ModeloManager modeloManager, Scanner scanner){
        this.datasetsManager = datasetsManager;
        this.experimentoManager = experimentoManager;
        this.modeloManager = modeloManager;
        this.scanner = scanner;
    }

    public void recibirDato(){
        String imprimir = """
            Seleccione una opción: \n
            1. Crear Dataset \n
            2. Crear Modelo \n
            3. Listar Datasets \n
            4. Listar Modelos \n
            5. Crear Experimento \n
            6. Ejecutar Experimento \n
            7. Buscar todos los experimentos por Modelo \n
            8. Buscar todos los experimentos por Dataset \n
            9. Ordenar Experimentos por Modelo \n
            10. Ordenar Experimentos por Dataset \n
            11. Buscar Experimentos ejecutados por Modelo \n
            12. Buscar Experimento ejecutados por Dataset \n
            13. Eliminar modelo \n
            14. Eliminar dataset \n
            0. Salir \n
            """;
            System.out.println(imprimir);

            System.out.print("\nIngrese su opción: ");
            int opcion = scanner.nextInt();
            switchCases(opcion);
    }

    public void switchCases(int opcion){
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese ID del Dataset:");
                    String datasetId = scanner.next();
                    System.out.println("Ingrese nombre del Dataset:");
                    String datasetName = scanner.next();
                    System.out.println("Ingrese tamaño del Dataset:");
                    int datasetSize = scanner.nextInt();
                    System.out.println("Seleccione tipo de problema:");
                    System.out.println("1. Clasificación");
                    System.out.println("2. Regresión");
                    System.out.println("3. Clustering");
                    System.out.print("\nIngrese su opción: ");
                    int tipoProblemaOption = scanner.nextInt();
                    TipoProblema tipoProblema;
                    if (tipoProblemaOption == 1) {
                        tipoProblema = TipoProblema.CLASIFICACION;
                    } else if (tipoProblemaOption == 2) {
                        tipoProblema = TipoProblema.REGRESION;
                    } else if (tipoProblemaOption == 3) {
                        tipoProblema = TipoProblema.CLUSTERING;
                    } else {
                        System.out.println("Opción no válida, se asignará Clasificación por defecto.");
                        tipoProblema = TipoProblema.CLASIFICACION;
                    }

                    try {
                        datasetsManager.createDataset(datasetId, datasetName, datasetSize, tipoProblema);
                        System.out.println("Dataset creado exitosamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    if(opcion != 0){
                        recibirDato();
                    }
                    break;
                case 2:
                    System.out.println("Ingrese ID del Modelo:");
                    String modeloId = scanner.next();
                    System.out.println("Ingrese nombre del Modelo:");
                    String modeloName = scanner.next();
                    System.out.println("Seleccione tipo de modelo:");
                    System.out.println("1. Random forest");
                    System.out.println("2. Red Neuronal");
                    System.out.println("3. SVM");
                    System.out.println("4. KNN");
                    System.out.println("5. Regresión lineal");
                    System.out.print("\nIngrese su opción: ");
                    int tipoModeloOption = scanner.nextInt();
                    TipoModelo tipoModelo;
                    if (tipoModeloOption == 1) {
                        tipoModelo = TipoModelo.RANDOM_FOREST;
                    } else if (tipoModeloOption == 2) {
                        tipoModelo = TipoModelo.RED_NEURONAL;
                    } else if (tipoModeloOption == 3) {
                        tipoModelo = TipoModelo.SVM;
                    } else if (tipoModeloOption == 4) {
                        tipoModelo = TipoModelo.KNN;
                    } else if (tipoModeloOption == 5) {
                        tipoModelo = TipoModelo.REGRESION_LINEAL;
                    } else {
                        System.out.println("Opción no válida, se asignará Red Neuronal por defecto.");
                        tipoModelo = TipoModelo.RED_NEURONAL;
                    }


                    try {
                        Modelo modelo = modeloManager.createModelo(modeloId, modeloName, tipoModelo);
                        System.out.println("Modelo creado exitosamente.");
                        System.out.print("Ingrese cantidad de parametros a añadir (0 en caso de no añadir parametros): ");
                        int cantidadParametros = scanner.nextInt();
                        for (int i = 0; i < cantidadParametros; i++) {
                            System.out.println("Ingrese valor del parámetro " + (i + 1) + ":");
                            String paramValue = scanner.next();
                            modelo.agregarParametro(paramValue);
                            System.out.println("Parámetro agregado: " + paramValue);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    if(opcion != 0){
                        recibirDato();
                    }
                    break;
                case 3:
                    if (datasetsManager.getDatasetList().tamaño() == 0) {
                        System.out.println("No hay datasets disponibles. Por favor, cree un dataset primero.");
                        if(opcion != 0){
                            recibirDato();
                        }
                        break;
                    }
                    System.out.println("Datasets disponibles:");
                    datasetsManager.listarDatasets();
                    if(opcion != 0){
                        recibirDato();
                    }
                    break;
                case 4:
                    if (modeloManager.getModeloList().tamaño() == 0) {
                        System.out.println("No hay modelos disponibles. Por favor, cree un modelo primero.");
                        if(opcion != 0){
                            recibirDato();
                        }
                     break;
                    }
                    System.out.println("Modelos disponibles:");
                    modeloManager.listarModelos();
                    if(opcion != 0){
                        recibirDato();
                    }
                    break;
                case 5:
                    if (datasetsManager.getDatasetList().tamaño() == 0) {
                        System.out.println("No hay datasets disponibles. Por favor, cree un dataset primero.");
                        if(opcion != 0){
                            recibirDato();
                        }
                     break;
                    }
                    if (modeloManager.getModeloList().tamaño() == 0) {
                        System.out.println("No hay modelos disponibles. Por favor, cree un modelo primero.");
                        if(opcion != 0){
                            recibirDato();
                        }
                        break;
                    }
                    System.out.println("Para crear un experimento, primero debe seleccionar un dataset y un modelo.");
                    System.out.println("Datasets disponibles:");
                    datasetsManager.listarDatasets();
                    System.out.println("Modelos disponibles:");
                    modeloManager.listarModelos();
                    System.out.println("\nIngrese ID del Dataset para el experimento:");
                    String expDatasetId = scanner.next();

                    System.out.println("Ingrese ID del Modelo para el experimento:");
                    String expModeloId = scanner.next();

                    String experimentoId = expModeloId + "-" + expDatasetId;
                    try {
                        experimentoManager.crearExperimento(experimentoId, datasetsManager.SearchDataset(expDatasetId), modeloManager.searchModelo(expModeloId));
                        System.out.println("Experimento creado exitosamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    if(opcion != 0){
                        recibirDato();
                    }
                    break;
                case 6:
                    if(experimentoManager.getExperimentosNoEjecutados().tamaño() == 0){
                        System.out.println("No hay experimentos no ejecutados disponibles. Por favor, cree un experimento primero.");
                        if(opcion != 0){
                            recibirDato();
                        }
                     break;
                    }
                    System.out.println("Experimentos no ejecutados disponibles:");
                    experimentoManager.getExperimentosNoEjecutados().imprimir();
                    System.out.print("\nIngrese ID del Experimento a ejecutar: ");
                    String expIdToExecute = scanner.next();
                    try {
                        experimentoManager.ejecutarExperimento(expIdToExecute);

                        System.out.println("Experimento ejecutado exitosamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    if(opcion != 0){
                        recibirDato();
                    }
                    break;
                case 7:
                    if (modeloManager.getModeloList().tamaño() == 0) {
                        System.out.println("No hay modelos disponibles. Por favor, cree un modelo primero.");
                        if(opcion != 0){
                            recibirDato();
                        }
                     break;
                    }
                    System.out.println("Modelos disponibles:");
                    modeloManager.listarModelos();
                    System.out.println("Ingrese ID del Modelo para buscar sus experimentos:");
                    String modeloIdForSearch = scanner.next();
                    try {
                        ListaEnlazada<Experimento> experimentosPorModelo = experimentoManager.buscarTodosPorModelo(modeloIdForSearch);
                        if (experimentosPorModelo.tamaño() == 0) {
                            System.out.println("No hay experimentos para el modelo con ID: " + modeloIdForSearch);
                        } else {
                            System.out.println("Experimentos para el modelo con ID: " + modeloIdForSearch);
                            experimentosPorModelo.imprimir();
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    if(opcion != 0){
                        recibirDato();
                    }
                    break;
                case 8:
                    if (datasetsManager.getDatasetList().tamaño() == 0) {
                        System.out.println("No hay datasets disponibles. Por favor, cree un dataset primero.");
                        if(opcion != 0){
                            recibirDato();
                        }
                     break;
                    }
                    System.out.println("Datasets disponibles:");
                    datasetsManager.listarDatasets();
                    System.out.println("Ingrese ID del Dataset para buscar sus experimentos:");
                    String datasetIdForSearch = scanner.next();
                    try {
                        ListaEnlazada<Experimento> experimentosPorDataset = experimentoManager.buscarTodosPorDataset(datasetIdForSearch);
                        if (experimentosPorDataset.tamaño() == 0) {
                            System.out.println("No hay experimentos para el dataset con ID: " + datasetIdForSearch);
                        } else {
                            System.out.println("Experimentos para el dataset con ID: " + datasetIdForSearch);
                            experimentosPorDataset.imprimir();
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    if(opcion != 0){
                        recibirDato();
                    }
                    break;
                case 9:
                    System.out.println("Experimentos ordenados por Modelo:");
                    experimentoManager.listarPorModelo();
                    if(opcion != 0){
                        recibirDato();
                    }
                    break;
                case 10:
                    System.out.println("Experimentos ordenados por Dataset:");
                    experimentoManager.listarPorDataset();
                    if(opcion != 0){
                        recibirDato();
                    }
                    break;
                case 11:
                    if (modeloManager.getModeloList().tamaño() == 0) {
                        System.out.println("No hay modelos disponibles. Por favor, cree un modelo primero.");
                        if(opcion != 0){
                            recibirDato();
                        }
                     break;
                    }
                    System.out.println("Modelos disponibles:");
                    modeloManager.listarModelos();
                    System.out.println("Ingrese ID del Modelo para buscar sus experimentos ejecutados:");
                    String modeloIdForSearchExecuted = scanner.next();
                    try {
                        ListaEnlazada<Experimento> experimentosEjecutadosPorModelo = experimentoManager.buscarExperimentoEjecutadoPorModelo(modeloIdForSearchExecuted);
                        if (experimentosEjecutadosPorModelo.tamaño() == 0) {
                            System.out.println("No hay experimentos ejecutados para el modelo con ID: " + modeloIdForSearchExecuted);
                        } else {
                            System.out.println("Experimentos ejecutados para el modelo con ID: " + modeloIdForSearchExecuted);
                            experimentosEjecutadosPorModelo.imprimir();
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    if(opcion != 0){
                        recibirDato();
                    }
                    break;
                case 12:
                    if (datasetsManager.getDatasetList().tamaño() == 0) {
                        System.out.println("No hay datasets disponibles. Por favor, cree un modelo primero.");
                        if(opcion != 0){
                            recibirDato();
                        }
                     break;
                    }
                    System.out.println("Datasets disponibles:");
                    datasetsManager.listarDatasets();
                    System.out.println("Ingrese ID del Dataset para buscar sus experimentos ejecutados:");
                    String datasetIdForSearchExecuted = scanner.next();
                    try {
                        ListaEnlazada<Experimento> experimentosEjecutadosPorDataset = experimentoManager.buscarExperimentoEjecutadoPorDataset(datasetIdForSearchExecuted);
                        if (experimentosEjecutadosPorDataset.tamaño() == 0) {
                            System.out.println("No hay experimentos ejecutados para el dataset con ID: " + datasetIdForSearchExecuted);
                        } else {
                            System.out.println("Experimentos ejecutados para el dataset con ID: " + datasetIdForSearchExecuted);
                            experimentosEjecutadosPorDataset.imprimir();
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    if(opcion != 0){
                        recibirDato();
                    }
                    break;
                case 13:
                    if (modeloManager.getModeloList().tamaño() == 0) {
                        System.out.println("No hay modelos disponibles. Por favor, cree un modelo primero.");
                        if(opcion != 0){
                            recibirDato();
                        }
                     break;
                    }
                    System.out.println("Modelos disponibles:");
                    modeloManager.listarModelos();
                    System.out.println("Ingrese ID del Modelo a eliminar:");
                    String modeloIdToDelete = scanner.next();

                    if(experimentoManager.buscarExperimentoNoEjecutadoPorModelo(modeloIdToDelete).tamaño()!=0){
                        System.out.println("No se puede eliminar el modelo con ID: " + modeloIdToDelete + " porque tiene experimentos no ejecutados asociados.");
                        if(opcion != 0){
                            recibirDato();
                        }
                     break;
                    }

                    try {
                        modeloManager.eliminarModelo(modeloIdToDelete);
                        System.out.println("Modelo eliminado exitosamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    if(opcion != 0){
                        recibirDato();
                    }
                    break;
                case 14:
                    if (datasetsManager.getDatasetList().tamaño() == 0) {
                        System.out.println("No hay datasets disponibles. Por favor, cree un dataset primero.");
                        if(opcion != 0){
                            recibirDato();
                        }
                     break;
                    }
                    System.out.println("Datasets disponibles:");
                    datasetsManager.listarDatasets();
                    System.out.println("Ingrese ID del Dataset a eliminar:");
                    String datasetIdToDelete = scanner.next();

                    if(experimentoManager.buscarExperimentoNoEjecutadoPorDataset(datasetIdToDelete).tamaño()!=0){
                        System.out.println("No se puede eliminar el dataset con ID: " + datasetIdToDelete + " porque tiene experimentos no ejecutados asociados.");
                        if(opcion != 0){
                            recibirDato();
                        }
                     break;
                    }

                    try {
                        datasetsManager.eliminarDataset(datasetIdToDelete);
                        System.out.println("Dataset eliminado exitosamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                        if(opcion != 0){
                            recibirDato();
                        }
                     break;
                case 0:
                    System.out.println("Saliendo...");
                    if(opcion != 0){
                        recibirDato();
                    }
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
    }
}
