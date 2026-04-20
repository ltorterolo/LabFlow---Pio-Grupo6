package org.example.Ejercicio17;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

public class PilaTest {

    @Test
    public void testMeteYTope() {
        Pila<Integer> pila = new Pila<>();
        pila.mete(5);

        assertEquals(5, pila.tope());
    }

    @Test
    public void testLIFO() {
        Pila<Integer> pila = new Pila<>();

        pila.mete(1);
        pila.mete(2);
        pila.mete(3);

        assertEquals(3, pila.saca());
        assertEquals(2, pila.saca());
        assertEquals(1, pila.saca());
    }

    @Test
    public void testPilaVaciaTope() {
        Pila<Integer> pila = new Pila<>();

        assertThrows(NoSuchElementException.class, () -> {
            pila.tope();
        });
    }

    @Test
    public void testPilaVaciaSaca() {
        Pila<Integer> pila = new Pila<>();

        assertThrows(NoSuchElementException.class, () -> {
            pila.saca();
        });
    }
}
