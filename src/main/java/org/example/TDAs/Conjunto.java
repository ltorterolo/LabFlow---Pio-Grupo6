package org.example.ejercicio24;

import org.example.Ejercicio17.ListaEnlazada;
import org.example.Ejercicio17.Nodo;
import org.example.Ejercicio17.TDAConjunto;

public class Conjunto<T extends Comparable<T>> extends ListaEnlazada<T> implements TDAConjunto<T>{
    public Conjunto() {
    }
    
    @Override
    public TDAConjunto<T> union(TDAConjunto<T> otrConjunto){
        TDAConjunto<T> resultado= new Conjunto<>();
        Nodo<T> nodoActual=this.head;
            // Agrega los elementos del primer conjunto al resultado
        while (nodoActual!= null){
            resultado.agregar(nodoActual.dato);
            nodoActual=nodoActual.siguiente;
        }
        Nodo<T> otroNodo= ((Conjunto<T>) otrConjunto).head;
            // Agrega los elementos del segundo conjunto al resultado, evitando duplicados
        while (otroNodo!= null){
            if (!resultado.contiene(otroNodo.dato)){
                resultado.agregar(otroNodo.dato);
            }
            otroNodo=otroNodo.siguiente;


        }
        return resultado;
    }
    
    public TDAConjunto<T> interseccion(TDAConjunto<T> otrConjunto){
        TDAConjunto<T> resultado =new Conjunto<>();
        Nodo<T> nodoActual=this.head;
        while(nodoActual!=null){
            T datoActual = nodoActual.dato;
            if (otrConjunto.buscar(x -> x.equals(datoActual)) != null){
                resultado.agregar(nodoActual.dato);
            }
            nodoActual=nodoActual.siguiente;
        }
        return resultado;
    }
    
    public TDAConjunto<T> diferencia (TDAConjunto<T> otrConjunto){
        TDAConjunto<T> resultado= new Conjunto<>();
        Nodo<T> nodoActual=this.head;
        while (nodoActual!=null){
            T datoActual = nodoActual.dato;
            if (otrConjunto.buscar(x -> x.equals(datoActual))== null){
                resultado.agregar(nodoActual.dato);
            }
            nodoActual=nodoActual.siguiente;
        }
        return resultado;
    }
    
    public boolean esSubconjuntoDe(TDAConjunto<T> otrConjunto){
        Nodo<T> nodoActual= this.head;
        while (nodoActual!=null){
            if(!otrConjunto.contiene(nodoActual.dato)){
                return false;
            }
            nodoActual=nodoActual.siguiente;
        }
        return true;
    }
}
