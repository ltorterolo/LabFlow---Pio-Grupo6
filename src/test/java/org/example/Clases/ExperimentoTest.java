package org.example.Clases;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExperimentoTest {
    private Dataset dataset = new Dataset("id1", "dataset", 3, TipoProblema.REGRESION);
    private Modelo modelo = new Modelo("id1", "modelo", TipoModelo.RED_NEURONAL);
    private Experimento experimento = new Experimento("id1", dataset, modelo);

    @Test
    public void constructorAndGettersTest(){
        experimento = new Experimento("id1", dataset, modelo);
        assertEquals("id1", experimento.getId());
        assertEquals(dataset, experimento.getDataset());
        assertEquals(modelo, experimento.getModelo());
        assertEquals(Estado.PENDIENTE, experimento.getEstado());
        experimento.setDataset(new Dataset("id2", "dataset2", 4, TipoProblema.CLASIFICACION));
        experimento.setModelo(new Modelo("id2", "modelo2", TipoModelo.SVM));
        assertEquals("id2", experimento.getDataset().getId());
        assertEquals("id2", experimento.getModelo().getId());
        experimento.setId("id2");
        assertEquals("id2", experimento.getId());
        assertEquals(0, experimento.getAccuracy());
        assertEquals(0, experimento.getPrecision());
        assertEquals(0, experimento.getTimeSpent());
        assertEquals(0, experimento.getEficiencia());
    }

    @Test
    public void ejecutarPendienteTest(){
        assertTrue(experimento.ejecutar());
    }

    @Test
    public void ejecutarEjecutadoTest(){
        assertThrows(IllegalArgumentException.class, () -> {
            experimento.ejecutar();
            experimento.ejecutar();
        });
    }

    @Test
    public void toStringTest(){
        String experimento1 = experimento.toString();
        assertEquals(("Experimento - ID: " + experimento.getId() + ", eficiencia: " + experimento.getEficiencia() + ", accuracy: " + experimento.getAccuracy() + ", precision: " + experimento.getPrecision() + ", tiempo: " + experimento.getTimeSpent() + ", estado: " + experimento.getEstado()), experimento1);
    }

}
