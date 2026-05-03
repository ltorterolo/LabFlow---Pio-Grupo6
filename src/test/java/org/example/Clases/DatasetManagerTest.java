package org.example.Clases;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class DatasetManagerTest {
    private DatasetsManager datasetsManager = new DatasetsManager();
    @Test
    public void createNewDatasetTest(){
        Dataset dataset = new Dataset("id1", "dataset", 3, TipoProblema.REGRESION);
        datasetsManager.createDataset("id1", "dataset", 3, TipoProblema.REGRESION);
        assertEquals(1, datasetsManager.getDatasetList().tamaño());
        assertEquals(dataset.getId(), datasetsManager.getDatasetList().getHead().dato.getId());
    }

    @Test
    public void createExistingDatasetTest(){
        Dataset dataset = new Dataset("id1", "dataset", 3, TipoProblema.REGRESION);
        datasetsManager.createDataset("id1", "dataset", 3, TipoProblema.REGRESION);
        assertThrows(IllegalArgumentException.class, () -> datasetsManager.createDataset("id1", "dataset", 3, TipoProblema.REGRESION));
    }

    @Test
    public void searchExistingDatasetTest(){
        Dataset dataset = new Dataset("id1", "dataset", 3, TipoProblema.REGRESION);
        datasetsManager.createDataset("id1", "dataset", 3, TipoProblema.REGRESION);
        assertEquals(dataset.getId(), datasetsManager.SearchDataset("id1").getId());
    }

    @Test
    public void searchExistingDatasetNotInHeadTest(){
        Dataset dataset2 = new Dataset("id2", "dataset2", 4, TipoProblema.CLASIFICACION);
        datasetsManager.createDataset("id1", "dataset", 3, TipoProblema.REGRESION);
        datasetsManager.createDataset("id2", "dataset2", 4, TipoProblema.CLASIFICACION);
        assertEquals(dataset2.getId(), datasetsManager.SearchDataset("id2").getId());
    }

    @Test
    public void searchNonExistingDatasetTest(){
        assertThrows(IllegalArgumentException.class, () -> datasetsManager.SearchDataset("id1"));
    }

    @Test
    public void eliminarExistingDatasetTest(){
        Dataset dataset = new Dataset("id1", "dataset", 3, TipoProblema.REGRESION);
        datasetsManager.createDataset("id1", "dataset", 3, TipoProblema.REGRESION);
        datasetsManager.eliminarDataset("id1");
        assertEquals(0, datasetsManager.getDatasetList().tamaño());
    }

    @Test
    public void eliminarNonExistingDatasetTest(){
        assertThrows(IllegalArgumentException.class, () -> datasetsManager.eliminarDataset("id1"));
    }

    @Test
    public void listarNoEmptyDatasetsTest(){
        PrintStream original = System.out;

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        datasetsManager.createDataset("id1", "dataset", 3, TipoProblema.REGRESION);
        datasetsManager.createDataset("id2", "dataset2", 4, TipoProblema.CLASIFICACION);

        assertDoesNotThrow(()  -> datasetsManager.listarDatasets());
        assertTrue(output.toString().contains("ID: id1, Nombre: dataset, Tamaño: 3, TipoProblema: REGRESION"));
        assertTrue(output.toString().contains("ID: id2, Nombre: dataset2, Tamaño: 4, TipoProblema: CLASIFICACION"));
        System.setOut(original);
    }

}
