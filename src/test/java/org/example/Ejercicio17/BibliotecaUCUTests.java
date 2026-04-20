package org.example.Ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.example.Ejercicio17.BibliotecaCentral.BibliotecaUCU;
import org.example.Ejercicio17.BibliotecaCentral.NodoLibro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BibliotecaUCUTests {
    private BibliotecaUCU biblioteca;

    @BeforeEach
    public void setUp() {
        biblioteca = BibliotecaUCU.getBiblioteca();
        biblioteca.limpiarCatalogo();
        
        // Agregar libros de prueba
        biblioteca.incorporarLibroCatalogo("Java", "001", 100, 10);
        biblioteca.incorporarLibroCatalogo("Python", "002", 200, 5);
    }

    @Test
    public void testBuscarLibro() {
        NodoLibro libro = biblioteca.buscarLibro("001");
        assertNotNull(libro);
        assertEquals("Java", libro.getTitulo());
    }

    @Test
    public void testBuscarLibroInexistente() {
        NodoLibro libro = biblioteca.buscarLibro("999");
        assertNull(libro);
    }

    @Test
    public void testPrestamo() {
        boolean resultado = biblioteca.prestamo("001", 2);
        assertTrue(resultado);
        assertEquals(8, biblioteca.consultarExistencias("001"));
    }

    @Test
    public void testDevolucion() {
        biblioteca.devolucion("001", 3);
        assertEquals(13, biblioteca.consultarExistencias("001"));
    }

    @Test
    public void testRetirarLibro() {
        boolean resultado = biblioteca.retirarLibro("002");
        assertTrue(resultado);
        assertNull(biblioteca.buscarLibro("002"));
    }

    @Test
    public void testConsultarExistencias() {
        int stock = biblioteca.consultarExistencias("001");
        assertEquals(10, stock);
    }

    @Test
    public void testConsultarExistenciasInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            biblioteca.consultarExistencias("999");
        });
    }

    @Test
    public void testListar() {
    biblioteca.incorporarLibroCatalogo("C++", "003", 150, 7);

    ByteArrayOutputStream salida = new ByteArrayOutputStream();
    System.setOut(new PrintStream(salida));

    biblioteca.listar();

    String resultado = salida.toString();

    assertTrue(resultado.contains("Java"));
    assertTrue(resultado.contains("Python"));
    assertTrue(resultado.contains("C++"));
    }

    @Test
public void testOrdenarPorTitulo() {
    biblioteca.incorporarLibroCatalogo("C++", "003", 150, 7);

    ByteArrayOutputStream salida = new ByteArrayOutputStream();
    System.setOut(new PrintStream(salida));

    biblioteca.ordenarPorTitulo();

    String resultado = salida.toString();

    int indexC = resultado.indexOf("C++");
    int indexJ = resultado.indexOf("Java");
    int indexP = resultado.indexOf("Python");

    assertTrue(indexC < indexJ);
    assertTrue(indexJ < indexP);
}
}
