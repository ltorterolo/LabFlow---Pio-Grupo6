package org.example.TDAs;





public class Cola<T> extends ListaEnlazada<T> implements TDACola<T>  {
    public Nodo<T> tail;
    protected int size = 0; //tuvimos que crear un nuevo size porque no heredaba bien de lista enlazada.
    
    @Override
    public T frente() throws java.util.NoSuchElementException {
        if (this.esVacio()){
            throw new java.util.NoSuchElementException("La cola esta vacia");
        }
        return head.dato;
    }


    @Override
    public boolean poneEnCola(T dato) {
        Nodo<T> nodoNuevo = new Nodo<T>(dato, null);
        if (tail == null){
            tail = nodoNuevo;
            this.head = nodoNuevo;
        }
        else{
            tail.siguiente = nodoNuevo;
            tail = nodoNuevo;
        }
        this.size++;
        return tail.siguiente == null;
    }

    @Override
    public T quitaDeCola() throws java.util.NoSuchElementException {
        if (this.esVacio()){
            throw new java.util.NoSuchElementException("La cola esta vacia");
        }
        Nodo<T> nodoEliminado = head;
        head = head.siguiente;

        if (head == null){
        tail = null;
        }

        nodoEliminado.siguiente = null;
        this.size--;
        return nodoEliminado.dato;
    }

    public Nodo<T> devolverPrimero()
    {
        return head;
    }

    public int devolverTamano(){
        return this.size;
    }
   

}
