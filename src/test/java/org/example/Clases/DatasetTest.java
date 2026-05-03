package org.example.Clases;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatasetTest {
    @Test
    public void constructorAndGettersTest(){
        Dataset dataset = new Dataset("id1", "dataset", 3, TipoProblema.REGRESION);
        assertEquals("id1", dataset.getId());
        assertEquals("dataset", dataset.getName());
        assertEquals(3, dataset.getSize());
        assertEquals(TipoProblema.REGRESION, dataset.getTipoProblema());
    }

    @Test
    public void toStringTest(){
        Dataset dataset = new Dataset("id1", "dataset", 3, TipoProblema.REGRESION);
        assertEquals(("ID: " + dataset.getId() + ", Nombre: " + dataset.getName() + ", Tamaño: " + dataset.getSize() + ", TipoProblema: " + dataset.getTipoProblema()), dataset.toString());
    }
}
