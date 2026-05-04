package org.example.Clases;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
public class ModeloManagerTest {
    ModeloManager modeloManager = new ModeloManager();
    Modelo modelo = new Modelo("id1", "modelo", TipoModelo.RANDOM_FOREST);

    @Test
    public void createModeloNotExistTest(){
        Modelo modeloResultante = modeloManager.createModelo("id1", "modelo", TipoModelo.RANDOM_FOREST);
        assertEquals(modelo.getId(), modeloResultante.getId());
        assertEquals(modelo.getNombre(), modeloResultante.getNombre());
        assertEquals(modelo.getTipo(), modeloResultante.getTipo());
        assertEquals(1, modeloManager.getModeloList().tamaño());
        assertEquals(modeloResultante, modeloManager.getModeloList().obtener(0));
    }

    @Test
    public void createModeloAlreadyExistsTest(){
        modeloManager.createModelo("id1", "modelo", TipoModelo.RANDOM_FOREST);
        assertThrows(IllegalArgumentException.class, () -> modeloManager.createModelo("id1", "modelo", TipoModelo.RANDOM_FOREST));
    }

    @Test
    public void searchModeloExistTest(){
        modeloManager.createModelo("id1", "modelo", TipoModelo.RANDOM_FOREST);
        Modelo modeloResultante = modeloManager.searchModelo("id1");
        assertEquals(modelo.getId(), modeloResultante.getId());
        assertEquals(modelo.getNombre(), modeloResultante.getNombre());
        assertEquals(modelo.getTipo(), modeloResultante.getTipo());
    }

    @Test
    public void searchModeloNotExistTest(){
        assertThrows(IllegalArgumentException.class, () -> modeloManager.searchModelo("id1"));
    }

    @Test
    public void eliminarModeloExistTest(){
        modeloManager.createModelo("id1", "modelo", TipoModelo.RANDOM_FOREST);
        modeloManager.eliminarModelo("id1");
        assertEquals(0, modeloManager.getModeloList().tamaño());
    }

    @Test
    public void eliminarModeloNotExistTest(){
        modeloManager.createModelo("id2", "modelo", TipoModelo.RANDOM_FOREST);
        int tamañoListaAntes = modeloManager.getModeloList().tamaño();
        assertThrows(IllegalArgumentException.class, () -> modeloManager.eliminarModelo("id1"));
        assertEquals(tamañoListaAntes, modeloManager.getModeloList().tamaño());
    }

    @Test
    public void imprimirListaTest(){
        modeloManager.createModelo("id1", "modelo1", TipoModelo.RANDOM_FOREST);
        modeloManager.createModelo("id2", "modelo2", TipoModelo.SVM);
        modeloManager.getModeloList().getHead().dato.agregarParametro("n_estimators=100");
        StringBuilder outputEsperado = new StringBuilder();
        outputEsperado.append("ID: id1, Nombre: modelo1, Tipo: RANDOM_FOREST, Parámetros: [n_estimators=100]\n");
        outputEsperado.append("ID: id2, Nombre: modelo2, Tipo: SVM, Parámetros: []\n");
        outputEsperado.append("");
        PrintStream original = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        assertDoesNotThrow(() -> modeloManager.listarModelos());
        assertEquals(outputEsperado.toString(), output.toString().replace("\r", ""));
    }
}
