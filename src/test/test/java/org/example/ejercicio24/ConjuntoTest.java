package org.example.ejercicio24;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.example.Ejercicio17.TDAConjunto;

import org.junit.jupiter.api.Test;

class ConjuntoTest {
   @Test
    public void testUnion() {
        Conjunto<Integer> c1 = new Conjunto<>();
        Conjunto<Integer> c2 = new Conjunto<>();

        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);

        c2.agregar(3);
        c2.agregar(4);

        TDAConjunto<Integer> resultado = c1.union(c2);
        // debería contener 1, 2, 3, 4 sin duplicados
        assertTrue(resultado.contiene(1));
        assertTrue(resultado.contiene(2));
        assertTrue(resultado.contiene(3));
        assertTrue(resultado.contiene(4));
    }
    @Test
    public void testInterseccion() {
        Conjunto<Integer> c1 = new Conjunto<>();
        Conjunto<Integer> c2 = new Conjunto<>();

        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);

        c2.agregar(2);
        c2.agregar(3);
        c2.agregar(4);

        TDAConjunto<Integer> resultado = c1.interseccion(c2);
        // debería contener solo 2 y 3
        assertTrue(resultado.contiene(2));
        assertTrue(resultado.contiene(3));
        // no debería contener 1 ni 4
        assertFalse(resultado.contiene(1));
        assertFalse(resultado.contiene(4));
    }
    @Test
    public void testDiferencia() {
        // c1 tiene 1, 2, 3 y c2 tiene 3, 4. La diferencia c1 - c2 debería ser {1, 2}
        Conjunto<Integer> c1 = new Conjunto<>();
        Conjunto<Integer> c2 = new Conjunto<>();

        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(3);

        c2.agregar(3);

        TDAConjunto<Integer> resultado = c1.diferencia(c2);
        // debería contener solo 1 y 2
        assertTrue(resultado.contiene(1));
        assertTrue(resultado.contiene(2));
        // no debería contener 3
        assertFalse(resultado.contiene(3));
    }

    @Test
    public void testSubconjunto() {
        Conjunto<Integer> c1 = new Conjunto<>();
        Conjunto<Integer> c2 = new Conjunto<>();
        
        c1.agregar(1);
        c1.agregar(2);
        // c1 es subconjunto de c2
        c2.agregar(1);
        c2.agregar(2);
        c2.agregar(3);

        assertTrue(c1.esSubconjuntoDe(c2));
        assertFalse(c2.esSubconjuntoDe(c1));
    }
    @Test
    public void unionConVacio() {
        // La unión de un conjunto con el conjunto vacío debería ser el mismo conjunto
        Conjunto<Integer> c1 = new Conjunto<>();
        Conjunto<Integer> c2 = new Conjunto<>();

        c1.agregar(1);
        c1.agregar(2);
        // c2 está vacío
        TDAConjunto<Integer> res = c1.union(c2);
        // debería contener 1 y 2
        assertTrue(res.contiene(1));
        assertTrue(res.contiene(2));
    }

    @Test
    public void interseccionConVacio() {
        // La intersección de un conjunto con el conjunto vacío debería ser el conjunto vacío
        Conjunto<Integer> c1 = new Conjunto<>();
        Conjunto<Integer> c2 = new Conjunto<>();

        c1.agregar(1);
        c2.agregar(2);

        TDAConjunto<Integer> res = c1.interseccion(c2);

        assertFalse(res.contiene(1)); 
    }

    @Test
    public void diferenciaConVacio() {
        // La diferencia de un conjunto con el conjunto vacío debería ser el mismo conjunto
        Conjunto<Integer> c1 = new Conjunto<>();
        Conjunto<Integer> c2 = new Conjunto<>();

        c1.agregar(1);

        TDAConjunto<Integer> res = c1.diferencia(c2);

        assertTrue(res.contiene(1));
    }

    @Test
    public void subconjuntoVacio() {
        // El conjunto vacío es subconjunto de cualquier conjunto, incluyendo a sí mismo
        Conjunto<Integer> c1 = new Conjunto<>();
        Conjunto<Integer> c2 = new Conjunto<>();

        assertTrue(c1.esSubconjuntoDe(c2)); 
    }

    @Test
    public void conjuntoVacioEsSubconjunto() {
        // Cualquier conjunto es subconjunto del conjunto vacío solo si el conjunto también es vacío
        Conjunto<Integer> c1 = new Conjunto<>();
        Conjunto<Integer> c2 = new Conjunto<>();

        c2.agregar(1);

        assertTrue(c1.esSubconjuntoDe(c2)); 
    }

    @Test
    public void diferenciaTotal() {
        // La diferencia de dos conjuntos idénticos debería ser el conjunto vacío
        Conjunto<Integer> c1 = new Conjunto<>();
        Conjunto<Integer> c2 = new Conjunto<>();

        c1.agregar(1);
        c1.agregar(2);

        c2.agregar(1);
        c2.agregar(2);

        TDAConjunto<Integer> res = c1.diferencia(c2);

        assertFalse(res.contiene(1));
        assertFalse(res.contiene(2));
    }

    @Test
    public void unionSinDuplicados() {
        Conjunto<Integer> c1 = new Conjunto<>();
        Conjunto<Integer> c2 = new Conjunto<>();

        c1.agregar(1);
        c2.agregar(1);

        TDAConjunto<Integer> res = c1.union(c2);

        // debería haber un solo 1
        int count = 0;
        if (res.contiene(1)) count++;

        assertEquals(1, count);
    }
    @Test
    public void subconjuntoDeSiMismo() {
        Conjunto<Integer> c1 = new Conjunto<>();

        c1.agregar(1);
        c1.agregar(2);

        assertTrue(c1.esSubconjuntoDe(c1));
    }

}

