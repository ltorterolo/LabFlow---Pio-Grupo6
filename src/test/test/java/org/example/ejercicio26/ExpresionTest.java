package org.example.ejercicio26;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ExpresionTest {

    List<Character> validInputWithValidCharacters = List.of('{', '{', '}', '{', '}', '}');
    List<Character> invalidInputWithValidCharacters = List.of('{', '}', '}', '{', '}', '}');
    List<Character> invalidInputWithInvalidCharacters = List.of('{', '}', 'a', 'b', 'c', '}');
    List<Character> validInputWithInvalidCharacters = List.of('{', 'a', 'b', 'c', '}', '{', 'd', 'e', 'f', '}');
    @Test
    public void controlCorchetesWithValidInput(){
        assertTrue(Expresion.controlCorchetes(validInputWithValidCharacters));
    }

    @Test
    public void controlCorchetesWithInvalidInputWithValidCharacters(){
        assertFalse(Expresion.controlCorchetes(invalidInputWithValidCharacters));
    }

    @Test
    public void controlCorchetesWithInvalidInputWithInvalidCharacters(){
        assertFalse(Expresion.controlCorchetes(invalidInputWithInvalidCharacters));
    }

     @Test
    public void controlCorchetesWithValidInputWithInvalidCharacters(){
        assertTrue(Expresion.controlCorchetes(validInputWithInvalidCharacters));
    }

    @Test
    public void controlCorchetesWithEmptyList(){
        assertTrue(Expresion.controlCorchetes(List.of()));
    }

    @Test
    public void controlCorchetesWithOnlyOpeningBracket(){
        assertFalse(Expresion.controlCorchetes(List.of('{')));
    }

    @Test
    public void controlCorchetesWithOnlyCloseBracket(){
        assertFalse(Expresion.controlCorchetes(List.of('}')));
    }

    @Test
    public void controlCorchetesStartingWithCloseBracket(){
        assertFalse(Expresion.controlCorchetes(List.of('}', '{', '}', '{')));
    }

    @Test
    public void controlCorchetesWithOnlyInvalidCharacters(){
        assertTrue(Expresion.controlCorchetes(List.of('a', 'b', 'c', 'd')));
    }
}
