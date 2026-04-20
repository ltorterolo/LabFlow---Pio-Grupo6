package org.example.ejercicio24;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Alumno24Test {
     @Test
    public void testEqualsMismaCedula() {
        TAlumno24 a1 = new TAlumno24(1234, "Juan", "Perez");
        TAlumno24 a2 = new TAlumno24(1234, "Pedro", "Gomez");

        assertTrue(a1.equals(a2));
    }

    @Test
    public void testEqualsDistintaCedula() {
        TAlumno24 a1 = new TAlumno24(1234, "Juan", "Perez");
        TAlumno24 a2 = new TAlumno24(5678, "Joaquin", "Martinez");

        assertFalse(a1.equals(a2));
    }
    @Test
    public void testEqualsMismoObjeto() {
        TAlumno24 a1 = new TAlumno24(1234, "Lucas", "Perez");

        assertTrue(a1.equals(a1));
    }

    @Test
    public void testEqualsNull() {
        TAlumno24 a1 = new TAlumno24(1234, "Juan", "Perez");

        assertFalse(a1.equals(null));
    }
    @Test
    public void testCompareToMenor() {
        TAlumno24 a1 = new TAlumno24(1234, "Daniel", "Perez");
        TAlumno24 a2 = new TAlumno24(5678, "Ana", "Gomez");

        assertTrue(a1.compareTo(a2) < 0);
    }

    @Test
    public void testCompareToMayor() {
        TAlumno24 a1 = new TAlumno24(5678, "Pedro", "Perez");
        TAlumno24 a2 = new TAlumno24(1234, "Ana", "Gomez");

        assertTrue(a1.compareTo(a2) > 0);
    }

    @Test
    public void testCompareToIgual() {
        TAlumno24 a1 = new TAlumno24(1234, "Martin", "Perez");
        TAlumno24 a2 = new TAlumno24(1234, "Otro", "Nombre");

        assertEquals(0, a1.compareTo(a2));
    }


    
}
