package org.example.Clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModeloTest {
    Modelo modelo = new Modelo("M001", "Modelo de Clasificación", TipoModelo.RANDOM_FOREST);

    @Test
    public void constructorAndGettersTest(){
        Modelo modelo1 = new Modelo("M002", "Modelo de Regresión", TipoModelo.REGRESION_LINEAL);
        assertEquals("M002",  modelo1.getId());
        assertEquals("Modelo de Regresión", modelo1.getNombre());
        assertEquals(TipoModelo.REGRESION_LINEAL, modelo1.getTipo());
        assertEquals(0, modelo1.getParametrosAsociados().tamaño());
    }

    @Test
    public void agregarParametroTest(){
        assertTrue(modelo.agregarParametro("n_estimators=100"));
        assertTrue(modelo.agregarParametro("max_depth=10"));
        assertEquals(2, modelo.getParametrosAsociados().tamaño());
        assertEquals("n_estimators=100", modelo.getParametrosAsociados().obtener(0));
        assertEquals("max_depth=10", modelo.getParametrosAsociados().obtener(1));
    }

    @Test
    public void toStringTest() {
        modelo.agregarParametro("n_estimators=100");
        modelo.agregarParametro("max_depth=10");
        String expected = "ID: M001, Nombre: Modelo de Clasificación, Tipo: RANDOM_FOREST, Parámetros: [n_estimators=100, max_depth=10]";
        assertEquals(expected, modelo.toString());
    }
}
