package org.example.Ejercicio17;

public class Pila <T> extends ListaEnlazada<T> implements TDAPila<T> {

    public int size =0;

    @Override
    public T tope() throws java.util.NoSuchElementException {
        if (head != null){
            return head.dato;
        }
        throw new java.util.NoSuchElementException();
    }

    @Override
    public T saca() throws java.util.NoSuchElementException {
        if (head == null) {
        throw new java.util.NoSuchElementException();
        }

        T elementoEliminar= tope();
        Nodo<T> nodoEliminado= head;

        head= head.siguiente;
        nodoEliminado.siguiente=null;

        return elementoEliminar;

        
    }

    @Override
    public void mete(T dato) {
        Nodo<T> nuevoNodo= new Nodo<T>(dato, head);
        head= nuevoNodo;
        
    }


    
}
