package org.example.Ejercicio17;

import java.io.BufferedReader;
import java.io.StringReader;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.example.Ejercicio17.BibliotecaCentral.*;
import org.junit.jupiter.api.Test;

public class AcquisitionManagerTest {

    @Test
    public void testAdquirirUno(){
        BufferedReader br = new BufferedReader(new StringReader("LIBRO1, Fisica, 250, 2\n"));//978-987-722-123-4, Introducción a la Programación en Java, 1800.50, 3
        BibliotecaUCU biblioteca = new BibliotecaUCU();
        AquisitonManager manager = new AquisitonManager(br, biblioteca);
        manager.adquirirUno();
        NodoLibro libro = biblioteca.buscarLibro("LIBRO1");
        float precio = 250;
        assertEquals(libro.getPrecio(), precio);
        assertEquals(libro.getStock(), 2);
        assertEquals(libro.getTitulo(), "Fisica");    
    }

    @Test
    public void testSingleton(){
        AquisitonManager manager = new AquisitonManager();
        assertEquals(manager.biblioteca, BibliotecaUCU.getBiblioteca());
    }

    @Test
    public void testAdquirirTodos(){
        BufferedReader br = new BufferedReader(new StringReader("LIBRO1, Fisica, 250, 2\nLIBRO2, Matematica, 1000, 4\n"));//978-987-722-123-4, Introducción a la Programación en Java, 1800.50, 3
        BibliotecaUCU biblioteca = BibliotecaUCU.getBiblioteca();
        AquisitonManager manager = new AquisitonManager(br, biblioteca);
        manager.adquirirTodo();
        NodoLibro libro1 = biblioteca.buscarLibro("LIBRO1");
        NodoLibro libro2 = biblioteca.buscarLibro("LIBRO2");
        float precio1 = 250;
        assertEquals(libro1.getPrecio(), precio1);
        assertEquals(libro1.getStock(), 2);
        assertEquals(libro1.getTitulo(), "Fisica"); 
        float precio2 = 1000;
        assertEquals(libro2.getPrecio(), precio2);
        assertEquals(libro2.getStock(), 4);
        assertEquals(libro2.getTitulo(), "Matematica");
    }
}
