package org.example.Ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.Ejercicio17.BibliotecaCentral.NodoLibro;
import org.junit.jupiter.api.Test;

public class NodoLibroTest {

    @Test
    public void testCrearNodoLibro() {
        NodoLibro nodo = new NodoLibro("Java", "001", 100, 10);
        
        assertEquals("001", nodo.getCodigo());
        assertEquals(10, nodo.getStock());
        assertEquals(100, nodo.getPrecio());
    }

    @Test
    public void testModifyStock() {
        NodoLibro nodo = new NodoLibro("Java", "001", 100, 10);
        nodo.modifyStock(-5);
        assertEquals(5, nodo.getStock());
    }

    @Test
    public void testModifyStockNoNegativo() {
        NodoLibro nodo = new NodoLibro("Java", "001", 100, 10);
        nodo.modifyStock(-20);
        assertEquals(0, nodo.getStock());
    }

    @Test
    public void testModifyPrice() {
        NodoLibro nodo = new NodoLibro("Java", "001", 100, 10);
        nodo.modifyPrice(200);
        assertEquals(200, nodo.getPrecio());
    }

    @Test
    public void testEquals() {
        NodoLibro nodo1 = new NodoLibro("Java", "001", 100, 10);
        NodoLibro nodo2 = new NodoLibro("Java", "001", 200, 5);

        assertEquals(nodo1, nodo2);
    }
}
