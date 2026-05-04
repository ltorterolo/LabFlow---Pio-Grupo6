package org.example.Clases;

import org.example.TDAs.ListaEnlazada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExperimentoManagerTest {
    ExperimentoManager experimentoManager = new ExperimentoManager();
    Dataset dataset = new Dataset("id1", "dataset", 3, TipoProblema.REGRESION);
    Modelo modelo = new Modelo("id1", "modelo", TipoModelo.RED_NEURONAL);

    @Test
    public void createNewExperimentoTest(){
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        assertEquals(1, experimentoManager.getExperimentosNoEjecutados().tamaño());
        assertEquals("exp1", experimentoManager.getExperimentosNoEjecutados().getHead().dato.getId());
    }

    @Test
    public void createExperimentoInNoEjecutadosTest(){
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        assertThrows(IllegalArgumentException.class, () -> experimentoManager.crearExperimento("exp1", dataset, modelo));
    }

    @Test
    public void createExperimentoInEjecutadosTest(){
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        experimentoManager.ejecutarExperimento("exp1");
        assertThrows(IllegalArgumentException.class, () -> experimentoManager.crearExperimento("exp1", dataset, modelo));
    }

    @Test
    public void searchExperimentoIsInEjecutadosTest(){
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        experimentoManager.ejecutarExperimento("exp1");
        assertEquals("exp1", experimentoManager.searchExperimento("exp1").getId());
    }

    @Test
    public void searchExperimentoNotExistTest(){
        assertThrows(IllegalArgumentException.class, () -> experimentoManager.searchExperimento("exp1"));
    }

    @Test
    public void listarPorModeloTest(){
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        experimentoManager.crearExperimento("exp2", dataset, new Modelo("id2", "modelo2", TipoModelo.SVM));
        experimentoManager.crearExperimento("exp3", dataset, modelo);
        assertEquals("id1", experimentoManager.listarPorModelo().getHead().dato.getModelo().getId());
        assertEquals("id1", experimentoManager.listarPorModelo().getHead().siguiente.dato.getModelo().getId());
        assertEquals("id2", experimentoManager.listarPorModelo().getHead().siguiente.siguiente.dato.getModelo().getId());
    }

    @Test
    public void listarPorDatasetTest(){
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        experimentoManager.crearExperimento("exp2", new Dataset("id2", "dataset2", 4, TipoProblema.CLASIFICACION), modelo);
        experimentoManager.crearExperimento("exp3", dataset, modelo);
        assertEquals("id1", experimentoManager.listarPorDataset().getHead().dato.getDataset().getId());
        assertEquals("id1", experimentoManager.listarPorDataset().getHead().siguiente.dato.getDataset().getId());
        assertEquals("id2", experimentoManager.listarPorDataset().getHead().siguiente.siguiente.dato.getDataset().getId());
    }

    @Test
    public void buscarTodosPorDatasetNotExistTest(){
        assertEquals(0,experimentoManager.listarPorDataset().tamaño());
        ListaEnlazada<Experimento> resultados = experimentoManager.buscarTodosPorDataset("id1");
    }

    @Test
    public void buscarTodosPorDatasetInNoEjecutadosTest(){
        Dataset dataset1 = new Dataset("id2", "dataset", 3, TipoProblema.REGRESION);
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        experimentoManager.crearExperimento("exp2", dataset, modelo);
        ListaEnlazada<Experimento> resultados = experimentoManager.buscarTodosPorDataset("id1");
        assertEquals(2, resultados.tamaño());
        assertEquals("exp1", resultados.getHead().dato.getId());
        assertEquals("exp2", resultados.getHead().siguiente.dato.getId());
    }

    @Test
    public void buscarTodosPorDatasetInEjecutadosTest(){
        Dataset dataset1 = new Dataset("id2", "dataset", 3, TipoProblema.REGRESION);
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        experimentoManager.crearExperimento("exp2", dataset, modelo);
        experimentoManager.ejecutarExperimento("exp1");
        experimentoManager.ejecutarExperimento("exp2");
        ListaEnlazada<Experimento> resultados = experimentoManager.buscarTodosPorDataset("id1");
        assertEquals(2, resultados.tamaño());
        assertEquals("exp1", resultados.getHead().dato.getId());
        assertEquals("exp2", resultados.getHead().siguiente.dato.getId());
    }

    @Test
    public void buscarTodosPorModeloNotExistTest(){
        assertEquals(0,experimentoManager.listarPorModelo().tamaño());
        ListaEnlazada<Experimento> resultados = experimentoManager.buscarTodosPorModelo("id1");
    }

    @Test
    public void buscarTodosPorModeloInNoEjecutadosTest(){
        Modelo modelo1 = new Modelo("id2", "modelo", TipoModelo.RED_NEURONAL);
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        experimentoManager.crearExperimento("exp2", dataset, modelo);
        ListaEnlazada<Experimento> resultados = experimentoManager.buscarTodosPorModelo("id1");
        assertEquals(2, resultados.tamaño());
        assertEquals("exp1", resultados.getHead().dato.getId());
        assertEquals("exp2", resultados.getHead().siguiente.dato.getId());
    }

    @Test
    public void buscarTodosPorModeloInEjecutadosTest(){
        Modelo modelo1 = new Modelo("id2", "modelo", TipoModelo.RED_NEURONAL);
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        experimentoManager.crearExperimento("exp2", dataset, modelo);
        experimentoManager.ejecutarExperimento("exp1");
        experimentoManager.ejecutarExperimento("exp2");
        ListaEnlazada<Experimento> resultados = experimentoManager.buscarTodosPorModelo("id1");
        assertEquals(2, resultados.tamaño());
        assertEquals("exp1", resultados.getHead().dato.getId());
        assertEquals("exp2", resultados.getHead().siguiente.dato.getId());
    }

    @Test
    public void buscarEjecutadoPorModeloIsHeadTest(){
        Modelo modelo1 = new Modelo("id2", "modelo", TipoModelo.RED_NEURONAL);
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        experimentoManager.crearExperimento("exp2", dataset, modelo1);
        experimentoManager.ejecutarExperimento("exp1");
        experimentoManager.ejecutarExperimento("exp2");
        ListaEnlazada<Experimento> resultados = experimentoManager.buscarExperimentoEjecutadoPorModelo("id1");
        assertEquals(1, resultados.tamaño());
        assertEquals("exp1", resultados.getHead().dato.getId());
    }

    @Test
    public void buscarEjecutadoPorModeloNotExistTest() {
        ListaEnlazada<Experimento> resultados = experimentoManager.buscarExperimentoEjecutadoPorModelo("id1");
        assertEquals(0, resultados.tamaño());
    }

    @Test
    public void buscarEjecutadoPorModeloInEjecutadosTest() {
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        experimentoManager.crearExperimento("exp2", dataset, modelo);
        experimentoManager.ejecutarExperimento("exp1");
        experimentoManager.ejecutarExperimento("exp2");
        ListaEnlazada<Experimento> resultados = experimentoManager.buscarExperimentoEjecutadoPorModelo("id1");
        assertEquals(2, resultados.tamaño());
        assertEquals("exp1", resultados.getHead().dato.getId());
        assertEquals("exp2", resultados.getHead().siguiente.dato.getId());
    }

    @Test
    public void buscarEjecutadoPorDatasetIsHeadTest(){
        Dataset dataset1 = new Dataset("id2", "dataset", 3, TipoProblema.REGRESION);
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        experimentoManager.crearExperimento("exp2", dataset1, modelo);
        experimentoManager.ejecutarExperimento("exp1");
        experimentoManager.ejecutarExperimento("exp2");
        ListaEnlazada<Experimento> resultados = experimentoManager.buscarExperimentoEjecutadoPorDataset("id1");
        assertEquals(1, resultados.tamaño());
        assertEquals("exp1", resultados.getHead().dato.getId());
    }

    @Test
    public void buscarEjecutadoPorDatasetNotExistTest(){
        ListaEnlazada<Experimento> resultados = experimentoManager.buscarExperimentoEjecutadoPorDataset("id1");
        assertEquals(0, resultados.tamaño());
    }

    @Test
    public void buscarEjecutadoPorDatasetInEjecutadosTest(){
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        experimentoManager.crearExperimento("exp2", dataset, modelo);
        experimentoManager.ejecutarExperimento("exp1");
        experimentoManager.ejecutarExperimento("exp2");
        ListaEnlazada<Experimento> resultados = experimentoManager.buscarExperimentoEjecutadoPorDataset("id1");
        assertEquals(2, resultados.tamaño());
        assertEquals("exp1", resultados.getHead().dato.getId());
        assertEquals("exp2", resultados.getHead().siguiente.dato.getId());
    }

    @Test
    public void buscarNoEjecutadoPorModeloIsHeadTest(){
        Modelo modelo1 = new Modelo("id2", "modelo", TipoModelo.RED_NEURONAL);
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        experimentoManager.crearExperimento("exp2", dataset, modelo1);
        ListaEnlazada<Experimento> resultados = experimentoManager.buscarExperimentoNoEjecutadoPorModelo("id1");
        assertEquals(1, resultados.tamaño());
        assertEquals("exp1", resultados.getHead().dato.getId());
    }

    @Test
    public void buscarNoEjecutadoPorModeloNotExistTest() {
        ListaEnlazada<Experimento> resultados = experimentoManager.buscarExperimentoNoEjecutadoPorModelo("id1");
        assertEquals(0, resultados.tamaño());
    }

    @Test
    public void buscarNoEjecutadoPorModeloInNoEjecutadosTest() {
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        experimentoManager.crearExperimento("exp2", dataset, modelo);
        ListaEnlazada<Experimento> resultados = experimentoManager.buscarExperimentoNoEjecutadoPorModelo("id1");
        assertEquals(2, resultados.tamaño());
        assertEquals("exp1", resultados.getHead().dato.getId());
        assertEquals("exp2", resultados.getHead().siguiente.dato.getId());
    }

     @Test
    public void buscarNoEjecutadoPorDatasetIsHeadTest() {
         Dataset dataset1 = new Dataset("id2", "dataset", 3, TipoProblema.REGRESION);
         experimentoManager.crearExperimento("exp1", dataset, modelo);
         experimentoManager.crearExperimento("exp2", dataset1, modelo);
         ListaEnlazada<Experimento> resultados = experimentoManager.buscarExperimentoNoEjecutadoPorDataset("id1");
         assertEquals(1, resultados.tamaño());
         assertEquals("exp1", resultados.getHead().dato.getId());
    }

    @Test
    public void buscarNoEjecutadoPorDatasetNotExistTest() {
        ListaEnlazada<Experimento> resultados = experimentoManager.buscarExperimentoNoEjecutadoPorDataset("id1");
        assertEquals(0, resultados.tamaño());
    }

    @Test
    public void buscarNoEjecutadoPorDatasetInNoEjecutadosTest() {
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        experimentoManager.crearExperimento("exp2", dataset, modelo);
        ListaEnlazada<Experimento> resultados = experimentoManager.buscarExperimentoNoEjecutadoPorDataset("id1");
        assertEquals(2, resultados.tamaño());
        assertEquals("exp1", resultados.getHead().dato.getId());
        assertEquals("exp2", resultados.getHead().siguiente.dato.getId());
    }

    @Test
    public void getExperimentosEjecutadosTest(){
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        experimentoManager.crearExperimento("exp2", dataset, modelo);
        experimentoManager.ejecutarExperimento("exp1");
        ListaEnlazada<Experimento> ejecutados = experimentoManager.getExperimentosEjecutados();
        assertEquals(1, ejecutados.tamaño());
        assertEquals("exp1", ejecutados.getHead().dato.getId());
    }

    @Test
    public void ejecutarExperimentoNotExistTest(){
        assertThrows(IllegalArgumentException.class, () -> experimentoManager.ejecutarExperimento("exp1"));
    }

    @Test
    public void ejecutarExperimentoIsAlreadyEjecutado(){
        experimentoManager.crearExperimento("exp1", dataset, modelo);
        experimentoManager.ejecutarExperimento("exp1");
        assertThrows(IllegalArgumentException.class, () -> experimentoManager.ejecutarExperimento("exp1"));
    }


}
