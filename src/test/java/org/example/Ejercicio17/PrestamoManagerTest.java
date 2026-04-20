package org.example.Ejercicio17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;

import org.example.Ejercicio17.BibliotecaCentral.*;
import org.junit.jupiter.api.Test;

public class PrestamoManagerTest {
@Test
public void testPrestaCorrectamente() {
    BufferedReader br = new BufferedReader(new StringReader("LIBRO1, PRESTAMO, 2\n"));        
    BibliotecaUCU biblioteca = new BibliotecaUCU();
    biblioteca.incorporarLibroCatalogo("Sebastian", "LIBRO1", 250, 3);
    int cantInicial = biblioteca.consultarExistencias("LIBRO1");
    PrestamoManager adminTest = new PrestamoManager(br, biblioteca);
    adminTest.read();
    int cantFinal = biblioteca.consultarExistencias("LIBRO1");
    assertEquals(cantInicial, cantFinal+2);
    }

@Test
public void testDevolucion(){
    BufferedReader br = new BufferedReader(new StringReader("LIBRO1, DEVOLUCION, 2\n"));        
    BibliotecaUCU biblioteca = new BibliotecaUCU();
    biblioteca.incorporarLibroCatalogo("Sebastian", "LIBRO1", 250, 3);
    int cantInicial = biblioteca.consultarExistencias("LIBRO1");
    PrestamoManager adminTest = new PrestamoManager(br, biblioteca);
    adminTest.read();
    int cantFinal = biblioteca.consultarExistencias("LIBRO1");
    assertEquals(cantInicial, cantFinal-2);
    }

    @Test
    public void testSingleton(){
        PrestamoManager manager = new PrestamoManager();
        assertEquals(manager.biblioteca, BibliotecaUCU.getBiblioteca());
    }

    @Test
    public void testReadAll(){
        BufferedReader br = new BufferedReader(new StringReader("LIBRO1, DEVOLUCION, 2\nLIBRO2, PRESTAMO, 1\n"));        
        BibliotecaUCU biblioteca = new BibliotecaUCU();
        biblioteca.incorporarLibroCatalogo("ALlgoritmos", "LIBRO1", 250, 3);
        biblioteca.incorporarLibroCatalogo("Programacion1", "LIBRO2", 250, 7);
        int cantInicial1 = biblioteca.consultarExistencias("LIBRO1");
        int cantInicial2 = biblioteca.consultarExistencias("LIBRO2");
        PrestamoManager adminTest = new PrestamoManager(br, biblioteca);
        adminTest.readAll();
        int cantFinal1 = biblioteca.consultarExistencias("LIBRO1");
        int cantFinal2 = biblioteca.consultarExistencias("LIBRO2");
        assertEquals(cantInicial1, cantFinal1-2);
        assertEquals(cantInicial2, cantFinal2+1);
    }
}
