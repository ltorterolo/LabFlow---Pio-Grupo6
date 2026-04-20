package org.example.Ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.Ejercicio17.BibliotecaCentral.Libro;
import org.junit.jupiter.api.Test;

public class LibroTest {
    @Test
    public void testCrearLibro() {
        Libro libro = new Libro("001", "Java");

        assertEquals("001", libro.codigo);
        assertEquals("Java", libro.titulo);
    }

    @Test
    public void testEquals() {
        Libro libro1 = new Libro("001", "Java");
        Libro libro2 = new Libro("001", "Otro");

        assertTrue(libro1.equals(libro2));
    }
}
